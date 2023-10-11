package emp_dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletRequest;
import test.DBConnection;

public class UpdateDAOEmp {
	 public int k=0;
	    public int update(ServletRequest req){
	    	try {
	    		Connection con = DBConnection.getCon();
	    		PreparedStatement ps = con.prepareStatement
	    		("update Employee48 set empdesg=?,empbsal=?,emptotsal=? where empid=?");
	    		ps.setString(1,req.getParameter("desg"));
	    		int bS = Integer.parseInt(req.getParameter("bsal"));
	    		ps.setInt(2,bS);
	    		float totS = bS+(0.93F*bS)+(0.63F*bS);
	    		ps.setFloat(3,totS);
	    		ps.setString(4,req.getParameter("id"));
	    		k = ps.executeUpdate();

	    		}
	    	catch(Exception e) {e.printStackTrace();}
			return k;
	    }

}
