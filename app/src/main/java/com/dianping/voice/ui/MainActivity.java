package com.dianping.voice.ui;

import android.app.Activity;
import android.os.Environment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.dianping.voice.Const;
import com.dianping.voice.R;
import com.dianping.voice.data.DataLibrary;
import com.dianping.voice.data.Question;
import com.dianping.voice.data.Shop;
import com.dianping.voice.data.VoiceRecord;
import com.dianping.voice.http.HttpClient;
import com.dianping.voice.http.HttpRequest;
import com.dianping.voice.http.HttpResponse;
import com.dianping.voice.util.JsonParser;
import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MainActivity extends Activity implements View.OnClickListener{

    // 语音听写对象
    private SpeechRecognizer mIat;
    // 用HashMap存储听写结果
    private HashMap<String, String> mIatResults = new LinkedHashMap<String, String>();
    // 引擎类型
    private String mEngineType = SpeechConstant.TYPE_CLOUD;

    // 语音合成对象
    private SpeechSynthesizer mTts;

    // 默认发音人
//    private String voicer = "xiaoxin";

    // 缓冲进度
    private int mPercentForBuffering = 0;
    // 播放进度
    private int mPercentForPlaying = 0;


    private RecyclerView mRecyclerView;
    private VoiceAdapter mAdapter;

    private ArrayList<Object> mVoiceRecord = new ArrayList<>();

    //public

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initView();
    }

    private void init(){
        // 初始化识别无UI识别对象
        // 使用SpeechRecognizer对象，可根据回调消息自定义界面；
        mIat = SpeechRecognizer.createRecognizer(this, mInitListener);

        // 初始化合成对象
        mTts = SpeechSynthesizer.createSynthesizer(this, mTtsInitListener);
    }

    private void initView(){
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        mAdapter = new VoiceAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        findViewById(R.id.voice_start).setOnClickListener(this);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTts.stopSpeaking();
        // 退出时释放连接
        mTts.destroy();

        // 退出时释放连接
        mIat.cancel();
        mIat.destroy();
    }


    public void setIatParam() {
        // 清空参数
        mIat.setParameter(SpeechConstant.PARAMS, null);

        // 设置听写引擎
        mIat.setParameter(SpeechConstant.ENGINE_TYPE, mEngineType);
        // 设置返回结果格式
        mIat.setParameter(SpeechConstant.RESULT_TYPE, "json");

        // 设置语言
        mIat.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
        // 设置语言区域
        mIat.setParameter(SpeechConstant.ACCENT, "mandarin");

        // 设置语音前端点:静音超时时间，即用户多长时间不说话则当做超时处理
        mIat.setParameter(SpeechConstant.VAD_BOS, "4000");

        // 设置语音后端点:后端点静音检测时间，即用户停止说话多长时间内即认为不再输入， 自动停止录音
        mIat.setParameter(SpeechConstant.VAD_EOS, "800");

        // 设置标点符号,设置为"0"返回结果无标点,设置为"1"返回结果有标点
        mIat.setParameter(SpeechConstant.ASR_PTT, "1");

        // 设置音频保存路径，保存音频格式支持pcm、wav，设置路径为sd卡请注意WRITE_EXTERNAL_STORAGE权限
        // 注：AUDIO_FORMAT参数语记需要更新版本才能生效
        mIat.setParameter(SpeechConstant.AUDIO_FORMAT,"wav");
        mIat.setParameter(SpeechConstant.ASR_AUDIO_PATH, Environment.getExternalStorageDirectory()+"/msc/iat.wav");
    }

    private void setTtsParam(){
        // 清空参数
        mTts.setParameter(SpeechConstant.PARAMS, null);
        // 根据合成引擎设置相应参数
        if(mEngineType.equals(SpeechConstant.TYPE_CLOUD)) {
            mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD);
            // 设置在线合成发音人
            mTts.setParameter(SpeechConstant.VOICE_NAME, DataLibrary.voicer);
            //设置合成语速
            mTts.setParameter(SpeechConstant.SPEED, "50");
            //设置合成音调
            mTts.setParameter(SpeechConstant.PITCH, "50");
            //设置合成音量
            mTts.setParameter(SpeechConstant.VOLUME, "50");
        }else {
            mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_LOCAL);
            // 设置本地合成发音人 voicer为空voicer为空，默认通过语记界面指定发音人。
