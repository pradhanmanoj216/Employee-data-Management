package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/add")

public class AddEmployeeServlet extends HttpServlet{
	public EmployeeBean eb=null;
	public InsertDAOEmp ob=null;
   public void init()throws ServletException
   {
	   eb = new EmployeeBean();
	   ob = new InsertDAOEmp();
   	}
   protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
   ServletException,IOException{
	   eb.setId(req.getParameter("id"));
		  eb.setName(req.getParameter("name"));
		  eb.setDesg(req.getParameter("desg"));
		  eb.setbSal(Integer.parseInt(req.getParameter("bsal")));
		  eb.setTotSal(eb.getTotSal()+(0.93F*eb.getbSal())+(0.63F*eb.getbSal()));
		  int k = ob.insert(eb);
		  PrintWriter pw = res.getWriter();
		  res.setContentType("text/html");
		  if(k>0) {
			  pw.println("Employee Added Successfully...<br>");
			  RequestDispatcher rd = req.getRequestDispatcher("emplo.html");
			  rd.include(req, res);
		  }
	   }
	   public void destroy() {
		   ob=null;
		   eb=null;
	   }

	   
   }




