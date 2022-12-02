package com.glsua55;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		Cookie c=CookieUtility1.getCookieWithName(request,"rv");
		Cookie cfg=CookieUtility1.getCookieWithName(request, "fg");
		Cookie cbg=CookieUtility1.getCookieWithName(request, "bg");
		String fg="";
		String bg="";
		if(cfg!=null && cbg!=null) {
			fg=cfg.getValue();
			bg=cbg.getValue();
		}
		out.print("<body style='background-color:"+bg+"'>");
		out.print("<h1 style='color:"+fg+"'>Hello World</h1>");
		
		if(c==null) {
			out.print("<h1 style='color:"+fg+"'>Welcome</h1><br>");
			CookieUtility.createCookie(response, "rv", "1", 60*60);
		}else {
			int value=Integer.parseInt(c.getValue());
			value+=1;
			CookieUtility.createCookie(response, "rv",Integer.toString(value), 60*60);
			out.print("<h1 style='color:"+fg+"'>Welcome Back</h1>");
			out.print("<br>");
			out.print("<h3 style='color:"+fg+"'>No. of times Page Visited: "+value+"</h3><br>");
		}
		
		out.print("<form method='post' action='ChangeColor'>");
		out.print("<input type='text' placeholder='Enter Color' name='fg'><br>");
		out.print("<input type='text' placeholder='Enter Background Color' name='bg'><br>");
		out.print("<input type='submit' value='Submit'>");
		out.print("</form>");
		out.print("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
