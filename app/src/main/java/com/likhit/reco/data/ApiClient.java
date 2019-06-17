package com.likhit.reco.data;

import com.likhit.reco.data.convertor.PreprocessGsonConvertor;

import retrofit2.Retrofit;

public class ApiClient {

    private static Retrofit retrofit;

    private static final String base_url = "https://gist.githubusercontent.com";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(PreprocessGsonConvertor.create())
                    .build();
        }
        return retrofit;
    }

}
