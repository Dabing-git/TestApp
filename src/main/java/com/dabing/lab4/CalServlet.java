package com.dabing.lab4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalServlet", value = "/cal")
public class CalServlet extends HttpServlet {
    int add(int a,int b){
        return  a+b;
    }
    int subtract(int a,int b){
        return a-b;
    }
    int multiply (int a,int b){
        return a*b;
    }
    int divide(int a,int b) {
        return a/b;
    }
    int computeLength(String str) {
        return str.length();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/lab4/cal.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("action").equals("computeLength")){
            String str=request.getParameter("name").trim();
            int length=computeLength(str);
            Cookie c1=new Cookie("cName",str);
            Cookie c2=new Cookie("cLength",Integer.toString(length));

            response.addCookie(c1);
            response.addCookie(c2);
            c1.setMaxAge(5);
            c2.setMaxAge(5);
        }else{
            String firstValue=request.getParameter("firstVal");
            String secondValue=request.getParameter("secondVal");
         //   System.out.println(firstValue);
           // System.out.println(secondValue);
            int n1=Integer.valueOf(firstValue);
            int n2=Integer.valueOf(secondValue);

            int cResult=0;
        //    System.out.println(request.getParameter("action"));
            if(request.getParameter("action").equals("add")){
                cResult=add(n1,n2);
            }else if(request.getParameter("action").equals("subtract")){
                cResult=subtract(n1,n2);
            }else if(request.getParameter("action").equals("multiply")){
                cResult=multiply(n1,n2);
            }else if(request.getParameter("action").equals("divide")){
                cResult=divide(n1,n2);
            }
            Cookie c3=new Cookie("cFirstValue",Integer.toString(n1));
            Cookie c4=new Cookie("cSecondValue",Integer.toString(n2));
            Cookie c5=new Cookie("cResult",Integer.toString(cResult));
            System.out.println(Integer.toString(cResult));

            response.addCookie(c3);
            response.addCookie(c4);
            response.addCookie(c5);
            c3.setMaxAge(50);c4.setMaxAge(50);c5.setMaxAge(50);
        }

        response.sendRedirect(request.getContextPath()+"/lab4/cal.jsp");
    }
}