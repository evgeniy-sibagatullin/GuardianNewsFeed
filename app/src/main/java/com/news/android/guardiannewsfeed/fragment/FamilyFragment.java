package com.news.android.guardiannewsfeed.fragment;

public class FamilyFragment extends ArticleFragment {

    private static final String TOPIC = "family";
    private static final int LOADER_ID = 1;

    protected String getTopic() {
        return TOPIC;
    }

    protected int getLoaderId() {
        return LOADER_ID;
    }
}