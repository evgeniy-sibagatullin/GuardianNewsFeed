package com.news.android.guardiannewsfeed.fragment;

import com.news.android.guardiannewsfeed.model.Article;

import java.util.ArrayList;
import java.util.List;

public class MusicFragment extends ArticleFragment {

    @Override
    protected List<Article> getArticles() {
        List<Article> articles = new ArrayList<>();

        articles.add(new Article("Handel: Water Music CD review â€“ Cummings makes the music dance",
                "Music", "2017-04-23",
                "https://www.theguardian.com/music/2017/apr/23/handel-water-music-gottingen-festival-orchestra-laurence-cummings-alexanders-feast"));
        articles.add(new Article("Facing the music: Long Yu", "Music", "2017-05-01",
                "https://www.theguardian.com/music/2017/may/01/facing-the-music-conductor-long-yu"));
        articles.add(new Article("Music education must be properly funded | Letters", "Education", "2017-06-20",
                "https://www.theguardian.com/education/2017/jun/20/music-education-must-be-properly-funded"));

        return articles;
    }
}