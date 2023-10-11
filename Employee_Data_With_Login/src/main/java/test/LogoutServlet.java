package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/logout")

public class LogoutServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
	   ServletException,IOException{
		PrintWriter pw = res.getWriter();
		   res.setContentType("text/html");
		   HttpSession hs = req.getSession(false);//Accessing existing Session
		   if(hs==null)
		   {
			   pw.println("Session expired...perform Login process...<br>"); 
		   }
		   else {
			   hs.removeAttribute("ubean");
			   hs.invalidate();//Session destroyed
			   pw.println("User Logged out Successfully...<br>");

		   		}
		   RequestDispatcher rd = req.getRequestDispatcher("login.html");
		   rd.include(req, res);

	}

}
