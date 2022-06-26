/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.payara.learn;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONObject;

/**
 *
 * @author john
 */
@WebFilter(urlPatterns="/movies/*")
public class JsonFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                            throws IOException, ServletException {        
        
        // Log the current timestamp.
        System.out.println("Filter here, HELLO!");
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        System.out.println(httpRequest.getRequestURI());
        
        JSONObject json = new JSONObject();
        
        json.put("name", "Michael");
        json.put("age", "44");
        json.put("department", "Sales");
        
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();

        // Pass request back down the filter chain
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
    
}
