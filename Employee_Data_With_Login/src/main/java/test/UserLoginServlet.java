package test;
import java.io.*;

import emp_dao.LoginDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
    ServletException,IOException{
		PrintWriter pw = res.getWriter();
    	res.setContentType("text/html");
    	UserBean ub = new LoginDAO().login(req);
    	if(ub==null) 
    	{
    		pw.println("Invalid Login process...<br>");
    		RequestDispatcher rd = req.getRequestDispatcher("login.html");
    		rd.include(req, res);
    	}
    	else {
    			HttpSession hs = req.getSession();//Creating new Session
    			hs.setAttribute("ubean", ub);//Adding bean to Session
    			pw.println("Welcome User "+ub.getfName()+"<br>");
    			RequestDispatcher rd = req.getRequestDispatcher("link.html");
    			rd.include(req, res);
    	}
	}

}
