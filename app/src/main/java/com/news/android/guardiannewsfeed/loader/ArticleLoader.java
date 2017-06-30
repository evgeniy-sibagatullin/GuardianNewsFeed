package com.news.android.guardiannewsfeed.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.news.android.guardiannewsfeed.model.Article;
import com.news.android.guardiannewsfeed.utils.QueryUtils;

import java.util.List;

public class ArticleLoader extends AsyncTaskLoader<List<Article>> {

    private static final String GUARDIAN_API_REQUEST_URL_TEMPLATE =
            "http://content.guardianapis.com/search?q=%s&api-key=test";

    private String mTopic;

    public ArticleLoader(Context context, String topic) {
        super(context);
        mTopic = topic;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Article> loadInBackground() {
        QueryUtils queryUtils = new QueryUtils();
        String requestUrl = String.format(GUARDIAN_API_REQUEST_URL_TEMPLATE, mTopic);
        return queryUtils.fetchArticleData(requestUrl);
    }
}