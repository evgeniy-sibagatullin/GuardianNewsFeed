package com.news.android.guardiannewsfeed.fragment;

import com.news.android.guardiannewsfeed.model.Article;

import java.util.ArrayList;
import java.util.List;

public class FamilyFragment extends ArticleFragment {

    @Override
    protected List<Article> getArticles() {
        List<Article> articles = new ArrayList<>();

        articles.add(new Article("Gifted review â€“ touching family melodrama", "Film", "2017-06-18",
                "https://www.theguardian.com/film/2017/jun/18/gifted-film-marc-webb-chris-evans-review"));
        articles.add(new Article("Do friends make you happier than family?", "Life and style", "2017-06-12",
                "https://www.theguardian.com/lifeandstyle/2017/jun/12/does-family-make-you-happier-than-friends"));
        articles.add(new Article("Melodious encounter with a family of redstarts", "Environment", "2017-06-13",
                "https://www.theguardian.com/environment/2017/jun/13/melodious-encounter-family-redstarts-sussex"));
        articles.add(new Article("Why Iâ€™m making my family German", "Life and style", "2017-06-03",
                "https://www.theguardian.com/lifeandstyle/2017/jun/03/why-im-making-my-family-german"));
        articles.add(new Article("After the Storm review â€“ bittersweet family comedy", "Film", "2017-06-04",
                "https://www.theguardian.com/film/2017/jun/04/after-the-storm-review-bittersweet-family-comedy-hirokazu-koreeda"));
        articles.add(new Article("Family fun and fitness in Ibiza", "Travel", "2017-05-06",
                "https://www.theguardian.com/travel/2017/may/06/ibiza-family-fitness-holiday-decca-aitkenhead"));
        articles.add(new Article("Wines for a family gathering | David Williams", "Life and style", "2017-03-05",
                "https://www.theguardian.com/lifeandstyle/2017/mar/05/wines-for-family-gathering-gill-meller-david-williams"));

        return articles;
    }
}