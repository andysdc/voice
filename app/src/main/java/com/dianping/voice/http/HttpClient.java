package com.dianping.voice.http;

/**
 * Created by wangzhengzi on 16/4/2.
 */

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class HttpClient {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static HttpClient mInstance;

    private OkHttpClient mOkHttpClient;

    private Handler mDelivery;


    private HttpClient(){
        mOkHttpClient = new OkHttpClient();
        mDelivery = new Handler(Looper.getMainLooper());
    }


    public static HttpClient getInstance(){
        if (mInstance == null){
            synchronized (HttpClient.class){
                if (mInstance == null){
                    mInstance = new HttpClient();
                }
            }
        }
        return mInstance;
    }



    public void httpAsync(final HttpRequest request){
        switch (request.getMethod()){
            case HttpRequest.Method.GET:
                httpGetAsync(request);
                break;
            case HttpRequest.Method.POST:
                httpPostAsync(request);
                break;
            //TODO
            case HttpRequest.Method.PUT:
                break;
        }
    }

    /**
     * 异步Get请求
     */
    private void httpGetAsync(final HttpRequest request){
        Request OkRequest = new Request.Builder()
                .url(request.getURL())
                .headers(request.getHeaders())
                .build();
        mOkHttpClient.newCall(OkRequest).enqueue(new Callback(){
            @Override
            public void onFailure(Call call, IOException e){
                HttpResponse<?> httpResponse = HttpResponse.error(e);
                deliveryResponse(httpResponse, request);
            }

            @Override
            public void onResponse(Call call, Response response){
                try{
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    String resp = response.body().string();
                    HttpResponse<?> httpResponse = request.parseNetworkResponse(resp);
                    deliveryResponse(httpResponse, request);
                }catch (Exception e){
                    HttpResponse<?> httpResponse = HttpResponse.error(e);
                    deliveryResponse(httpResponse, request);
                }
            }
        });

    }


    /**
     * 异步post请求
     * @return
     * @throws IOException
     */
    private void httpPostAsync(final HttpRequest request){
        Request okRequest = new Request.Builder()
                .url(request.getURL())
                .post(request.getRequestBody())
                .build();
        mOkHttpClient.newCall(okRequest).enqueue(new Callback(){
            @Override
            public void onFailure(Call call, IOException e){
                HttpResponse<?> httpResponse = HttpResponse.error(e);
                deliveryResponse(httpResponse, request);
            }

            @Override
            public void onResponse(Call call, Response response){
                try{
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    String resp = response.body().string();
                    HttpResponse<?> httpResponse = request.parseNetworkResponse(resp);
                    deliveryResponse(httpResponse, request);
                } catch (Exception e){
                    HttpResponse<?> httpResponse = HttpResponse.error(e);
                    deliveryResponse(httpResponse, request);
                }
            }
        });

    }

    /**
     * 同步Get请求
     * @return
     * @throws IOException
     */
    public String httpGetSync(HttpRequest urlGenerator) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(urlGenerator.getURL())
                .headers(urlGenerator.getHeaders())
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }


    /**
     * 同步Post请求
     * @return
     * @throws IOException
     */
    public String httpPostSync(HttpRequest urlGenerator) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(urlGenerator.getURL())
                .headers(urlGenerator.getHeaders())
                .post(urlGenerator.getRequestBody())
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }




    private void deliveryResponse(final HttpResponse response, final HttpRequest request){
        mDelivery.post(new Runnable(){
            @Override
            public void run(){
                if (response.isSuccess()) {
                    request.deliverResponse(response.result);
                } else {
                    request.deliverError(response.error);
                }
            }
        });
    }



}