package com.news.android.guardiannewsfeed.fragment;

public class MusicFragment extends ArticleFragment {

    private static final String TOPIC = "music";
    private static final int LOADER_ID = 3;

    protected String getTopic() {
        return TOPIC;
    }

    protected int getLoaderId() {
        return LOADER_ID;
    }
}