package com.bodejidi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.IOException;

public class Project extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException , ServletException
    {
        String action = req.getParameter("action");
        
        Member member = new Member();
        
        if ("list".equalsIgnoreCase(action))
        {
           MemberDao memberDao = new MemberDao();
           req.setAttribute("memberList",memberDao.list());
           forward("list",req,resp);
        }
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        Member member = new Member();
        
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
       
        String action = req.getParameter("action");

        if("add".equalsIgnoreCase(action))
        {
            member.setFirstName(firstName);
            member.setLastName(lastName);
            MemberDao memberDao = new MemberDao();
            memberDao.save(member);
            req.setAttribute("member",member);
            forward("showAddSuccess", req, resp);
        }
        
    }
    public void forward(String page, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        String jsp = "/WEB-INF/member/" + page +".jsp";
        getServletContext().getRequestDispatcher(jsp).forward(req,resp);
    }
}