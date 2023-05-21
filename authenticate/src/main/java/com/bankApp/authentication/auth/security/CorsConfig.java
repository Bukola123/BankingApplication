package com.bankApp.authentication.auth.security;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsConfig extends OncePerRequestFilter {

    
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {

        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "GET, POST");
        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader("Access-Control-Allow-Headers", "X-PINGOTHER,Content-Type,X-Requested-With,accept,Origin," +
                "Access-Control-Request-Method,Access-Control-Request-Headers,Authorization,x-client-secret," +
                "x-client-key, x-client-token, x-client-secret,x-source-code,Access-control-allow-methods," +
                "Access-control-allow-origin,x-client-id");
        res.addHeader("Access-Control-Expose-Headers", "xsrf-token");
        if ("OPTIONS".equals(req.getMethod()))
            res.setStatus(HttpServletResponse.SC_OK);
        else
            chain.doFilter(req, res);
    }
}
