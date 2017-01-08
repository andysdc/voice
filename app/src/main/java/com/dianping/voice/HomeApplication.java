package com.dianping.voice;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;

/**
 * Created by wangzhengzi on 16/12/16.
 */

public class HomeApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init(){
        //fresco
        Fresco.initialize(this);
        SpeechUtility.createUtility(this, SpeechConstant.APPID +"=58527796");
    }
}
