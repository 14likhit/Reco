package com.likhit.reco.ui.home;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

import com.likhit.reco.R;
import com.likhit.reco.base.BaseActivity;
import com.likhit.reco.data.ApiClient;
import com.likhit.reco.data.ApiService;
import com.likhit.reco.data.models.BaseResponse;
import com.likhit.reco.data.models.ContentData;
import com.likhit.reco.databinding.ActivityHomeBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    private ActivityHomeBinding binding;
    private List<ContentData> contentDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        setupToolbar("Home", false);

        getContent();
    }

    @Override
    protected void onDestroy() {
        binding.vpPager.removeOnPageChangeListener(this);
        super.onDestroy();
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
        ContentDataAdapter contentDataAdapter = new ContentDataAdapter(getSupportFragmentManager(), contentDataList);
        binding.vpPager.setAdapter(contentDataAdapter);
        binding.vpPager.addOnPageChangeListener(this);
        binding.tabLayout.setupWithViewPager(binding.vpPager, true);

    }

    private int getItem() {
        return binding.vpPager.getCurrentItem();
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
