package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("------BEFORE FILTER--------");
		chain.doFilter(request, response);
		System.out.println("------AFTER FILTER--------");
		int a=10;
		int b=20;
		int c=a+b;
		System.out.println("sum: "+c);
		
	}

}
