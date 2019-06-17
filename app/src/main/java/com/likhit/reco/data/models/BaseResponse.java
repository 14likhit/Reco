package com.likhit.reco.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseResponse {

    @SerializedName("data")
    private List<ContentData> data;

    public BaseResponse(List<ContentData> data) {
        this.data = data;
    }

    public List<ContentData> getData() {
        return data;
    }
}
