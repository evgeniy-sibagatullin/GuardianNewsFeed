package com.news.android.guardiannewsfeed.model;

public class Article {

    private final String title;
    private final String section;
    private final String publicationDate;
    private final String webUrl;

    public Article(String title, String section, String publicationDate, String webUrl) {
        this.title = title;
        this.section = section;
        this.publicationDate = publicationDate;
        this.webUrl = webUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getSection() {
        return section;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getWebUrl() {
        return webUrl;
    }
}