package com.nsv.jsmbaba.filters;

import javax.servlet.*;

import java.io.IOException;
public class RequestAuditFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("RequestAuditFilter-Before-doFilter------------");
        System.out.println("RequestAuditFilter-Host IP:"+servletRequest.getRemoteHost());
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("RequestAuditFilter-After-doFilter------------");
        System.out.println("RequestAuditFilter-Request Processed for the Host IP:"+servletRequest.getRemoteHost());
    }

    @Override
    public void destroy() {

    }
}
