package com.bodejidi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthLoginServlet extends HttpServlet
{
    public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
    {
        HttpSession session = req.getSession();
        Long memberId = (Long)session.getAttribute("memberId");
        
        if(req.getRequestURI().endsWith("/logout"))
        {
            logout(req, resp);
            return;
        }
        if(isNotLogin(req))
        {
            showLoginPage(req,resp);
        }else
        {
            resp.sendRedirect(req.getContextPath());
        }
    }
    public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
    {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String action = req.getParameter("action");
       
        if("login".equalsIgnoreCase(action)&&"admin".equals(username)&&"abc".equals(password))
        {
            HttpSession session = req.getSession();
            session.setAttribute("memberId",1L);
            showLoginSuccess(req,resp);
        }else
        {
            showLoginFailed(req,resp);
        }
         if(isNotLogin(req))
        {
            showLoginPage(req, resp);
        }
    
    }
    public void showLoginSuccess(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
    {
        forward("showLoginSuccess", req, resp);
    }
    public void showLoginFailed(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException
    {   
        forward("showLoginFailed", req, resp);
    }
    public void showLoginPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException
    {
        forward("showLoginPage",req,resp);
    }
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {  
        req.getSession().removeAttribute("memberId");
        showLoginPage(req,resp);
    }
    public boolean isNotLogin(HttpServletRequest req)
    {
        Long memberId = (Long)req.getSession().getAttribute("memberId");
        return null == memberId;
    }
    public void forward(String page, HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException
    {
        String jsp = "/WEB-INF/member/" + page + ".jsp";
        getServletContext().getRequestDispatcher(jsp).forward(req,resp);
    }
    
}      