package com.news.android.guardiannewsfeed.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.news.android.guardiannewsfeed.R;
import com.news.android.guardiannewsfeed.adapter.ArticleAdapter;
import com.news.android.guardiannewsfeed.loader.ArticleLoader;
import com.news.android.guardiannewsfeed.model.Article;

import java.util.ArrayList;
import java.util.List;

public abstract class ArticleFragment extends Fragment
        implements LoaderManager.LoaderCallbacks<List<Article>> {

    private ArticleAdapter mArticleAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.article_list_fragment, container, false);
        mArticleAdapter = new ArticleAdapter(getActivity(), new ArrayList<Article>());
        final ArticleAdapter articleAdapter = mArticleAdapter;

        ListView listView = (ListView) rootView.findViewById(R.id.article_list);
        listView.setAdapter(articleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Article article = articleAdapter.getItem(position);

                if (article != null) {
                    String webUrl = article.getWebUrl();

                    if (webUrl != null && !webUrl.isEmpty()) {
                        Uri articleUri = Uri.parse(webUrl);
                        Intent websiteIntent = new Intent(Intent.ACTION_VIEW, articleUri);
                        startActivity(websiteIntent);
                    }
                }
            }
        });

        getLoaderManager().initLoader(getLoaderId(), null, this);

        return rootView;
    }

    @Override
    public ArticleLoader onCreateLoader(int id, Bundle args) {
        return new ArticleLoader(getContext(), getTopic());
    }

    @Override
    public void onLoadFinished(Loader<List<Article>> loader, List<Article> articles) {
        mArticleAdapter.clear();
        mArticleAdapter.addAll(articles);
    }

    @Override
    public void onLoaderReset(Loader<List<Article>> loader) {
        mArticleAdapter.clear();
    }

    protected abstract String getTopic();

    protected abstract int getLoaderId();
}