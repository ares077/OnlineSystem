package dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import util.DBUtil;
import dao.InAdminMatchedDAO;
@Repository
public class AdminMatchedDAO implements InAdminMatchedDAO{
	//============================= 查看管理员是否匹配==================================================================================
	public boolean matched(String id, String pw) throws Exception {
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select adminid,adminpw from admin where adminid=? and adminpw=?");
			pStatement.setString(1, id);
			pStatement.setString(2, pw);
			if (pStatement.executeQuery().next()) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(connection);
		}
	}
}
