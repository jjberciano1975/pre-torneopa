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
 public static void main(String[] args)  {
     String driver = "org.apache.derby.jdbc.EmbeddedDriver";
     String dbName = "BdPaises";
     String dbParam = "create=true"; //Si la base de datos no existe, se creara una nueva
 //    String dbDirectory = "\\Derby\\";
   //  String connectionURL = "jdbc:derby:"+dbDirectory + dbName + ";" + dbParam;
     String connectionURL = "jdbc:derby:" + dbName + ";" + dbParam;
     /*
     Si no se especifica la ruta donde se creará la base de datos,
     por defecto se creará en la misma carpeta donde se encuentra el derby.jar
     En ese caso la cadena de conexion sería la siguiente:
     String connectionURL = "jdbc:derby:" + dbName + ";" + dbParam;
     */
     Connection conn = null;
     try{
       Class.forName(driver);
    
     } catch(java.lang.ClassNotFoundException e) {
       e.printStackTrace();
     }
     try {
    	 
       conn = DriverManager.getConnection(connectionURL);
       Statement st = conn.createStatement();
       st.execute("drop table users ");
       String sqlCreateTableUsers =
              "CREATE TABLE users ( " +
              "name VARCHAR(30) NOT NULL, " +
              "email VARCHAR(30) NOT NULL, " +              
              "idUser INTEGER NOT NULL CONSTRAINT idUser_PK PRIMARY KEY " +
              ")";
       st.execute(sqlCreateTableUsers);
       System.out.println("La base de datos '" + dbName + "' se ha creado correctamente");
       
        
    st.executeUpdate("INSERT INTO users VALUES('Juan Perez', 'JuanPerez@lamoto.com', 1)");
    st.executeUpdate("INSERT INTO users VALUES('Renzo Lopez', 'RenzoLopez@lamoto.com', 2)");
    st.executeUpdate("INSERT INTO users VALUES('Carla Mendivil', 'CarlaMendivil@lamoto.com', 3)");       
       
    System.out.println("insert se ha hecho correctamente");
       
     }  catch (Throwable e)  {
       System.out.println("Error al crear la base de datos '" + dbName + "'");
       e.printStackTrace();
     } finally {
       try { conn.close(); }
       catch (Throwable t){}
     }

 }

}