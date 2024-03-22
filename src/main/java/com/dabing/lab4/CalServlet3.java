package com.dabing.lab4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalServlet3", value = "/CalServlet3")//url
public class CalServlet3 extends HttpServlet {

    private  int add(int n1, int n2){
        return n1+n2;
    }

    private  int sub(int n1, int n2){
        return n1-n2;
    }
    private  int mul(int n1, int n2){
        return n1*n2;
    }
    private  int div(int n1, int n2){
        return n1/n2;
    }
    private  int getLength(String str){
        return str.length();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("i am in post ");
        //get n1 and n2
       int n1= Integer.parseInt(request.getParameter("firstVal"));
        int n2= Integer.parseInt(request.getParameter("secondVal"));

        //add
        int result=add(n1,n2);
        System.out.println(" Result" +result);
    }

}
