package com.umeng.soexample.net;

import android.util.Log;

import java.io.IOException;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class HttpUtils {


    private BaseService baseService;

    public HttpUtils() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        String method = request.method();
                        String host = request.url().host();
                        Log.i("intercept", method + "+++" + host);
                        return chain.proceed(request);
                    }
                })
                .build();
        //初始化retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                //适配器工厂
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://www.zhaoapi.cn/")
                .build();
        baseService = retrofit.create(BaseService.class);

    }

    private static HttpUtils httpUtils;

    public static HttpUtils getHttpUtils() {

        if (httpUtils == null) {
            httpUtils = new HttpUtils();
        }

        return httpUtils;
    }

    //get请求
    public HttpUtils get(String url, Map<String, String> map) {
        baseService.get(url, map)
                //设置调度器
                .subscribeOn(Schedulers.io())
                //主线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        return this;

    }

    //post请求
    public HttpUtils post(String url, Map<String, String> map) {
        baseService.get(url, map)
                //设置调度器
                .subscribeOn(Schedulers.io())
                //主线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        return this;

    }

    //观察者
    private Observer observer = new Observer<ResponseBody>() {

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(ResponseBody responseBody) {
            try {
                String data = responseBody.string();
                listener.success(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(Throwable e) {
            String message = e.getMessage();
            listener.error(message);
        }

        @Override
        public void onComplete() {

        }
    };

    private HttpListener listener;

    public void result(HttpListener listener) {
        this.listener = listener;
    }

    public interface HttpListener {
        void success(String data);

        void error(String error);

    }
}
