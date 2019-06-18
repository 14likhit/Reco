package com.likhit.reco.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * BaseResponse -> Model Base Response
 */
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
