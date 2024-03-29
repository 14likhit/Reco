package com.likhit.reco.ui.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.likhit.reco.data.models.ContentData;
import com.likhit.reco.databinding.FragmentContentDataBinding;

/**
 * ContentDatFragment-> Fragment for the ViewPager.
 */

public class ContentDataFragment extends Fragment {

    private static final String TAG = "ContentDataFragment";

    private static final String CONTENT_DATA = "content_data";

    private FragmentContentDataBinding binding;

    private ContentData contentData;

    public ContentDataFragment() {
        // Required empty public constructor
    }

    /**
     * Creates instance of itself with input param of ContentData to be shown.
     * @param contentData -> Data to be shown
     * @return fragment instance of itself.
     */
    public static ContentDataFragment newInstance(ContentData contentData) {
        ContentDataFragment fragment = new ContentDataFragment();
        Bundle args = new Bundle();
        args.putSerializable(CONTENT_DATA, contentData);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentContentDataBinding.inflate(inflater, container, false);
        if (getArguments() != null) {
            this.contentData = (ContentData) getArguments().getSerializable(CONTENT_DATA);
        }
        binding.tvContentData.setText(this.contentData.getText());
        binding.tvPageNumber.setText(this.contentData.getId());
        return binding.getRoot();
    }

}
