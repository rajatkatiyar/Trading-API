package com.finflock.config;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;

public class CorsFilter implements ContainerResponseFilter {
	        public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {

	            MultivaluedMap<String, Object> headers = responseContext.getHeaders();

	            headers.add("Access-Control-Allow-Origin", "*");
	            headers.add("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS,HEAD");            
	            headers.add("Access-Control-Allow-Headers", 
	                "X-Requested-With,Content-Type,Content-Length,Authorization,"
	                        + "Accept,Origin,Cache-Control,Accept-Encoding,Access-Control-Request-Headers"
	                        + "Access-Control-Request-Method,Referer,x-csrftoken");
	        }
	    }