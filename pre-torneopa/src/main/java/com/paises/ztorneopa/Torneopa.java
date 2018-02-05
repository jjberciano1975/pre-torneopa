package com.paises.ztorneopa;

import java.io.IOException;




import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Users;
import persistence.UsersCrud;


import java.util.List;

/**
 * Servlet implementation class Torneopa
 */
public class Torneopa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 //List<Users> users=null;
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
    
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		  //users =	UsersCrud.cargalista();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("hollq at: ").append(request.getContextPath());
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
		response.getWriter().append(" PRE Selectuser: ").append(request.getContextPath());		
	/*	Selectuser(pw);
		SelectBd s = null;
		s.main(null);
		response.getWriter().append(" POS  Selectuser: ").append(request.getContextPath());	
	*/
	
		// System.out.println (users);
		// response.getWriter().append((CharSequence) users).append(request.getContextPath());	
		 
		pw.println("</BODY></Html>");
		pw.close();		
	}

}
