package com.dxc.assessment.dao;

import java.util.List;
import com.dxc.assessment.modal.Author;

public interface AuthorDao {
	public interface AuthorDao  {

	    private static final String INSERT_ONE_AUTHOR;

	    private static final String SELECT_ALL_AUTHOR;


	    private static final String USER_NAME;
	    private static final String PASSWORD;
	    private static final String URL;


	    static {
	        INSERT_ONE_AUTHOR = "INSERT INTO author (id,Genre ) VALUES (?, ?)";
	        SELECT_ALL_AUTHOR = "SELECT * FROM author";

	        USER_NAME = "root";
	        PASSWORD = "password";

	        // URL = "jdbc:mysql://server-name or server-ip-address:port/database-name";
	        URL = "jdbc:mysql://localhost:3306/dxc";
	    }

	    public AuthorDao() {

	    }

	    public List<Author> findAll() throws SQLException{
	        List<Author> author = null;
	        Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
	        Statement statement = connection.createStatement();
	        ResultSet rs = statement.executeQuery(SELECT_ALL_AUTHOR);
	        author = new ArrayList();
	        while (rs.next()) {
	            author.add(new Author(rs.getInt(1), rs.getString(2), rs.getString(3),);
	        }
	        rs.close();
	        statement.close();
	        connection.close();
	        return author;
	    }

	    public int save(Author author) throws SQLException {
	        System.out.println("Saving author: " + author);

	        // Load the JDBC Driver
	        // Automatically done for version 8 and above
	        // DriverManager.registerDriver(Driver.class);
	        // Class.forName("com.mysql.cj.jdbc.Driver");

	        // Get a connection to the database
	        Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

	        PreparedStatement ps = connection.prepareStatement(INSERT_ONE_AUTHOR);

	        ps.setString(1, book.getID());
	        ps.setString(2, book.getGenre());
	       
	        int rows = 0;
	        rows = ps.executeUpdate();

	        ps.close();
	        connection.close();

	        return rows;

	    }

	}
	

	    @Override
	    public int save(Author author) throws SQLException {
	        Connection connection = dataSource.getConnection();
	        PreparedStatement ps = connection.prepareStatement(INSERT_ONE_AUTHOR);
	        ps.setString(1, author.getId());
	        ps.setString(2, author.getFirst_Name());
	        ps.setString(3, author.getLast_Name());
	        ps.setString(3, author.getGenre());
	        ps.setString(3, author.getEmail());
	        int rows = 0;
	        rows = ps.executeUpdate();

	        ps.close();
	        connection.close();
	        return rows;
	        return null;
	    }

	    @Override
	    public Author findById(Long id) {
	        return null;
	    }

	    @Override
	    public List<Author> findByGenre(String genre) {
	        return null;
	    }

	        @Override
	        public List<Author> findAll() throws SQLException {
	   
	            Connection connection = dataSource.getConnection();
	            List<Author> authors;
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery(SELECT_ALL_AUTHOR);
	            authors = new ArrayList();
	            while (rs.next()) {
	                authors.add(new Author(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
	            }
	            rs.close();
	            statement.close();
	            connection.close();
	            return authors;
	        }
	        return null;
	    }
	..................app.java............
	package com.dxc;

	import java.sql.SQLException;
	import java.util.List;
	import com.dxc.dao.AuthorDao;
	import com.dxc.model.Author;

	/**
	 * Hello world!
	 *
	 */
	public class App {
	    public static void main(String[] args) {
	        findAllAuthors();
	    }

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

    Author create(Author author);

    Author findById(Long id);
    
    List<Author> findByGenre(String genre);

    List<Author> findAll();
    
}
