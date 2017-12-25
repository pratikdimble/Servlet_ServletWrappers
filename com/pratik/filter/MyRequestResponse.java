package com.pratik.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pratik.customrequest.MyRequest;
import com.pratik.customrequest.MyResponse;

/**
 * Servlet Filter implementation class MyRequestResponse
 */
public class MyRequestResponse implements Filter {

	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
										throws IOException, ServletException {
		
	HttpServletRequest req = (HttpServletRequest)request;
	
		HttpServletResponse res = (HttpServletResponse)response;
	
			MyRequest mreq = new MyRequest(req);
				MyResponse mres = new MyResponse(res);
					chain.doFilter(mreq, mres);
			}

	public void init(FilterConfig fConfig) throws ServletException
		{
	}

}
