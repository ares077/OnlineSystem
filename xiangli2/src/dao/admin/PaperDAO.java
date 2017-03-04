package dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import util.DBUtil;
import dao.InPaperDAO;
import entity.admin.Paper;
@Repository
public class PaperDAO implements InPaperDAO{
	//==============================查询所有试卷===========================================================
	public List<Paper> findAll() throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		List<Paper> papers=new ArrayList<Paper>();
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select paperid,papername,courseid from paper where states=1");
			rSet=pStatement.executeQuery();
			while(rSet.next()){
				papers.add(new Paper(rSet.getString(1), rSet.getString(2), rSet.getString(3)));
			}
			return papers;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(connection);
		}
	}
	//==============================查询单个试卷===========================================================
	public Paper findByCondition(String sql) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		Paper papers=new Paper();
		try {
			connection=DBUtil.getConnection();
//			System.out.println(sql);
			pStatement=connection.prepareStatement(sql);
			rSet=pStatement.executeQuery();
			if (rSet.next()) {
				papers=new Paper(rSet.getString(1), rSet.getString(2), rSet.getString(3));
			}
			return papers;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(connection);
		}
	}
	//==============================删除试卷===========================================================
	public boolean delete(String id) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("update paper set states=0 where paperid=?");
			pStatement.setString(1, id);
			if (1==pStatement.executeUpdate()) {
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
	//==============================修改===========================================================
	public boolean modify(Paper paper) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("update paper set papername=? where paperid=?");
			pStatement.setString(1, paper.getPapername());
			pStatement.setString(2, paper.getPaperid());
			if (1==pStatement.executeUpdate()) {
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
	//==============================添加===========================================================
	public boolean add(Paper paper) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("insert into paper(papername,paperid,courseid) values(?,?,?)");
			pStatement.setString(1, paper.getPapername());
			pStatement.setString(2, paper.getPaperid());
			pStatement.setString(3, paper.getCourseid());
			if (1==pStatement.executeUpdate()) {
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
	//=========================查询name是否存在==============================
	public boolean checkName(String name) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select papername from paper where papername=?");
			pStatement.setString(1, name);
			rSet=pStatement.executeQuery();
			if (rSet.next()) {
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
	//=========================查询name是否存在==============================
	public boolean checkKey(String id) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select paperid from paper where paperid=?");
			pStatement.setString(1, id);
			rSet=pStatement.executeQuery();
			if (rSet.next()) {
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
	public Paper findByKey(String key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
