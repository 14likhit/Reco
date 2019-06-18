package com.likhit.reco.ui.home;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.likhit.reco.R;
import com.likhit.reco.data.models.ContentData;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;

@Layout(R.layout.layout_content_card_view)
class ContentDataCard {

    @View(R.id.content_data_tv)
    TextView contentDataTextView;

    ContentData contentData;
    Context mContext;
    SwipePlaceHolderView mSwipeView;


    ContentDataCard() {
    }

    ContentDataCard(ContentData contentData, Context mContext, SwipePlaceHolderView mSwipeView) {
        this.contentData = contentData;
        this.mContext = mContext;
        this.mSwipeView = mSwipeView;
    }

    @Resolve
    void onResolved() {
        contentDataTextView.setText(contentData.getText());
    }

    @SwipeOut
    void onSwipedOut() {
        Log.d("EVENT", "onSwipedOut");
        mSwipeView.addView(this);
    }

    @SwipeCancelState
    void onSwipeCancelState() {
        Log.d("EVENT", "onSwipeCancelState");
    }

    @SwipeIn
    void onSwipeIn() {
        Log.d("EVENT", "onSwipedIn");
    }

    @SwipeInState
    void onSwipeInState() {
        Log.d("EVENT", "onSwipeInState");
    }

    @SwipeOutState
    void onSwipeOutState() {
        Log.d("EVENT", "onSwipeOutState");
    }

}
