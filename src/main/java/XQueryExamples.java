import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQSequence;

import net.sf.saxon.xqj.SaxonXQDataSource;



public class XQueryExamples {
	
	String xml_file = getClass().getResource("dblp_curated_sample.xml").toExternalForm();
	
	public static void main(String[] args) {
		
		 /* There are 4 kinds of publications:
		  * article: refers to a Journal or Magazine Article
		  * inproceedings: refers to a publication in a Conference or Workshop Proceedings
		  * incollection: refers to a chapter in a collection (book)
		  * book: refers to a Book
		  */ 
		
		String publication_type = "article";
		
		String author_name = "Robert Stevens";
		
		
		XQueryExamples obj = new XQueryExamples();
				
		//obj.getListOfAuthors();
		
		//obj.getPublicationsByAuthor(author_name);
		
		//obj.getNumberOfPublicationsByAuthor(author_name);
		
		//obj.getNumberOfPublicationsByType(publication_type);
		
		obj.getNumberOfPublicationsByTypeAndByAuthor(publication_type, author_name);
		



	}
	
	





	/*
	 * The following method returns the ordered list of authors
	 */	
	public void getListOfAuthors(){
		
		String query = "for $x in fn:distinct-values(doc(\"" +xml_file+ "\")//author) " +
						"order by $x "+
						"return $x";
				
		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();
			
			
			XQSequence seq = exp.executeQuery(query);
			int i = 1;
			
			System.out.println("List of authors:");
			System.out.println("==================");
			
			while (seq.next()) {
				i++;
				System.out.println(seq.getAtomicValue());
			}
			
			System.out.println("\n== Total number of authors is "+i+" ==");
			
			seq.close();
			
		} catch (XQException err) {
        System.out.println("Failed as expected: " + err.getMessage());
		}
	}
	
	
	/*
	 * The following method returns the publications of a given author
	 */	
	public void getPublicationsByAuthor(String author_name){
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp/* " +
						"where $x/author = '"+author_name+"' "+
						"return $x";
				
		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();
			
			
			XQSequence seq = exp.executeQuery(query);			
			System.out.println("List of publications of "+author_name);
			System.out.println("======================================");
			
			System.out.println(seq.getSequenceAsString(null));
			
			seq.close();
			
		} catch (XQException err) {
        System.out.println("Failed as expected: " + err.getMessage());
		}
	}
	
	
	/*
	 * The following method returns the number of publications of a given author
	 */	
	public void getNumberOfPublicationsByAuthor(String author_name){
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
						"return count(for $y in $x/* where $y/author = '"+author_name+"' return 1)";
				
				
		try{
			XQDataSource ds = new SaxonXQDataSource();
			XQConnection conn = ds.getConnection();
			XQExpression exp = conn.createExpression();
			
			
			XQSequence seq = exp.executeQuery(query);			
			System.out.println("List of publications of "+author_name);
			System.out.println("======================================");
			
			seq.next();
			
			System.out.println("Number of publications of "+author_name+" is "+seq.getInt());
						
			seq.close();
			
		} catch (XQException err) {
        System.out.println("Failed as expected: " + err.getMessage());
		}
	}
	
	
	/*
	 * This method returns the number of publications per type 
	 */
	private void getNumberOfPublicationsByType(String publication_type) {
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
				"return count(for $y in $x/"+publication_type+" return 1)";
				
		try{
				XQDataSource ds = new SaxonXQDataSource();
				XQConnection conn = ds.getConnection();
				XQExpression exp = conn.createExpression();
	
	
				XQSequence seq = exp.executeQuery(query);
				
				seq.next();
				System.out.println("\n== Total number of publications of type "+publication_type+" is "+ seq.getInt());
	
				seq.close();
	
		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
		}
		
	}
	
	
	/*
	 * This method returns the number of publications by type and by author
	 */
	public int getNumberOfPublicationsByTypeAndByAuthor(String publication_type, String author_name) {
		
		String query = "for $x in doc(\"" +xml_file+ "\")/dblp " +
				"return count(for $y in $x/"+publication_type+" where $y/author = '"+author_name+"' return 1)";
				
		try{
				XQDataSource ds = new SaxonXQDataSource();
				XQConnection conn = ds.getConnection();
				XQExpression exp = conn.createExpression();
	
	
				XQSequence seq = exp.executeQuery(query);
				try {
					seq.next();
					int numPublications = seq.getInt();
					System.out.println("\n== Total number of publications of type "+publication_type+" by "+author_name+" is "+ numPublications);
					return numPublications;
				} finally { 
					seq.close();
				}
	
		} catch (XQException err) {
			System.out.println("Failed as expected: " + err.getMessage());
			// FIXME: Throw an exception
			return -1;
		}
		
	}

	

}
