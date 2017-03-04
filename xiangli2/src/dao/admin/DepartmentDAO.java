package dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import util.DBUtil;

import entity.admin.Departments;
@Repository
public class DepartmentDAO {
	//-================返回所有院系============================================================================================
	public List<Departments> getDepartments() throws Exception {
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		List<Departments> departments=new ArrayList<Departments>();
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select dname from department where states=1");
			rSet=pStatement.executeQuery();
			while(rSet.next()){
				departments.add(new Departments(rSet.getString(1)));
			}
			return departments;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(connection);
		}
	}
}
