package emp_dao;
import java.sql.*;
import java.util.*;

import test.DBConnection;
import test.EmployeeBean;

public class RetrieveDAO {
	public ArrayList<EmployeeBean> al = new ArrayList<EmployeeBean>();
	
	//retrive method
    public ArrayList<EmployeeBean> retrieve()	
    {
    	try {
    		Connection con = DBConnection.getCon();
    		PreparedStatement ps = con.prepareStatement
    				("select * from Employee48");
    		ResultSet rs = ps.executeQuery();
    		while(rs.next())
    		{
    			EmployeeBean eb = new EmployeeBean();//Bean object
    			eb.setId(rs.getString(1));
    			eb.setName(rs.getString(2));
    			eb.setDesg(rs.getString(3));
    			eb.setbSal(rs.getInt(4));
    			eb.setTotSal(rs.getFloat(5));
    			al.add(eb);//Adding bean to ArrayList
    		}//end of loop
    	}catch(Exception e) {e.printStackTrace();}
    	return al;
    }

}
