package com.pratik.customrequest;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * Application Lifecycle Listener implementation class MyResponse
 *
 */
public class MyResponse extends HttpServletResponseWrapper  {

	HttpServletResponse response;

    public MyResponse(HttpServletResponse response) {
        super(response);
        this.response = response;
    }
    	
    			public void setContentType(String content_Type) {
    				
    	response.setContentType("text/html");
    }
}
