package com.glsua55;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieUtility
 */
@WebServlet("/CookieUtility")
public class CookieUtility1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieUtility1() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static void createCookie(HttpServletResponse res,String nm,String val,int age) {
    	Cookie c=new Cookie(nm,val);
    	c.setMaxAge(age);
    	res.addCookie(c);
    }
    
    public static Cookie getCookieWithName(HttpServletRequest req,String nm) {
    	Cookie []c=req.getCookies();
    	if(c!=null) {
    		for(int i=0;i<c.length;i++) {
    			if(c[i].getName().equals(nm)) {
    				return c[i];
    			}
    		}
    	}
    	return null;
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
	}

}
