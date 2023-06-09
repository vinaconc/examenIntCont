package com.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.Document;

import org.openqa.selenium.JavascriptExecutor;

 
/**
 * Servlet implementation class HelloWorld
 */

@WebServlet("/login")

public class WelcomeServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
        /**
         * @see HttpServlet#HttpServlet()
         */
	//@WebServ("/helloWorld")
        public WelcomeServ() {
            super();
            // TODO Auto-generated constructor stub
         }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
                                       HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name").trim();
		response.setContentType("text/html"); 
    	        PrintWriter out = response.getWriter(); 
    	        out.print("<h2>Hello "+name+ "</h2>"); 
    	        out.close();
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
                                       HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String urut =  request.getParameter("Rut");

		

		String uname  = request.getParameter("username");
		
		
		String upassword  = request.getParameter("password");
		
		
		HttpSession session = request.getSession();
		try {
	         Class.forName("com.mysql.jdbc.Driver");
	         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/login", "root", "");
	         
	         
	         PreparedStatement pst = conn.prepareStatement("select * from usuario where Rut = ? and username = ? and password = ?");
	         PreparedStatement pst2 = conn.prepareStatement("select * from persona where Rut = ?");

	         
	         pst.setString(1,urut);
	        
	         pst.setString(2,uname);
	         pst.setString(3, upassword);
	         
	         pst2.setString(1,urut);
	         
	     
	         
	         ResultSet rs = pst.executeQuery();
	         @SuppressWarnings("unused")
			RequestDispatcher dispatcher = null;
	         

	        if (rs.next()) {
 {        
	  
	        	
	        	 {request.setAttribute("status", "success");
	 	        request.setAttribute("status", "success");
	 	        
	 	        dispatcher = request.getRequestDispatcher("/opciones.jsp");
	 	        
	 	        
	 	        
	 	        }
	 	      dispatcher.forward(request, response);
	 	     
 }
	        }else {request.setAttribute("status", "failed");
	        request.setAttribute("status", "failed");
	        
	        dispatcher = request.getRequestDispatcher("/login.jsp");
	        
	        
	        
	        }
	      dispatcher.forward(request, response);
	      } catch (Exception e) {
	         e.printStackTrace();
	      } 
	         }}
	
