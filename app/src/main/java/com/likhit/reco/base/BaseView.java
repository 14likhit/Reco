package com.likhit.reco.base;

import android.support.annotation.StringRes;

public interface BaseView {

    void showMessage(String message);

    void showMessage(@StringRes int messageResId);

}

