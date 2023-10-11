package emp_dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletRequest;
import test.DBConnection;
public class DeleteDAO {
	public int k=0;
    public int update(ServletRequest req) {
    	try {
    		Connection con = DBConnection.getCon();
    		PreparedStatement ps = con.prepareStatement
    				("delete from Employee48 where empid=?");
    		ps.setString(1,req.getParameter("id"));
    		k = ps.executeUpdate();
    		}
    	catch(Exception e) {e.printStackTrace();}
		return k;
    	
    }
}
