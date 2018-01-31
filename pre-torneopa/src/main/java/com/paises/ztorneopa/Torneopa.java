package com.paises.ztorneopa;

import java.io.File;


import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;




/**
 * Servlet implementation class Torneopa
 */
public class Torneopa extends HttpServlet {
	
	public static void Selectuser (){
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	     String dbName = "iadDemoDerby";
	     String dbParam = "create=true"; //Si la base de datos no existe, se creará una nueva
	     String dbDirectory = "\\Derby\\";
	     String connectionURL = "jdbc:derby:"+dbDirectory + dbName + ";" + dbParam;
	     
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
	       }
	       
	       
	       
	     }  catch (Throwable e)  {
	       System.out.println("Error en la bd '" + dbName + "'");
	       e.printStackTrace();
	     } finally {
	       try { conn.close(); }
	       catch (Throwable t){}
	     }
	}
	public static void main(String[] args) throws ServletException, LifecycleException {
		  String webappDirLocation = "src/main/webapp/";
	        Tomcat tomcat = new Tomcat();
	        
	        String webPort = System.getenv("PORT");
	        if (webPort == null || webPort.isEmpty()) {
	            webPort = "8080";
	        }

	    //    tomcat.setPort(Integer.valueOf(webPort));

	        tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
	        System.out.println("configuring app with basedir: "
	                + new File("./" + webappDirLocation).getAbsolutePath());

	        tomcat.start();
	        tomcat.getServer().await();
	}
	
	private static final long serialVersionUID = 1L;
       
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
		
		Selectuser();
		

		pw.println("</BODY></Html>");
		pw.close();
	}

}
