package com.likhit.reco.ui.home;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.likhit.reco.data.ApiClient;
import com.likhit.reco.data.ApiService;
import com.likhit.reco.data.models.BaseResponse;
import com.likhit.reco.data.models.ContentData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ContentDataRepository -> Repository class to fetch data from server.
 * Initiates Retrofit service, enw=ques the request to getdata
 * Stores and returns the mutableLiveData
 */
public class ContentDataRepository {

    private MutableLiveData<List<ContentData>> contentDataList = new MutableLiveData<>();

    private ApiService service;

    public ContentDataRepository() {
        this.service = ApiClient.getRetrofitInstance().create(ApiService.class);
    }

    /**
     * Method to get content data from server.
     * @return MutableLiveData ContentDataList
     */
    public MutableLiveData<List<ContentData>> getContentDataList() {
        final Call<BaseResponse> request = service.getContentData();
        request.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse> call, @NonNull Response<BaseResponse> response) {
                Log.e("API", String.valueOf(response.body()));
                if (response.body() != null) {
                    contentDataList.setValue(response.body().getData());
                } else {
                    contentDataList.setValue(null);
                }
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse> call, @NonNull Throwable t) {
                Log.e("API", t.getMessage());
                contentDataList.setValue(null);
            }
        });
        return contentDataList;
    }

}
