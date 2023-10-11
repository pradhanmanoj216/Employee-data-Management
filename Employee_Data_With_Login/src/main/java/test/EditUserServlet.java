package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/update")
public class EditUserServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
    ServletException,IOException{
    	PrintWriter pw = res.getWriter();
    	res.setContentType("text/html");
    	HttpSession hs = req.getSession(false); //Accessing existing Session
    	if(hs==null) 
    	{
    		pw.println("Session Expired....perform Login process...<br>");
    		RequestDispatcher rd = req.getRequestDispatcher("login.html");
    		rd.include(req, res);
    	}
    	else
    	{
    		UserBean ub = (UserBean)hs.getAttribute("ubean");
    		pw.println("Page of "+ub.getfName()+"<br>");
    		
    		pw.println("<form action='edit' method='post'>");
    		   pw.println("<input type='hidden' name='uName' value='"+ub.getuName()+"'>");
			   pw.println("Address:<input type='text' name='addr' value='"+ub.getAddr()+"'><br>");
			   pw.println("MailId:<input type='text' name='mid' value='"+ub.getmId()+"'><br>");
			   pw.println("PhoneNo:<input type='text' name='phno' value='"+ub.getPhNo()+"'><br>");
			   pw.println("<input type='submit' value='UpdateUser'>");
			   pw.println("</form>");
    	}
    }
}