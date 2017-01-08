package com.dianping.voice.http;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by wangzhengzi on 16/4/2.
 */
public abstract class HttpRequest<T> {

    /**
     * Default encoding for POST or PUT parameters.
     */
    private static final String DEFAULT_PARAMS_ENCODING = "UTF-8";

    /**
     * Supported request methods.
     */
    public interface Method {
        int DEPRECATED_GET_OR_POST = -1;
        int GET = 0;
        int POST = 1;
        int PUT = 2;
        int DELETE = 3;
        int HEAD = 4;
        int OPTIONS = 5;
        int TRACE = 6;
        int PATCH = 7;
    }

    /**
     * Request method of this request.  Currently supports GET, POST, PUT, DELETE, HEAD, OPTIONS,
     * TRACE, and PATCH.
     */
    private final int mMethod;

    /** URL of this request. */
    private String mBaseUrl;

    private RequestBody mRequestBody;

    /** Whether or not this request has been canceled. */
    private boolean mCanceled = false;

    private HttpResponse.HttpListener<T> mListener;


    /**
     * get request
     */
    public HttpRequest(String url) {
        mMethod = Method.GET;
        this.mBaseUrl = url;
    }

    /**
     * post or put or delete request
     */
    public HttpRequest(int method, String url, HashMap<String, String> params) {
        mMethod = method;
        this.mBaseUrl = url;
        mRequestBody = RequestBody.create(null, formBody(params));
    }

    /**
     * post files
     */
    public HttpRequest(String url, List<File> files, HashMap<String, String> maps) {
        if(files == null || files.size() == 0)
             throw new NullPointerException("file cannot be null");
        mMethod = Method.POST;
        this.mBaseUrl = url;
        MultipartBody.Builder builder = new MultipartBody.Builder();
        for(int i=0; i<files.size(); i++){
            File file = files.get(i);
            RequestBody fileBody = RequestBody.create(null, file);
            //TODO 根据文件名设置contentType
            builder.addPart(fileBody);
        }
        mRequestBody = builder.build();
    }


    /**
     * Subclasses must implement this to parse the raw network response
     * and return an appropriate response type. This method will be
     * called from a worker thread.  The response will not be delivered
     * if you return null.
     * @param response Response from the network
     * @return The parsed response, or null in the case of an error
     */
    abstract protected HttpResponse<T> parseNetworkResponse(String response) throws Exception;


    public void setListener(HttpResponse.HttpListener<T> listener){
        mListener = listener;
    }

    protected void deliverResponse(T response) {
        if(mListener != null)
            mListener.onResponse(response);
    }

    public void deliverError(Exception error) {
        if (mListener != null) {
            mListener.onError(error);
        }
    }




    /**
     * Return the method for this request.
     */
    public int getMethod() {
        return mMethod;
    }

    /**
     * Returns the URL of this request.
     */
    public String getURL(){
        return mBaseUrl;
    }

    /**
     * Mark this request as canceled.  No callback will be delivered.
     */
    public void cancel() {
        mCanceled = true;
    }

    /**
     * Returns true if this request has been canceled.
     */
    public boolean isCanceled() {
        return mCanceled;
    }


    public Headers getHeaders(){
        TreeMap<String, String> headers = new TreeMap<String, String>();
        return Headers.of(headers);
    }

    private String formBody(HashMap<String, String> params){
        if(params == null)
            return null;
        StringBuilder strB = new StringBuilder();
        Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (entry != null) {
                strB.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        if(strB.length() > 1)
            strB.deleteCharAt(strB.length()-1);
        return strB.toString();
    }



    public RequestBody getRequestBody(){
        return mRequestBody;
    }


}
