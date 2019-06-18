package com.likhit.reco.ui.home;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.likhit.reco.data.models.ContentData;

import java.util.List;

/**
 * ContentDataViewModel -> ViewModel to get Data from the repository
 * And pass it using LiveData.
 */

public class ContentDataViewModel extends AndroidViewModel {

    private ContentDataRepository contentDataRepository;

    public ContentDataViewModel(@NonNull Application application) {
        super(application);
        this.contentDataRepository = new ContentDataRepository();
    }

    /**
     * Call getContentDataList from repository and return Mutable Live Data List
     * to all the observers.
     * @return MutableLiveDataList of ContentData
     */
    public MutableLiveData<List<ContentData>> getContentDataList() {
        return contentDataRepository.getContentDataList();
    }
}
