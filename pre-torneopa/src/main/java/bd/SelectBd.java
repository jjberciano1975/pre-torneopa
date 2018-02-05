package bd;



import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import entities.Users;

/**
 * @author www.imagineanddo.com
 *
 */
public class SelectBd {

 /**
  * @param args
  */
 public static void main(String[] args) {
     String driver = "org.apache.derby.jdbc.EmbeddedDriver";
     String dbName = "BdPaises";
     String dbParam = "create=true"; //Si la base de datos no existe, se creará una nueva
  //   String dbDirectory = "\\Derby\\";
     String connectionURL = "jdbc:derby:"+ dbName + ";" + dbParam;
     
     Connection conn = null;
     try{
       Class.forName(driver);
     } catch(java.lang.ClassNotFoundException e) {
       e.printStackTrace();
     }
     try {
       conn = DriverManager.getConnection(connectionURL);
       Statement statement = conn.createStatement();
       ResultSet rs = statement.executeQuery("select * from users");
       
       while (rs.next()) 
       { 
           System.out.println (rs.getString (1) + " " + rs.getString (2)+ " " + rs.getInt(3));
           Users user =new Users(rs.getString (1), rs.getString (2), rs.getInt(3));
       }
       
       
       
     }  catch (Throwable e)  {
       System.out.println("Error en la bd '" + dbName + "'");
       e.printStackTrace();
     } finally {
       try { conn.close(); }
       catch (Throwable t){}
     }

 }

}