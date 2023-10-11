package test;
import java.io.IOException;
import java.io.PrintWriter;

import emp_dao.UpdateDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/edit")
public class UpdateUserServlet extends HttpServlet{
	public UpdateDAO ob = null;
	public void init()throws ServletException{
		ob = new UpdateDAO();
	}
	public void service(HttpServletRequest req,HttpServletResponse res)throws
    ServletException,IOException{
		int k = ob.update(req);
    	PrintWriter pw = res.getWriter();
    	res.setContentType("text/html");
    	if(k>0) {
    		pw.println("User Updated Successfully...<br>");
    		RequestDispatcher rd = req.getRequestDispatcher("link.html");
    		rd.include(req, res);
    	}

	}
	public void destroy() {
    	ob=null;
    }


}
