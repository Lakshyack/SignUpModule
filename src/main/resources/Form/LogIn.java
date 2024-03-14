package Form;

import DB.ConnectDbase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LogIn extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        String Email = req.getParameter("email");
        String password = req.getParameter("Password");
        String checkBox = req.getParameter("checkbox");
        if(checkBox != null && checkBox.equals("on")){
            try{
                ConnectDbase d = new ConnectDbase();
                Connection con =  d.ConnectDB("form");
                String q = "SELECT `Email`, `Password` FROM `signup` WHERE `Email` = ?";

                PreparedStatement pstmt = con.prepareStatement(q);
                pstmt.setString(1,Email);

                ResultSet resultSet = pstmt.executeQuery();
                // Check the number of rows affected
                if (!resultSet.next()) {
                    req.setAttribute("DB_error"," Sorry !! You have no Account, Go to  Home page and SignUp First!!!  ");
                    RequestDispatcher rq = req.getRequestDispatcher("login.jsp");
                    rq.forward(req,resp);

                } else {
                    String password1 = resultSet.getString("Password");
                    if(password1.equals(password)){
                        req.setAttribute("DB_Success","Login SuccessFully !!!");
                        RequestDispatcher rq = req.getRequestDispatcher("login.jsp");
                        rq.forward(req,resp);
                    }else {
                        req.setAttribute("DB_error","Password not Match");
                        RequestDispatcher rq = req.getRequestDispatcher("login.jsp");
                        rq.forward(req,resp);
                    }
                }
            }
            catch (Exception e){
                req.setAttribute("DB_error"," Sorry !! Some Errors in DB please ReEnter Detail. ");
                RequestDispatcher rq = req.getRequestDispatcher("login.jsp");
                rq.forward(req,resp);
                e.printStackTrace();
            }
        }
    }
}
