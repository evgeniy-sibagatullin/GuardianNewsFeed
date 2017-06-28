package com.news.android.guardiannewsfeed.fragment;

import com.news.android.guardiannewsfeed.model.Article;

import java.util.ArrayList;
import java.util.List;

public class HealthFragment extends ArticleFragment {

    @Override
    protected List<Article> getArticles() {
        List<Article> articles = new ArrayList<>();

        articles.add(new Article("Health and safety is no laughing matter | Letters", "Law", "2017-06-22",
                "https://www.theguardian.com/law/2017/jun/22/health-and-safety-is-no-laughing-matter"));
        articles.add(new Article("Five priorities for improving children's mental health | Paul Burstow",
                "Social Care Network", "2017-05-05",
                "https://www.theguardian.com/social-care-network/2017/may/05/five-priorities-childrens-mental-health"));

        return articles;
    }
}