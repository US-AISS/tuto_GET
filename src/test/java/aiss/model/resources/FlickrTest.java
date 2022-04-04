package aiss.model.resources;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;

import aiss.model.flickr.Photo;
import aiss.model.flickr.PhotoSearch;

public class FlickrTest {
    
    @Test
	public void getPhotoTest() throws UnsupportedEncodingException {
		String artist = "star wars";
		FlickrResource flickrR = new FlickrResource();
		PhotoSearch flickrResults = flickrR.getPhotos(artist);
		List<Photo> photos = flickrResults.getPhotos().getPhoto();
		
		
		assertNotNull("The search returned null", flickrResults);
		assertNotNull("The search returned null", photos);
		assertNotEquals("The number of albums of " + artist + " is zero", photos.size(), 0);
		
		System.out.println("The search for " + artist + "'s albums returned " + photos.size() + " photos.");

		//Print movies data
		for(Photo photo : photos) {
			System.out.println("Photo title: " + photo.getTitle());
		}
	
	}
}
