package example.ss.com.commit1;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetData {
    public static volatile ApiService sApiService;
    private static ApiService sApiService1;

    public static ApiService getApiService(){
        if (sApiService == null) {
            synchronized (GetData.class){
                if (sApiService == null) {
                    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                    if (BuildConfig.DEBUG) {
                        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    }else {
                        interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
                    }
                    OkHttpClient build = new OkHttpClient.Builder()
                            .addInterceptor(interceptor)
                            .connectTimeout(2000,TimeUnit.SECONDS)
                            .readTimeout(2000,TimeUnit.SECONDS)
                            .writeTimeout(2000,TimeUnit.SECONDS)
                            .build();
                    Retrofit build1 = new Retrofit.Builder()
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .baseUrl(ApiService.mUrl)
                            .client(build)
                            .build();
                    sApiService1 = build1.create(ApiService.class);
                }
            }
        }
        return sApiService1;
    }
}
