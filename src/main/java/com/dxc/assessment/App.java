package com.dxc.assessment;

/**
 * Hello world!
 *
 */
public class App 
{
	package com.dxc;

	import java.sql.SQLException;
	import java.util.List;
	import com.dxc.dao.AuthorDao;
	import com.dxc.model.Author;
	    static void findAllAuthors(){
	       
	        AuthorDao dao = new AuthorDao();
	        try {
	            List<Author> Authors = dao.findAll();
	            if (Authors.size() == 0) {
	                System.out.println("No Authors found");
	                return;
	            }
	            Authors.forEach(as -> System.out.println(as));
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.err.println(e.getMessage());
	        }

	    }

	    static void createAuthors() {
	        Author id = new Author("978-0-395-19395-8");
	        Author genre = new Author("comedy");
	       
	        List<Author> authors = List.of(id, genre);
	        AuthorDao authorDao = new AuthorDao();

	        books.forEach(as -> {
	            try {
	                int rows = AuthorDao.save(as);
	                System.out.println("Rows affected: " + rows);
	            } catch (SQLException e) {
	                e.printStackTrace();
	                System.err.println(e.getMessage());
	            }
	        });
	    }
	}
    public static void main( String[] args )
    {
       System.out.println( "Hello World!" );
    }
}
