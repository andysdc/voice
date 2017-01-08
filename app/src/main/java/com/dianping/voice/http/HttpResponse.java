package com.dianping.voice.http;

/**
 * Created by wangzhengzi on 16/4/2.
 */
public class HttpResponse<T> {

    public interface HttpListener<T> {

        public void onError(Exception error);

        public void onResponse(T response);
    }

    //public HttpRequest<T> httpRequest;

    public T result;

    public Exception error;


    /** Returns a successful response containing the parsed result. */
    public static <T> HttpResponse<T> success(T result) {
        return new HttpResponse<T>(result);
    }

    /**
     * Returns a failed response containing the given error code and an optional
     * localized message displayed to the user.
     */
    public static <T> HttpResponse<T> error(Exception error) {
        return new HttpResponse<T>(error);
    }


    private HttpResponse(T result) {
        this.result = result;
        this.error = null;
    }

    private HttpResponse(Exception error) {
        this.result = null;
        this.error = error;
    }


    public T getResult(){
        return result;
    }


    public boolean isSuccess() {
        return error == null;
    }
}