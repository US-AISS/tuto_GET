package aiss.model.resources;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;

import aiss.model.news.Article;
import aiss.model.news.NewsSearch;

public class NewsTest {

    @Test
    public void getHeadlines() throws UnsupportedEncodingException {
        String country = "us";
        String query = "USA TODAY";
        NewsResource news = new NewsResource();
        NewsSearch newsResults = news.getHeadlines(country, query);
        List<Article> articles = newsResults.getArticles();
        
        assertNotNull("The search returned null", newsResults);
        assertNotNull("The search returned null", articles);
        assertNotEquals("The number of news for [" + country + ", " + query + "] is zero", articles.size(), 0);
        
        System.out.println("Number of news for [" + country + ", " + query + "] is " + articles.size());
        // Prints the news
        for (Article article : articles) {
            System.out.println(article.getTitle());
            System.out.println(article.getDescription());
            System.out.println(article.getUrl());
            System.out.println(article.getUrlToImage());
            System.out.println(article.getPublishedAt());
            System.out.println("---------------------------------");
        }
    }   
}
