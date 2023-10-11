package emp_dao;
import java.sql.*;
import jakarta.servlet.*;
import test.DBConnection;
import test.EmployeeBean;
public class RetrieveDAO2 {
	public EmployeeBean eb=null;
	public EmployeeBean retrieve(ServletRequest req)
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement
					("select * from Employee48 where empid=?");
			ps.setString(1, req.getParameter("eid"));
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				eb=new EmployeeBean();   //Bean Object
				eb.setId(rs.getString(1));
				eb.setName(rs.getString(2));
 			   	eb.setDesg(rs.getString(3));
 			   	eb.setbSal(rs.getInt(4));
 			   	eb.setTotSal(rs.getFloat(5));

			}
			}
		catch(Exception e) {e.printStackTrace();}
		return eb;
	}
}
