package emp_dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.http.HttpServletRequest;
import test.DBConnection;

public class UpdateDAO {
	public int k=0;
	public int update(HttpServletRequest req) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
			("update user48 set addr=?,mid=?,phno=? where uname=?");
			ps.setString(1,req.getParameter("addr"));
			ps.setString(2,req.getParameter("mid"));
			long ph=Long.parseLong(req.getParameter("phno"));
    		ps.setLong(3,ph);
    		ps.setString(4,req.getParameter("uName"));
    		k = ps.executeUpdate();
    		
			
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
