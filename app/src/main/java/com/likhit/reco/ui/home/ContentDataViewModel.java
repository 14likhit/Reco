package com.likhit.reco.ui.home;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.likhit.reco.data.models.ContentData;

import java.util.List;

public class ContentDataViewModel extends AndroidViewModel {

    private ContentDataRepository contentDataRepository;

    public ContentDataViewModel(@NonNull Application application) {
        super(application);
        this.contentDataRepository = new ContentDataRepository();
    }

    public MutableLiveData<List<ContentData>> getContentDataList() {
        return contentDataRepository.getContentDataList();
    }
}
