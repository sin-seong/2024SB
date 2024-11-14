package com.sin.sb1101.util;

import com.nimbusds.jose.JOSEException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;

public class JwtAuthFilter implements Filter {

    private static final String BEARER_PREFIX = "Bearer ";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String authorization = req.getHeader("Authorization");

        if (authorization != null && authorization.startsWith("Bearer ")) {
            String token = authorization.substring(BEARER_PREFIX.length());

            try {
                String role = JwtUtil.extractRole(token);

                if ("admin".equals(role)) {
                    chain.doFilter(request, response);
                    return;
                } else {
                    throw new ServletException("Unauthorized: Invalid token or role");
                }
            } catch (ParseException | JOSEException e) {
                throw new ServletException("Unauthorized: Invalid token", e);
            }
        } else {
            throw new ServletException("Unauthorized: Missing or invalid token");
        }
    }
    @Override
    public void destroy(){

    }
}
