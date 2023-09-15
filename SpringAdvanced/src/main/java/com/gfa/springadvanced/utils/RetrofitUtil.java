package com.gfa.springadvanced.utils;

import com.gfa.springadvanced.constants.RetrofitConstant;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Component
public class RetrofitUtil {
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {

            retrofit = new Retrofit.Builder().baseUrl(RetrofitConstant.BASE_URL)

                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}

/*            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(new Interceptor() {
                @Override
               create interceptor class!!!!
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    HttpUrl originalHttpUrl = original.url();

                    HttpUrl url = originalHttpUrl.newBuilder()
                            .addQueryParameter("api_key", "eaba4dbb76a3b2fed7844f2747b12507")
                            .build();
                    // Request customization: add request headers
                    Request.Builder requestBuilder = original.newBuilder().url(url);

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });*/