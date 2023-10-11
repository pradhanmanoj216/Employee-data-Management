package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProfileServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req,HttpServletResponse res)throws
    ServletException,IOException{
    	PrintWriter pw = res.getWriter();
    	res.setContentType("text/html");
    	HttpSession hs = req.getSession(false);//Accessing existing Session
    	if(hs==null) 
    	{
    		pw.println("Session Expired....perform Login process...<br>");
    		RequestDispatcher rd = req.getRequestDispatcher("login.html");
    		rd.include(req, res);
    	}
    	else {
    		UserBean ub = (UserBean)hs.getAttribute("ubean");
    		pw.println("Page of "+ub.getfName()+"<br>");
    		RequestDispatcher rd = req.getRequestDispatcher("link.html");
    		rd.include(req, res);
    		pw.println("<br>"+ub.getfName()+"&nbsp&nbsp"+ub.getlName()+"&nbsp&nbsp"+
    	    		   ub.getAddr()+"&nbsp&nbsp"+ub.getmId()+"&nbsp&nbsp"+ub.getPhNo());

    		}
    }

}
