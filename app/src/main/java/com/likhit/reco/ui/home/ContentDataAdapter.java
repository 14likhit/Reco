package com.likhit.reco.ui.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.likhit.reco.data.models.ContentData;

import java.util.List;

/**
 * ContentDataAdapter -> Adapter for the View Pager
 */
public class ContentDataAdapter extends FragmentStatePagerAdapter {

    private List<ContentData> contentDataList;

    public ContentDataAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (contentDataList != null) {
            return ContentDataFragment.newInstance(contentDataList.get(i));
        }
        return null;
    }

    @Override
    public int getCount() {
        if (contentDataList != null) {
            return contentDataList.size();
        }
        return 0;
    }

    /**
     * Setter to set received contentDataList
     * @param contentDataList
     */
    public void setContentDataList(List<ContentData> contentDataList) {
        this.contentDataList = contentDataList;
    }
}
