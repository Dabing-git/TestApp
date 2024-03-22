package com.dabing.week5;


import com.dabing.dao.UserDao;
import com.dabing.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
        /// TODO 1: GET 4 CONTEXT PARAM - DRIVER , URL , USERNAME , PASSWORD
        // TODO 2: GET JDBC connection
        //only one one
        con = (Connection) getServletContext().getAttribute("con");
        //check the video live demo#4
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // doPost(request,response);//call dopost
        //when user click Login from menu- method is get
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        // TODO 3: GET REQUEST PARAMETER - USERNAME AND PASSWORD
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {

            //lets change code to make MVC

            //jdbc code --- mvc -- move this code into dao

            UserDao userDao = new UserDao();
            User user = userDao.findByUsernamePassword(con, username, password);
            if (user != null) {
                //login success
                HttpSession session=request.getSession();
                session.setAttribute("user", user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
            } else {
                //login fail
                request.setAttribute("message", "Username Password Error !!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
            }


            //TODO 4: VALIDATE USER - SELEECT * FROM USERTABLE WHERE USERNAME='XXX'
            // AND PASSWORD='YYY'
           /* String sql = "select id,username,password,email,gender,birthdate from usertable where username='" + username + "' and password='" + password + "'";

            ResultSet rs = con.createStatement().executeQuery(sql);
            if (rs.next()) {
                //week 5 code
                //out.print("Login Successful!!!");
                //out.print("Welcome"+username);
                //get from rs and set into resquest attribute

                request.setAttribute("id", rs.getInt("id"));
                request.setAttribute("username", rs.getString("username"));
                request.setAttribute("password", rs.getString("password"));
                request.setAttribute("email", rs.getString("email"));
                request.setAttribute("gender", rs.getString("gender"));
                request.setAttribute("birthDate", rs.getString("birthdate"));
                //forward to userInfo.jsp
                request.getRequestDispatcher("userInfo.jsp").forward(request, response);

            } else {
                //out.print("Username or password Error!!!");
                request.setAttribute("message", "Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request, response);

            }//end of else

*/
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
