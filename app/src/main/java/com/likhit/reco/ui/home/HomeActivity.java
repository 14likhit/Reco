package com.likhit.reco.ui.home;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.likhit.reco.R;
import com.likhit.reco.base.BaseActivity;
import com.likhit.reco.data.models.ContentData;
import com.likhit.reco.databinding.ActivityHomeBinding;

import java.util.List;

public class HomeActivity extends BaseActivity implements ViewPager.OnPageChangeListener, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = "HomeActivity";

    private ActivityHomeBinding binding;
    private List<ContentData> contentDataList;
    private ContentDataViewModel contentDataViewModel;
    private ContentDataAdapter contentDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        setupToolbar("Home", false);

        contentDataViewModel = ViewModelProviders.of(this).get(ContentDataViewModel.class);
        getContent();
        initView();
    }

    @Override
    protected void onDestroy() {
        binding.vpPager.removeOnPageChangeListener(this);
        super.onDestroy();
    }

    @Override
    public void onRefresh() {
        getContent();
    }

    private void getContent() {
        binding.swipeRefresh.setRefreshing(true);
        contentDataViewModel.getContentDataList().observe(this, new Observer<List<ContentData>>() {
            @Override
            public void onChanged(@Nullable List<ContentData> contentData) {
                binding.swipeRefresh.setRefreshing(false);
                if (contentData != null) {
                    contentDataList = contentData;
                    updateView();
                } else {
                    showMessage(getString(R.string.error_message));
                }
            }
        });
    }

    private void initView() {
        binding.swipeRefresh.setOnRefreshListener(this);
        contentDataAdapter = new ContentDataAdapter(getSupportFragmentManager());
        binding.vpPager.setAdapter(contentDataAdapter);
        binding.vpPager.addOnPageChangeListener(this);
        binding.tabLayout.setupWithViewPager(binding.vpPager, true);
        binding.btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.vpPager.setCurrentItem(0);
            }
        });
    }

    private void updateView() {
        contentDataAdapter.setContentDataList(contentDataList);
        contentDataAdapter.notifyDataSetChanged();
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
