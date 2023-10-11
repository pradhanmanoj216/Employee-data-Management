package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import java.util.*;

import emp_dao.RetrieveDAO;
@SuppressWarnings("serial")
@WebServlet("/viewemp")
public class ViewEmployeesServlet extends GenericServlet{
	public RetrieveDAO ob = null;
    public void init()throws ServletException{
    	ob = new RetrieveDAO();
    }
    public void service(ServletRequest req,ServletResponse res)throws
    ServletException,IOException{
    	ArrayList<EmployeeBean> al = ob.retrieve();
    	PrintWriter pw = res.getWriter();
    	res.setContentType("text/html");
    	if(al.size()==0) {
    		pw.println("Employes nor Available...<br>");
    	}else {
    		Spliterator<EmployeeBean> sp = al.spliterator();
    		sp.forEachRemaining((k)->
    		{
    			EmployeeBean eb = (EmployeeBean)k;
    			pw.println(eb.getId()+"&nbsp&nbsp"+eb.getName()+"&nbsp&nbsp"+
    			    eb.getDesg()+"&nbsp&nbsp"+eb.getbSal()+"&nbsp&nbsp"+
    					eb.getTotSal()+"<br>");
    		});
    	}
    	RequestDispatcher rd = req.getRequestDispatcher("emplo.html");
    	rd.include(req, res);

    }
    public void destroy() {
    	ob=null;
    }

}
