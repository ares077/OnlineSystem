package dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import util.DBUtil;


import entity.admin.Majors;
@Repository
public class MajorDAO {
	//======================返回对应的专业集合===================================================================
	public List<Majors> getMajors(String dname) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		List<Majors> majors=new ArrayList<Majors>();
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select mname from major where states=1 and dname=?");
			pStatement.setString(1, dname);
			rSet=pStatement.executeQuery();
			while(rSet.next()){
				majors.add(new Majors(rSet.getString(1)));
			}
			return majors;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(connection);
		}
	}
}
