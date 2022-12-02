package com.glsua55;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtility {
       
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
}
