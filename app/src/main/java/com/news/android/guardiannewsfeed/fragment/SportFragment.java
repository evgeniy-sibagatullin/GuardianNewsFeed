package com.news.android.guardiannewsfeed.fragment;

public class SportFragment extends ArticleFragment {

    private static final String TOPIC = "sport";
    private static final int LOADER_ID = 4;

    protected String getTopic() {
        return TOPIC;
    }

    protected int getLoaderId() {
        return LOADER_ID;
    }
}