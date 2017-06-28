package com.news.android.guardiannewsfeed.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.news.android.guardiannewsfeed.R;
import com.news.android.guardiannewsfeed.model.Article;

import java.util.List;

public class ArticleAdapter extends ArrayAdapter<Article> {

    public ArticleAdapter(@NonNull Context context, @NonNull List<Article> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.article_list_item, parent, false);
        }

        Article article = getItem(position);

        if (article != null) {
            TextView title = (TextView) listItemView.findViewById(R.id.title);
            title.setText(article.getTitle());

            TextView section = (TextView) listItemView.findViewById(R.id.section);
            section.setText(article.getSection());

            TextView publicationDate = (TextView) listItemView.findViewById(R.id.publicationDate);
            publicationDate.setText(article.getPublicationDate());
        }

        return listItemView;
    }
}