package com.example.OnlineBankingSystemAPJ2.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
    private final static Logger LOG = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOG.info("Initializing filter :{}", this);

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        LOG.info("Starting Authentication for req :{}", req.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
        LOG.info("Committing Authentication for req :{}", req.getRequestURI());
    }

    @Override
    public void destroy() {
        LOG.warn("Destructing filter :{}", this);
    }
}
