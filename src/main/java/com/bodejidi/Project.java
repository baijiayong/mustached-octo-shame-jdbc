package com.bodejidi;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

public class Project extends HttpServlet
{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException , ServletException
    {
        resp.getWriter().println("I am a boy!");
    }
}