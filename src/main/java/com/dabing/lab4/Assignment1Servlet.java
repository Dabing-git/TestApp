package com.dabing.lab4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Assignment1Servlet", value = "/count")
public class Assignment1Servlet extends HttpServlet {
    int index;
    @Override
    public void init() throws ServletException {
        super.init();
        index=0;

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ++index;

        PrintWriter out = response.getWriter();
        out.println("<h1>" +
                ""+"since loading ,this servlet has been accessed "+index+" times</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
