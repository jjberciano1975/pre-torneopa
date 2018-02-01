package com.paises.ztorneopa;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class Torneopa
 */
public class Torneopa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static void Createuser (PrintWriter pw){ 
		 String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	     String dbName = "BdPaises";
	     String dbParam = "create=true"; //Si la base de datos no existe, se creará una nueva
	   //  String dbDirectory = "\\Derby\\";
	  //   String dbDirectory = "jar";
	     String connectionURL = "jdbc:derby:"+ dbName + ";" + dbParam;
	     /*
	     Si no se especifica la ruta donde se creará la base de datos,
	     por defecto se creará en la misma carpeta donde se encuentra el derby.jar
	     En ese caso la cadena de conexió sería la siguiente:
	     String connectionURL = "jdbc:derby:" + dbName + ";" + dbParam;
	     */
	     Connection conn = null;
	     try{
	       Class.forName(driver);
	     } catch(java.lang.ClassNotFoundException e) {
	       e.printStackTrace();
	     }
	     try {
	    	 pw.println ("conn = DriverManager.getConnection(connectionURL);</br>");
	    	// connectionURL= "jdbc:derby://pre-torneopa.herokuapp.com/paises;create=true";
	    	 connectionURL= "jdbc:derby:BdPaises;create=true"; 
	    	 conn = DriverManager.getConnection(connectionURL);
	     
	      pw.println (" Statement st = conn.createStatement();</br>");
	       Statement st = conn.createStatement();
	       String sqlCreateTableUsers =
	              "CREATE TABLE users ( " +
	              "FirstName VARCHAR(20) NOT NULL, " +
	              "LastName VARCHAR(20) NOT NULL, " +
	              "idUser INTEGER NOT NULL CONSTRAINT idUser_PK PRIMARY KEY " +
	              ")";
	       st.execute(sqlCreateTableUsers);
	       pw.println("La base de datos '" + dbName + "' se ha creado correctamente");
	       
	       
	    st.executeUpdate("INSERT INTO users VALUES('Juan', 'Perez', 1)");
	    st.executeUpdate("INSERT INTO users VALUES('Renzo', 'Lopez', 2)");
	    st.executeUpdate("INSERT INTO users VALUES('Carla', 'Mendivil', 3)");       
	       
	       
	       
	     }  catch (Throwable e)  {
	    	 pw.println("Error al crear la base de datos '" + dbName + "'");
	       e.printStackTrace();
	      
	       pw.println(e.getLocalizedMessage());
	       
	       
	     } finally {
	       try { conn.close(); }
	       catch (Throwable t){}
	     }

	}   
	public static void Selectuser (PrintWriter pw){
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	     String dbName = "BdPaises";
	     String dbParam = "create=true"; //Si la base de datos no existe, se creará una nueva
	  //   String dbDirectory = "\\Derby\\";
	     String connectionURL = "jdbc:derby:" + dbName + ";" + dbParam;
	     
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
	    	   pw.println (rs.getString (1) + " " + rs.getString (2)+ " " + rs.getInt(3)); 
	       }
	       
	       
	       
	     }  catch (Throwable e)  {
	    	 pw.println("Error en la bd '" + dbName + "'");
	       e.printStackTrace();
	       pw.println( e.getStackTrace());
	     } finally {
	       try { conn.close(); }
	       catch (Throwable t){}
	     }
	}	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Torneopa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<Html><Head><Title>torneo pa</Title></Head>");
		pw.println("<BODY BGCOLOR=\"#CCBBAA\">");
		pw.println("<H2>Leyendo parametros desde un formulario html</H2><P>");
		pw.println("<UL>\n");
		pw.println("Te llamas " + request.getParameter("NOM") + "<BR>");
		pw.println("y tienes "  + request.getParameter("EDA") + " anios<BR>");
		//Createuser(pw);
		Selectuser(pw);
		
		pw.println("</BODY></Html>");
		pw.close();		
	}

}
