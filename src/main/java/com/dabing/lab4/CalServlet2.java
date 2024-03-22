package com.dabing.lab4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalServlet2", value = "/CalServlet2")//url
public class CalServlet2 extends HttpServlet {

    private int add(int n1,int n2){
        return n1+n2;
    }
    private int sub(int n1,int n2){
        return n1-n2;
    }
    private int mul(int n1,int n2){
        return n1*n2;
    }
    private int div(int n1,int n2){
        return n1/n2;
    }
    private int comLength(String str){
        return str.length();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   System.out.println("i am in post");
   //get the 2 numbers
      int n1= Integer.parseInt(request.getParameter("firstVal"));// <td><input type="text" name="firstVal"/></td>
        int n2= Integer.parseInt(request.getParameter("secondVal"));// <td><input type="text" name="firstVal"/></td>

    //add
        int result=add(n1,n2);
        System.out.println("Result "+result);
///send this result back --with response
        Cookie c1=new Cookie("cResult",""+result);
        //add c1 into response
        response.addCookie(c1);
        //go back cal.jsp
        response.sendRedirect("cal.jsp");
    }
}
