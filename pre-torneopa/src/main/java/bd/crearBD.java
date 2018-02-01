package bd;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author www.imagineanddo.com
 *
 */
public class crearBD {

 /**
  * @param args
 * @throws IllegalAccessException 
 * @throws InstantiationException 
  */
 public static void main(String[] args) throws InstantiationException, IllegalAccessException {
     String driver = "org.apache.derby.jdbc.EmbeddedDriver";
     String dbName = "paises";
     String dbParam = "create=true"; //Si la base de datos no existe, se creará una nueva
 //    String dbDirectory = "\\Derby\\";
   //  String connectionURL = "jdbc:derby:"+dbDirectory + dbName + ";" + dbParam;
     String connectionURL = "jdbc:derby:" + dbName + ";" + dbParam;
     /*
     Si no se especifica la ruta donde se creará la base de datos,
     por defecto se creará en la misma carpeta donde se encuentra el derby.jar
     En ese caso la cadena de conexió sería la siguiente:
     String connectionURL = "jdbc:derby:" + dbName + ";" + dbParam;
     */
     Connection conn = null;
     try{
       Class.forName(driver).newInstance();
    
     } catch(java.lang.ClassNotFoundException e) {
       e.printStackTrace();
     }
     try {
    	 
       conn = DriverManager.getConnection(connectionURL);
       Statement st = conn.createStatement();
       String sqlCreateTableUsers =
              "CREATE TABLE users ( " +
              "FirstName VARCHAR(20) NOT NULL, " +
              "LastName VARCHAR(20) NOT NULL, " +
              "idUser INTEGER NOT NULL CONSTRAINT idUser_PK PRIMARY KEY " +
              ")";
       st.execute(sqlCreateTableUsers);
       System.out.println("La base de datos '" + dbName + "' se ha creado correctamente");
       
       
    st.executeUpdate("INSERT INTO users VALUES('Juan', 'Perez', 1)");
    st.executeUpdate("INSERT INTO users VALUES('Renzo', 'Lopez', 2)");
    st.executeUpdate("INSERT INTO users VALUES('Carla', 'Mendivil', 3)");       
       
       
       
     }  catch (Throwable e)  {
       System.out.println("Error al crear la base de datos '" + dbName + "'");
       e.printStackTrace();
     } finally {
       try { conn.close(); }
       catch (Throwable t){}
     }

 }

}