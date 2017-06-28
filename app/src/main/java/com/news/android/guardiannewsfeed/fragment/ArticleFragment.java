package com.news.android.guardiannewsfeed.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.news.android.guardiannewsfeed.R;
import com.news.android.guardiannewsfeed.adapter.ArticleAdapter;
import com.news.android.guardiannewsfeed.model.Article;

import java.util.List;

public abstract class ArticleFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.article_list_fragment, container, false);

        final List<Article> articles = getArticles();

        ArticleAdapter articleAdapter = new ArticleAdapter(getActivity(), articles);
        ListView listView = (ListView) rootView.findViewById(R.id.article_list);
        listView.setAdapter(articleAdapter);

        return rootView;
    }

    protected abstract List<Article> getArticles();
}