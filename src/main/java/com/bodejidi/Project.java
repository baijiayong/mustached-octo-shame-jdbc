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
        }else if ("show".equalsIgnoreCase(action))
        {
            Long id = Long.valueOf(req.getParameter("id"));
            member.setId(id);
            
            MemberDao memberDao = new MemberDao();
            req.setAttribute("member",memberDao.show(member));
            forward("show",req,resp);
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
        }else if("delete".equalsIgnoreCase(action))
        {
            Long id = Long.valueOf(req.getParameter("id"));
            
            member.setId(id);
            MemberDao memberDao = new MemberDao();
            memberDao.delete(member);
            req.setAttribute("memberId",member);
            forward("deleteSuccess",req,resp);
        }
        
    }
    public void forward(String page, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        String jsp = "/WEB-INF/member/" + page +".jsp";
        getServletContext().getRequestDispatcher(jsp).forward(req,resp);
    }
}