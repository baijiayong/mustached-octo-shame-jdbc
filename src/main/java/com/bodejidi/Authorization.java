package com.bodejidi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

public class Authorization implements Filter
{
    public void init(FilterConfig filterConfig) throws ServletException
    {
        //ignore;
    }
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException,ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        if(isNotAuthUrl(req) && isNotLogin(req))
        {
            ((HttpServletResponse)response).sendRedirect(req.getContextPath() + "/auth/login");
            return;
        }
        chain.doFilter(request,response);
    }
    public void destroy()
    {
    
    }
    public boolean isNotAuthUrl(HttpServletRequest req)
    {
        return ! req.getRequestURI().startsWith(req.getContextPath() + "/auth/");
    }
    public boolean isNotLogin(HttpServletRequest req) throws IOException, ServletException
    {
        Long memberId = (Long)req.getSession().getAttribute("memberID");
        return null == memberId;
    }
}