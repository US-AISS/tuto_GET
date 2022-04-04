package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.omdb.MovieSearch;

public class OMDbResource {

	private static final String OMDB_API_KEY = "3fafaf3";
	private static final Logger log = Logger.getLogger(OMDbResource.class.getName());
	
	public MovieSearch getMovies(String query) throws UnsupportedEncodingException {

		String titulo = URLEncoder.encode(query, "UTF-8");
        
        String uri = "http://www.omdbapi.com/?apikey=" + OMDB_API_KEY + "+&s=" + titulo;
        
        log.log(Level.INFO, "URI: " + uri);

        ClientResource cr = new ClientResource(uri);
    	MovieSearch movieSearch = cr.get(MovieSearch.class);

        return movieSearch;
	}
}
