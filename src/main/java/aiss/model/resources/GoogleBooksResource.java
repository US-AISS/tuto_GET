package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.googleBooks.BookSearch;

public class GoogleBooksResource {

    private static final String GOOGLE_BOOKS_API_KEY = "AIzaSyDvVywDzx9cnZO-fTTEbJDq602SXK09D6w";		// TODO: Change this API KEY for your personal Key
	private static final Logger log = Logger.getLogger(FlickrResource.class.getName());


	public BookSearch getBooks(String title) throws UnsupportedEncodingException{
		String titulo = URLEncoder.encode(title, "UTF-8");
        
        String uri = "https://www.googleapis.com/books/v1/volumes?q=" + titulo + "+intitle:keyes&key=" + GOOGLE_BOOKS_API_KEY;
        
        log.log(Level.INFO, "URI: " + uri);

        ClientResource cr = new ClientResource(uri);
    	BookSearch photoSearch = cr.get(BookSearch.class);

        return photoSearch;
	}
}
