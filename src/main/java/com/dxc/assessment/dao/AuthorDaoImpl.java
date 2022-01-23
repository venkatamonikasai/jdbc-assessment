package com.dxc.assessment.dao;

import java.util.List;
import com.dxc.assessment.modal.Author;
import java.util.List;
import com.dxc.assessment.modal.Author;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class AuthorDaoImpl implements AuthorDao{


        @Override
        public Author create(Author author) {
        	try{  
        		
        		conn =DriverManager.getConnection("jdbc:mysql://localhost/test?" +
        			                                   "user=minty&password=greatsqldb");
        		// Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
        		  
        		PreparedStatement stmt=conn.prepareStatement("insert into Author values(?,?,?,?,?)");  
        		stmt.setInt(1,10);//1 specifies the first parameter in the query  
        		stmt.setString(2,"abc"); 
        		stmt.setString(3,"bcd");  
        		stmt.setString(4,"abc");  
        		stmt.setString(5,"abc");  
        		  
        		int i=stmt.executeUpdate();  
        		System.out.println(i+" records inserted");  
        		  
        		conn.close();  
        		  
        		}catch(Exception e){ System.out.println(e);}  
        		  
        		}  
            return null;
        }

        @Override
        public Author findById(Long id) {
        	conn =
    				DriverManager.getConnection("jdbc:mysql://localhost/test?" +
    												"user=minty&password=greatsqldb");
        	pstmt = conn.prepareStatement( "SELECT * FROM Author WHERE ID=?"); 
        			                                  // Create a PreparedStatement object    1 
        			pstmt.setInt(1,10);      // Assign value to input parameter      2 

        			rs = pstmt.executeQuery();        // Get the result table from the query  3 
        			while (rs.next()) {               // Position the cursor                  4 
        			 int autId = rs.getInt(1);        // Retrieve the first column value
        			 String authFirstName = rs.getString(2);   
        			 String authLastName = rs.getString(3); 
        			 String authgenre = rs.getString(4); 
        			 String authEmail = rs.getString(5); 
        			 System.out.println("AutID = " + autId + "firstname = " + authFirstName + "lastname = " + authLastName + "genre = " + authgenre +"email = " + authEmail);
        			                                  // Print the column values
        			}
        			rs.close();                       // Close the ResultSet                  5 
        			pstmt.close();   
            return null;
        }

        @Override
        public List<Author> findByGenre(String genre) {
        	
        	pstmt = conn.prepareStatement( "SELECT * FROM Author WHERE genre=?"); 
      			                                  // Create a PreparedStatement object    1 
      			pstmt.setString(4,abc);      // Assign value to input parameter      2 

      			rs = pstmt.executeQuery();        // Get the result table from the query  3 
      			while (rs.next()) {               // Position the cursor                  4 
      			 int autId = rs.getInt(1);        // Retrieve the first column value
      			 String authFirstName = rs.getString(2);   
      			 String authLastName = rs.getString(3); 
      			 String authgenre = rs.getString(4); 
      			 String authEmail = rs.getString(5); 
      			 System.out.println("AutID = " + autId + "firstname = " + authFirstName + "lastname = " + authLastName + "genre = " + authgenre + "email = " + authEmail);
      			                                  // Print the column values
      			}
      			rs.close();                       // Close the ResultSet                  5 
      			pstmt.close();
            return null;
        }

        @Override
        public List<Author> findAll() {
        	pstmt = conn.prepareStatement("SELECT * FROM Author);   			                                  // Assign value to input parameter      2 
        			rs = pstmt.executeQuery();        // Get the result table from the query  3 
        			while (rs.next()) {               // Position the cursor                  4 
        			 int autId = rs.getInt(1);        // Retrieve the first column value
        			 String authFirstName = rs.getString(2);   
        			 String authLastName = rs.getString(3); 
        			 String authgenre = rs.getString(4); 
        			 String authEmail = rs.getString(5); 
        			 System.out.println("AutID = " + autId + "firstname = " + authFirstName + "lastname = " + authLastName + "genre = " + authgenre + "email = " + authEmail);
                                       // Print the column values
        			}
        			rs.close();              // Close the ResultSet                  5 
        			pstmt.close();
            return null;
        }
        
    }
    
   
    
    
    
    
    
    
