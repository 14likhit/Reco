package com.likhit.reco.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ContentData implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("text")
    private String text;

    public ContentData(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
