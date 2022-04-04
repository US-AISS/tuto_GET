package aiss.model.resources;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;

import aiss.model.googleBooks.BookSearch;
import aiss.model.googleBooks.Item;

public class GoogleBooksTest {

    @Test
	public void getMoviesTest() throws UnsupportedEncodingException {
		String title = "star wars";
		GoogleBooksResource gbR = new GoogleBooksResource();
		BookSearch gbResults = gbR.getBooks(title);
		List<Item> books = gbResults.getItems();
		
		
		assertNotNull("The search returned null", gbResults);
		assertNotNull("The search returned null", books);
		assertNotEquals("The number of albums of " + title + " is zero", books.size(), 0);
		
		System.out.println("The search for " + title + " returned " + books.size() + " books:");
		
		//Print movies data
		for(Item item : books) {
            var book = item.getVolumeInfo();
			System.out.println("********** Book title: " + book.getTitle() + " **********");
            System.out.println("Number of pages: " + book.getPageCount());
            System.out.println("Print type: " + book.getPrintType());

		}
	
	}
}
