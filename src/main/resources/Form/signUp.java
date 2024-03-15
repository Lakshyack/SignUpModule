package Form;

import DB.ConnectDbase;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class signUp extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String Email = req.getParameter("email");
        String Phone = req.getParameter("phone");
        String Password = req.getParameter("Password");
        String cPassword = req.getParameter("cPassword");
        String checkBox = req.getParameter("checkbox");
        Part part = req.getPart("img");
        String filename = part.getSubmittedFileName();
        out.println(filename);

      if(checkBox != null && checkBox.equals("on")){
          if(Password.equals(cPassword)){
              try{
                  ConnectDbase d = new ConnectDbase();
                  Connection con =  d.ConnectDB("form");
                  String q = "INSERT INTO `form`.`signup` (`Name`, `Email`, `Phone`, `Password`) VALUES (?,?,?,?);";
                  PreparedStatement pstmt = con.prepareStatement(q);
                  pstmt.setString(1,name);
                  pstmt.setString(2,Email);
                  pstmt.setString(3,Phone);
                  pstmt.setString(4,Password);


                  int rowsAffected = pstmt.executeUpdate();

                  // Check the number of rows affected
                  if (rowsAffected > 0) {
                      req.setAttribute("DB_error"," Good! You have successfully Register.. ");
                      RequestDispatcher rq = req.getRequestDispatcher("signUp.jsp");
                      rq.forward(req,resp);

                  } else {
                      req.setAttribute("DB_error"," Sorry !! Some Errors in DB please ReEnter Detail. ");
                      RequestDispatcher rq = req.getRequestDispatcher("signUp.jsp");
                      rq.forward(req,resp);

                  }
                  }
           catch (Exception e){
               req.setAttribute("DB_error",e);
               RequestDispatcher rq = req.getRequestDispatcher("signUp.jsp");
               rq.forward(req,resp);

                  e.printStackTrace();
           }

          }
          else {
              req.setAttribute("PnotMatch","Password do not Match!!");
              RequestDispatcher rq = req.getRequestDispatcher("signUp.jsp");
              rq.forward(req,resp);
          }
        }else {
          req.setAttribute("CheckBox","Please Check CheckBox!!");
          RequestDispatcher rq = req.getRequestDispatcher("signUp.jsp");
          rq.forward(req,resp);
      }



    }
}
