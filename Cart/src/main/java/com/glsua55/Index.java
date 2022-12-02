package com.glsua55;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		/*HttpSession s=request.getSession();
		System.out.println("SSSS: "+s);
		if(s==null) {
			response.sendRedirect("Login");
		}else {*/
		out.print("<h1>Products</h1>");
		out.print("<form method='post' action='CartHandler'>");
		out.print("<input type='checkbox' id='mob' name='mob' value='Mobile'>");
		out.print("<label for='mob'>Mobile</label><br>");
		out.print("<input type='checkbox' id='lap' name='lap' value='Laptop'>");
		out.print("<label for='mob'>Laptop</label><br>");
		out.print("<input type='checkbox' id='bag' name='bag' value='Bag'>");
		out.print("<label for='mob'>Bag</label><br>");
		out.print("<input type='checkbox' id='pen' name='pen' value='Pen'>");
		out.print("<label for='pen'>Pen</label><br>");
		out.print("<input type='checkbox' id='spe' name='spe' value='Specs'>");
		out.print("<label for='spe'>Specs</label><br>");
		out.print("<input type='submit' value='Submit'>");
		out.print("</form><br><br>");
		
		out.print("<h1>Your Cart</h1>");
		
		HttpSession s=request.getSession();
		ArrayList prodArray=(ArrayList)s.getAttribute("prodList");
	
		if(prodArray==null) {
			out.print("<h5>Cart is Empty</h5>");
		}else {
			out.print("<ul>");
			for(int i=0;i<prodArray.size();i++) {
				out.print("<li>"+prodArray.get(i)+"</li>");
			}
			out.print("</ul>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
