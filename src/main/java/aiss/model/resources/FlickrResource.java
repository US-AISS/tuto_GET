package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.flickr.PhotoSearch;



public class FlickrResource {

	private static final String FLICKR_API_KEY = "d9575e6afa6689fa96a4eaf8a3dff666";		// TODO: Change this API KEY for your personal Key
	private static final Logger log = Logger.getLogger(FlickrResource.class.getName());


	public PhotoSearch getPhotos(String artist) throws UnsupportedEncodingException{
		String titulo = URLEncoder.encode(artist, "UTF-8");
        
        String uri = "https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key=" + FLICKR_API_KEY + "&text=" + titulo + "&format=json&nojsoncallback=1";
        
        log.log(Level.INFO, "URI: " + uri);

        ClientResource cr = new ClientResource(uri);
    	PhotoSearch photoSearch = cr.get(PhotoSearch.class);

        return photoSearch;
	}
}
