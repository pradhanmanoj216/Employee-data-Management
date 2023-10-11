package test;
import java.io.IOException;
import java.io.PrintWriter;

import emp_dao.DeleteDAO;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteEmployee extends GenericServlet{
	public DeleteDAO ob = null;
public void init()throws ServletException{
	ob = new DeleteDAO();
	}
	public void service(ServletRequest req,ServletResponse res)throws
    ServletException,IOException{
		int k = ob.update(req);
    	PrintWriter pw = res.getWriter();
    	res.setContentType("text/html");
    	if(k>0) {
    		pw.println("Employee Deleted Successfully...<br>");
    		RequestDispatcher rd = req.getRequestDispatcher("emplo.html");
    		rd.include(req, res);
    	}
	}
	public void destroy() {
    	ob=null;
    }
}
