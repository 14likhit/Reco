package com.likhit.reco.ui.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.likhit.reco.data.models.ContentData;

import java.util.List;

public class ContentDataAdapter extends FragmentStatePagerAdapter {

    private List<ContentData> contentDataList;

    public ContentDataAdapter(FragmentManager fm, List<ContentData> contentDatas) {
        super(fm);
        this.contentDataList = contentDatas;
    }

    @Override
    public Fragment getItem(int i) {
        return ContentDataFragment.newInstance( contentDataList.get(i));
    }

    @Override
    public int getCount() {
        return contentDataList.size();
    }
}
