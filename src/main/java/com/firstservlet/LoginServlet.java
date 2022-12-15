package com.firstservlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name="user", value="Ullas"),
                @WebInitParam(name="password", value="Ullas")
        }
)

public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");

        //regex for username
        String userRegex = "^[A-Z][a-z]{2,}$";

        if (Pattern.matches("^[A-Z][a-z]{2,}", user)){
            if(userID.equals(user) && password.equals(pwd)) {
                request.setAttribute("user", user);
                request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
                PrintWriter out = response.getWriter();
                out.println("<font color=red>Either user name or password is wrong.</font>");
                rd.include(request, response);
            }
            }else {
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Kindly Enter Correct USER ID</font>");
        }
    }
}