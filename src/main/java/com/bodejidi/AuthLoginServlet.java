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
        
        if(memberId == null)
        {
            login();
        }
    }
    public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
    {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
    
        if("admin".equals(username)&&"abc".equals(password))
        {
            HttpSession session = req.getSession();
            session.setAttribute("memberId",1L);
            showLoginSuccess();
        }else
        {
            showLoginFailed();
        }
    }
    public void showLoginSuccess()
    {
    
    }
    public void showLoginFailed()
    {
        
    }
    public void login()
    {
    
    }
}