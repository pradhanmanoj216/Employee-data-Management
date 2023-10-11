package test;
import java.io.IOException;
import java.io.PrintWriter;

import emp_dao.RetrieveDAO2;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/del")
public class RemoveEmployee2 extends GenericServlet{
	public RetrieveDAO2 ob=null;
	   public void init()throws ServletException{
		   ob = new RetrieveDAO2();
	   }
	   public void service(ServletRequest req,ServletResponse res)throws
	   ServletException,IOException{
		   EmployeeBean eb = ob.retrieve(req);
		   PrintWriter pw = res.getWriter();
		   res.setContentType("text/html");
		   if(eb==null)
		   {
			   pw.println("Invalid employee id...<br>");
			   RequestDispatcher rd = req.getRequestDispatcher("delete01.html");
			   rd.include(req, res);

		   }
		   else
		   {
			   pw.println("<form action='delete' method='post'>");
			   pw.println("<input type='hidden' name='id' value='"+eb.getId()+"'>");
			   pw.println("Employee name:<input type='text' name='name' value='"+eb.getName()+"'><br>");
			   pw.println("Designation:<input type='text' name='desg' value='"+eb.getDesg()+"'><br>");
			   pw.println("BasicSalary:<input type='text' name='bsal' value='"+eb.getbSal()+"'><br>");
			   pw.println("<input type='submit' value='DeleteEmployee'>");
			   pw.println("</form>");
		   }
		   }
		   public void destroy() {
				  ob=null; 

	   }

}
