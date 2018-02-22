package lihuaizhan.youhbk.com.douyinsearch.network;

import lihuaizhan.youhbk.com.douyinsearch.api.SearchApi;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/2/22.
 */

public class RetrofitHelper {
    private static volatile OkHttpClient okHttpClient;
    private static volatile Retrofit retrofit;
    private static volatile SearchApi api;
    static {
        initHttp();
    }

    private static void initHttp() {
     if(okHttpClient == null)
     {
         synchronized (RetrofitHelper.class)
         {
             if(okHttpClient == null)
             {
                 okHttpClient = new OkHttpClient.Builder().build();
             }
         }
     }
    }
    public static SearchApi getApi() {
        if (api == null) {
            synchronized (SearchApi.class) {
                if (api == null) {
                    api = RetrofitHelper.create(SearchApi.class, Constants.BASE_URL);
                }
            }
        }
        return api;
    }
    private static <T> T create(Class<T> tClass, String baseUrl) {
        Retrofit re = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return re.create(tClass);
    }

}
