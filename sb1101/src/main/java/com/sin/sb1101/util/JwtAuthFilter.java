package com.sin.sb1101.util;

import com.nimbusds.jose.JOSEException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JwtAithFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String authorization = req.getHeader("Authorization");

        if(authorization != null && authorization.startsWith("Bearer ")) {
            String token = authorization.substring(7);

            try{
                String role = JwtUtil.extractRole(token);

                if("admin".equals(role)) {
                    chain.doFilter(request, response);
                    return;
                }
            }catch (JOSEException e){
                throw new ServletException("Unauthorized: Invalid token or role");
            }
        }
        throw new ServletException("Unauthorized: Missing or invalid token");
    }
    @Override
    public void destroy(){

    }
}
