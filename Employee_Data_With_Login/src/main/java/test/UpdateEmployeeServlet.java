package test;
import java.io.*;

import emp_dao.UpdateDAOEmp;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/updateemp")

public class UpdateEmployeeServlet extends GenericServlet{
	public UpdateDAOEmp ob = null;
    public void init()throws ServletException{
    	ob = new UpdateDAOEmp();
    }	
    public void service(ServletRequest req,ServletResponse res)throws
    ServletException,IOException{
    	int k = ob.update(req);
    	PrintWriter pw = res.getWriter();
    	res.setContentType("text/html");
    	if(k>0) {
    		pw.println("Employee Updated Successfully...<br>");
    		RequestDispatcher rd = req.getRequestDispatcher("emplo.html");
    		rd.include(req, res);
    	}
    }
    public void destroy() {
    	ob=null;
    }
}
