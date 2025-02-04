package com.dabing.lab1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ElCollectionServlet", value = "/elc")//url
public class    ElCollectionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Array
        String[] firstName = {"Bill", "Scott", "Larry"};
        //ArrayList
        List<String> lastName = new ArrayList<>();
        lastName.add("Ellison");
        lastName.add("Gates");
        lastName.add("McNealy");
        //Map
        Map<String, String> company = new HashMap<String, String>();
        company.put("Ellison", "Sun");
        company.put("Gates", "IBM");
        company.put("McNealy", "Microsoft");
        // set as request attribute
        request.setAttribute("fName", firstName);
        request.setAttribute("lName", lastName);
        request.setAttribute("company", company);
        //forward
        request.getRequestDispatcher("elcollection.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
