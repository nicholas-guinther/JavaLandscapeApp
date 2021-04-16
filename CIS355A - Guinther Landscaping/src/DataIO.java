
import java.sql.*;
import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicholasguinther
 */
public class DataIO {
    
    private final String DATABASE_NAME = "cis355a";
    private final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    private final String USER_NAME = "root";
    private final String PASSWORD = "*23Wrangler*";
    
    public int addCustomer( Customer cust) throws ClassNotFoundException, SQLException{
        // check for driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // connect to database
        Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
        
        // add record
        String strSQL = "INSERT INTO landscape (CustomerName, CustomerAddress, "
                + "LandscapeType, YardLength, YardWidth, LandscapeCost) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(strSQL, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, cust.getName());
        pstmt.setString(2, cust.getAddress());
        pstmt.setString(3, cust.getYardType());
        pstmt.setDouble(4, cust.getLength());
        pstmt.setDouble(5, cust.getWidth());
        pstmt.setDouble(6, cust.getTotalCost());
        
        // execute the prepared statement
        pstmt.executeUpdate();
        
        // get the generated primary key
        ResultSet results = pstmt.getGeneratedKeys();
        int generatedID = -1;
        
        // get generated ID if possible
        if ( results.next()){
            generatedID = results.getInt(1);
        }
        
        // close the connection
        conn.close();
        
        return generatedID;
        
    }
    
    public void deleteCustomer(int CustomerID) throws SQLException{
       // connect to database
       Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
       
       // delete the record
       String strSQL = "DELETE FROM landscape WHERE CustomerID = ?";
       PreparedStatement pstmt = conn.prepareStatement(strSQL);
       pstmt.setInt(1, CustomerID);
       pstmt.execute();
       
       // close the database connection
       conn.close();
       
    }
    
    public ArrayList<Customer> getCustomers() throws SQLException{
        // create the ArrayList
        ArrayList<Customer> list = new ArrayList<Customer>();
        
        // connect to the database
        Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
        
        Statement stmt = conn.createStatement();
        String strSQL = "SELECT * FROM landscape";
        ResultSet rs = stmt.executeQuery(strSQL);
        
        while( rs.next()){
            // create Customer object and load the attributes
            Customer cust = new Customer();
            cust.setCustomerID(rs.getInt(1));
            cust.setName(rs.getString(2));
            cust.setAddress(rs.getString(3));
            cust.setYardType(rs.getString(4));
            cust.setLength(rs.getDouble(5));
            cust.setWidth(rs.getDouble(6));
            cust.setTotalCost(rs.getDouble(7));
            
            // add the Customer object to the ArrayList
            list.add(cust);
            
        }
        
        // close the database connection
        conn.close();
        
        // return the ArrayList
        return list;
    }
        
}
