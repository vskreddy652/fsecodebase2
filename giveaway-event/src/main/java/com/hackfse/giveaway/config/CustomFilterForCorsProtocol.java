package com.hackfse.giveaway.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class CustomFilterForCorsProtocol extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		System.out.println(request.getHeader("authorization"));
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
		response.setHeader("Access-Control-Allow-Headers",
				"authorization, content-type, xsrf-token, Cache-Control, remember-me, WWW-Authenticate");
		response.addHeader("Access-Control-Expose-Headers", "xsrf-token");
		chain.doFilter(request, response);
	}
}
