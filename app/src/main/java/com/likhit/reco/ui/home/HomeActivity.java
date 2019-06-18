package com.likhit.reco.ui.home;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;

import com.likhit.reco.R;
import com.likhit.reco.base.BaseActivity;
import com.likhit.reco.data.ApiClient;
import com.likhit.reco.data.ApiService;
import com.likhit.reco.data.models.BaseResponse;
import com.likhit.reco.data.models.ContentData;
import com.likhit.reco.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends BaseActivity {

    private ActivityHomeBinding binding;

    private List<ContentData> contentDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        if (contentDataList == null) {
            contentDataList = new ArrayList<>();
        }
        getContent();

    }

    private void getContent() {
        ApiService service = ApiClient.getRetrofitInstance().create(ApiService.class);
        final Call<BaseResponse> request = service.getContentData();
        request.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(@NonNull Call<BaseResponse> call, @NonNull Response<BaseResponse> response) {
                Log.e("API", String.valueOf(response.body()));
                contentDataList = response.body().getData();
                initView();
            }

            @Override
            public void onFailure(@NonNull Call<BaseResponse> call, @NonNull Throwable t) {
                Log.e("API", t.getMessage());
            }
        });
    }

    private void initView() {
        binding.swipePlaceHolderContentData.getBuilder()
                .setDisplayViewCount(3);
        for (ContentData contentData : contentDataList) {
            binding.swipePlaceHolderContentData.addView(new ContentDataCard(contentData, this, binding.swipePlaceHolderContentData));
        }
    }

}
