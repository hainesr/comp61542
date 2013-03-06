import static org.junit.Assert.*;

import org.junit.Test;


public class TestXQueryExamples {

	XQueryExamples examples = new XQueryExamples();

	@Test
	public void numberOfPublications() throws Exception {
		String publication_type = "article";
		String author_name = "Robert Stevens";		
		assertEquals(52, 
				examples.getNumberOfPublicationsByTypeAndByAuthor(publication_type, author_name));
	}
	
	@Test
	public void numberOfPublicationsUnknownAuthor() throws Exception {
		String publication_type = "article";
		String author_name = "Santa Claus";		
		assertEquals(0, 
				examples.getNumberOfPublicationsByTypeAndByAuthor(publication_type, author_name));
	}
	
	/*
	@Test
	public void numberOfPublicationsInvalidQuery() throws Exception {
		String publication_type = "article";
		String author_name = "Not 'escaped";		
		assertEquals(-1, 
				examples.getNumberOfPublicationsByTypeAndByAuthor(publication_type, author_name));
	}
	*/

	
}
