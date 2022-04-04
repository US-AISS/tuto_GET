package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.news.NewsSearch;


public class NewsResource {


    private static final String NEWS_API_KEY = "576a5e3e8b434f8591b47aa49dc1deeb";
    private static final Logger log = Logger.getLogger(NewsResource.class.getName());

    public NewsSearch getHeadlines(String count, String key) throws UnsupportedEncodingException {
            
        String country = URLEncoder.encode(count, "UTF-8");
        String keyWord = URLEncoder.encode(key, "UTF-8");
        
        String uri = "https://newsapi.org/v2/top-headlines?country="+country+"&q="+ keyWord + "&apiKey="+NEWS_API_KEY;
        
        log.log(Level.INFO, "URI: " + uri);

        ClientResource cr = new ClientResource(uri);
        NewsSearch newsSearch = cr.get(NewsSearch.class);

        return newsSearch;
    }
}