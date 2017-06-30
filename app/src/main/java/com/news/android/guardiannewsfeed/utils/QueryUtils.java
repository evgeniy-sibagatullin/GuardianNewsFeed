package com.news.android.guardiannewsfeed.utils;

import android.util.Log;

import com.news.android.guardiannewsfeed.model.Article;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public final class QueryUtils {

    private static final String LOG_TAG = QueryUtils.class.getSimpleName();
    private static final String RESPONSE = "response";
    private static final String RESULTS = "results";
    private static final String TITLE = "webTitle";
    private static final String SECTION = "sectionName";
    private static final String PUBLICATION_DATE = "webPublicationDate";
    private static final String WEB_URL = "webUrl";

    public ArrayList<Article> fetchArticleData(String requestUrl) {
        URL url = createUrl(requestUrl);

        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        return extractArticles(jsonResponse);
    }

    private URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL ", e);
        }
        return url;
    }

    private String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);
        } finally {
            if (urlConnection != null) urlConnection.disconnect();
            if (inputStream != null) inputStream.close();
        }

        return jsonResponse;
    }

    private String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    private ArrayList<Article> extractArticles(String articlesJSON) {
        ArrayList<Article> articles = new ArrayList<>();

        if (articlesJSON == null) return articles;

        try {
            JSONObject baseJsonResponse = new JSONObject(articlesJSON).getJSONObject(RESPONSE);
            JSONArray resultsArticleArray = baseJsonResponse.getJSONArray(RESULTS);

            for (int i = 0; i < resultsArticleArray.length(); i++) {
                try {
                    JSONObject currentArticle = resultsArticleArray.getJSONObject(i);
                    String title = currentArticle.getString(TITLE);
                    String section = currentArticle.getString(SECTION);
                    String publicationDate = currentArticle.getString(PUBLICATION_DATE);
                    String webUrl = currentArticle.getString(WEB_URL);
                    articles.add(new Article(title, section, publicationDate, webUrl));
                } catch (JSONException e) {
                    Log.e(LOG_TAG, "Problem parsing the article JSON", e);
                }
            }
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Problem getting the article JSON response results", e);
        }

        return articles;
    }
}