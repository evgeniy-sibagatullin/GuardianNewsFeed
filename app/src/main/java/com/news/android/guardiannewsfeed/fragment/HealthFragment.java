package com.news.android.guardiannewsfeed.fragment;

public class HealthFragment extends ArticleFragment {

    private static final String TOPIC = "health";
    private static final int LOADER_ID = 2;

    protected String getTopic() {
        return TOPIC;
    }

    protected int getLoaderId() {
        return LOADER_ID;
    }
}