//            mTts.setParameter(SpeechConstant.VOICE_NAME, "");
            /**
             * TODO 本地合成不设置语速、音调、音量，默认使用语记设置
             * 开发者如需自定义参数，请参考在线合成参数设置
             */
        }
        //设置播放器音频流类型
        mTts.setParameter(SpeechConstant.STREAM_TYPE, "3");
        // 设置播放合成音频打断音乐播放，默认为true
        mTts.setParameter(SpeechConstant.KEY_REQUEST_FOCUS, "true");

        // 设置音频保存路径，保存音频格式支持pcm、wav，设置路径为sd卡请注意WRITE_EXTERNAL_STORAGE权限
        // 注：AUDIO_FORMAT参数语记需要更新版本才能生效
        mTts.setParameter(SpeechConstant.AUDIO_FORMAT, "wav");
        mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, Environment.getExternalStorageDirectory()+"/msc/tts.wav");
    }

    /**
     * 初始化监听器。
     */
    private InitListener mInitListener = new InitListener() {

        @Override
        public void onInit(int code) {
            //Log.d(TAG, "SpeechRecognizer init() code = " + code);
            if (code != ErrorCode.SUCCESS) {
                //showTip("初始化失败，错误码：" + code);
            }
        }
    };


    private InitListener mTtsInitListener = new InitListener() {
        @Override
        public void onInit(int code) {
            //Log.d(TAG, "InitListener init() code = " + code);
            if (code != ErrorCode.SUCCESS) {
                Toast.makeText(MainActivity.this, "初始化失败,错误码："+code, Toast.LENGTH_LONG).show();
            } else {
                // 初始化成功，之后可以调用startSpeaking方法
                // 注：有的开发者在onCreate方法中创建完合成对象之后马上就调用startSpeaking进行合成，
                // 正确的做法是将onCreate中的startSpeaking调用移至这里
            }
        }
    };

    /**
     * 听写监听器。
     */
    private RecognizerListener mRecognizerListener = new RecognizerListener() {

        @Override
        public void onVolumeChanged(int i, byte[] bytes) {
            Log.d("wzz", "onVolumeChanged");
        }

        @Override
        public void onBeginOfSpeech() {
            // 此回调表示：sdk内部录音机已经准备好了，用户可以开始语音输入
            Toast.makeText(MainActivity.this, "开始说话", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onError(SpeechError error) {
            // Tips：
            // 错误码：10118(您没有说话)，可能是录音机权限被禁，需要提示用户打开应用的录音权限。
            // 如果使用本地功能（语记）需要提示用户开启语记的录音权限。
            //showTip(error.getPlainDescription(true));
            Toast.makeText(MainActivity.this, error.getPlainDescription(true), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onEndOfSpeech() {
            // 此回调表示：检测到了语音的尾端点，已经进入识别过程，不再接受语音输入
            //showTip("结束说话");
            Toast.makeText(MainActivity.this, "结束说话", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onResult(RecognizerResult results, boolean isLast) {
            Log.d("wzz", "onResult"+results.getResultString());
            printResult(results);
            if (isLast) {
                StringBuffer resultBuffer = new StringBuffer();
                for (String key : mIatResults.keySet()) {
                    resultBuffer.append(mIatResults.get(key));
                }
//                startSpeak(DataLibrary.getAnswer(resultBuffer.toString()));
//                query(resultBuffer.toString());

                getResult(resultBuffer.toString());
                //语音记录不记录
//                mVoiceRecord.add(new Question(resultBuffer.toString()));
            }
        }

        @Override
        public void onEvent(int i, int i1, int i2, Bundle bundle) {

        }

    };


    private SynthesizerListener mTtsListener = new SynthesizerListener() {

        @Override
        public void onSpeakBegin() {
            //Toast.makeText(MainActivity.this, "开始播放", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onSpeakPaused() {
            //Toast.makeText(MainActivity.this, "暂停播放", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onSpeakResumed() {
            //Toast.makeText(MainActivity.this, "继续播放", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onBufferProgress(int percent, int beginPos, int endPos,
                                     String info) {
            // 合成进度
            mPercentForBuffering = percent;
            /*Toast.makeText(MainActivity.this, String.format(getString(R.string.tts_toast_format),
                    mPercentForBuffering, mPercentForPlaying), Toast.LENGTH_SHORT).show();*/
        }

        @Override
        public void onSpeakProgress(int percent, int beginPos, int endPos) {
            // 播放进度
            mPercentForPlaying = percent;
            /*Toast.makeText(MainActivity.this, String.format(getString(R.string.tts_toast_format),
                    mPercentForBuffering, mPercentForPlaying), Toast.LENGTH_SHORT).show();*/
        }

        @Override
        public void onCompleted(SpeechError error) {
            if (error == null) {
                //Toast.makeText(MainActivity.this, "播放完成", Toast.LENGTH_LONG).show();
            } else if (error != null) {
                Toast.makeText(MainActivity.this, error.getPlainDescription(true), Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onEvent(int eventType, int arg1, int arg2, Bundle obj) {
            // 以下代码用于获取与云端的会话id，当业务出错时将会话id提供给技术支持人员，可用于查询会话日志，定位出错原因
            // 若使用本地能力，会话id为null
            //	if (SpeechEvent.EVENT_SESSION_ID == eventType) {
            //		String sid = obj.getString(SpeechEvent.KEY_EVENT_SESSION_ID);
            //		Log.d(TAG, "session id =" + sid);
            //	}
        }
    };

    private void printResult(RecognizerResult results) {
        String text = JsonParser.parseIatResult(results.getResultString());
        Log.d("wzz", "printResult="+text);
        String sn = null;
        // 读取json结果中的sn字段
        try {
            JSONObject resultJson = new JSONObject(results.getResultString());
            sn = resultJson.optString("sn");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mIatResults.put(sn, text);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.voice_start:
                //mResText.setText(null);// 清空显示内容
                mIatResults.clear();
                setIatParam();
                int ret = mIat.startListening(mRecognizerListener);
                if (ret != ErrorCode.SUCCESS) {
                    Toast.makeText(MainActivity.this, "听写失败,错误码：" + ret, Toast.LENGTH_LONG).show();
                }

                Log.d("wzz", "voice_start");

                break;
            default:
                break;
        }
    }

    public void startSpeak(String str){
        setTtsParam();
        int code = mTts.startSpeaking(str, mTtsListener);
        if (code != ErrorCode.SUCCESS) {
            if(code == ErrorCode.ERROR_COMPONENT_NOT_INSTALLED){
                //未安装则跳转到提示安装页面
                //mInstaller.install();
            }else {
                Toast.makeText(MainActivity.this, "语音合成失败,错误码: " + code, Toast.LENGTH_LONG).show();
            }
        }
    }

    public String buildurl(String title){

        String url = Const.url +title;
        android.util.Log.d("wzz","url="+url);
        return url;
    }

    public void getResult(String key){
        VoiceRecord voiceRecord = new VoiceRecord();
        ArrayList<Shop> records = new ArrayList<>();
        Shop shop = new Shop();

        String answer = DataLibrary.getAnswer(key);

        String title = answer;
        if (answer.indexOf(":") >= 0) {
            title = answer.substring(0,answer.indexOf(":"));
        }
        shop.picUrl = DataLibrary.getImgUrl(title);
        if (title.contains("照片")) {
            shop.shopUrl = shop.picUrl;
        } else {
            shop.shopUrl = buildurl(title);
        }


//        shop._distance_ = "";
        shop.shopname = title;
//        shop.power = "10";
//        shop.avgprice = "100";
        records.add(shop);
        mVoiceRecord.add(records);

        mAdapter.setData(mVoiceRecord);
        mRecyclerView.smoothScrollToPosition(mVoiceRecord.size());
        startSpeak(answer);
    }

    public void query(String key){
        HttpRequest<String> urlGen = new HttpRequest<String>(buildurl(key)){
            @Override
            protected HttpResponse<String> parseNetworkResponse(String response) throws Exception{
                String jsonString = response;
                //String value = new JSONObject(jsonString).get("data").toString();
                return HttpResponse.success(jsonString);
            }
        };
        urlGen.setListener(httpListener);
        HttpClient manager = HttpClient.getInstance();
        manager.httpAsync(urlGen);
    }

//    public void outputResponse(String response) {
//        android.util.Log.d("wzz", response);
//        VoiceRecord voiceRecord = new VoiceRecord();
//        voiceRecord.praseJson(response);
//        mVoiceRecord.add(voiceRecord.records);
//        mVoiceRecord.add(voiceRecord.dialog);
//        mAdapter.setData(mVoiceRecord);
//        mRecyclerView.smoothScrollToPosition(mVoiceRecord.size());
//    }

    private HttpResponse.HttpListener httpListener = new HttpResponse.HttpListener<String>() {
        @Override
        public void onError(Exception response) {
            android.util.Log.d("wzz", response.getMessage());
        }

        @Override
        public void onResponse(String response) {
            android.util.Log.d("wzz", response);
            VoiceRecord voiceRecord = new VoiceRecord();
            voiceRecord.praseJson(response);
            if(voiceRecord.hasRecord())
                mVoiceRecord.add(voiceRecord.records);
            mVoiceRecord.add(voiceRecord.dialog);
            mAdapter.setData(mVoiceRecord);
            mRecyclerView.smoothScrollToPosition(mVoiceRecord.size());
            startSpeak(voiceRecord.dialog.answer);
        }
    };


}
