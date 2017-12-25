package com.pratik.customrequest;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {

	HttpServletRequest request;
	
    public MyRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    public String getParameter(String param_Name) {
    	String val = request.getParameter(param_Name);
    	if(param_Name.equals("semail")) {
    	val = val+"@pss.com";
    	}
    	return val;
    	}
}
