package com.gauravbytes.hellogb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="https://www.gauravbytes.com">Blog - GauravBytes</a>
 * <a href="https://lineofcode.in">About me</a>
 */
public class CustomSecurityHeaderFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String header = request.getHeader("Authorization");

		if (header == null || !header.startsWith("Digest ")) {
			response.sendError(401, "You are not authrorized");
		}
		else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
		
	}
}
