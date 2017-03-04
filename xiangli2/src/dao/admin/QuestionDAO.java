package dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import util.DBUtil;
import dao.InQuestionDAO;
import entity.admin.Question;
@Repository
public class QuestionDAO implements InQuestionDAO{
	//==============================查询总共有所少条题目记录=======================================================================
	public int countPageBySize(int pageSize) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		int total=-1;
		int pages=-1;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select count(*) from question where states=1");
			//获得总的记录数
			rSet=pStatement.executeQuery();
			if (rSet.next())total=rSet.getInt(1);
			//计算总共需要多少页
			int mod=total%pageSize;
			if (mod==0) {
				pages=total/pageSize;
			} else {
				pages=total/pageSize+1;
			}
			return pages;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(connection);
		}
	}
	public int countPageBySize(int pageSize,String sql) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		int total=-1;
		int pages=-1;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement(sql);
			//获得总的记录数
			rSet=pStatement.executeQuery();
			if (rSet.next())total=rSet.getInt(1);
			//计算总共需要多少页
			int mod=total%pageSize;
			if (mod==0) {
				pages=total/pageSize;
			} else {
				pages=total/pageSize+1;
			}
			return pages;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(connection);
		}
	}
	//=============================分页查询所有题目==================================================================================
	public List<Question> findByPage(int page,int pageSize)throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		List<Question> questions=new ArrayList<Question>();
		int total=-1;
		int pages=-1;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select count(*) from question where states=1");
			//获得总的记录数
			rSet=pStatement.executeQuery();
			if (rSet.next())total=rSet.getInt(1);
			//计算总共需要多少页
			int mod=total%pageSize;
			if (mod==0) {
				pages=total/pageSize;
			} else {
				pages=total/pageSize+1;
			}
			//如果要查看的页数大于最大页，或者小于1，则取最后一页或第一页
			if (page>pages) {
				page=pages;
			}else if (page<1) {
				page=1;
			}
			int start=(page-1)*pageSize;
			pStatement=connection.prepareStatement("select questionid,description,type,level,paperid,adddate from question where states=1 order by questionid limit ?,?");
			pStatement.setInt(1, start);
			pStatement.setInt(2, pageSize);
			rSet=pStatement.executeQuery();
			while(rSet.next()){
				String questionid=rSet.getString("questionid");
				String description=rSet.getString("description");
				String type=rSet.getString("type");
				String level=rSet.getString("level");
				String paperid=rSet.getString("paperid");
				String adddate=rSet.getString("adddate");
				questions.add(new Question(questionid, description, type, level, paperid, adddate));
			}
			return questions;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(connection);
		}
	}
	public List<Question> findByPage(int page,int pageSize,String sql,String sql2)throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		List<Question> questions=new ArrayList<Question>();
		int total=-1;
		int pages=-1;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement(sql);
			//获得总的记录数
			rSet=pStatement.executeQuery();
			if (rSet.next())total=rSet.getInt(1);
			//计算总共需要多少页
			int mod=total%pageSize;
			if (mod==0) {
				pages=total/pageSize;
			} else {
				pages=total/pageSize+1;
			}
			//如果要查看的页数大于最大页，或者小于1，则取最后一页或第一页
			if (page>pages) {
				page=pages;
			}else if (page<1) {
				page=1;
			}
			int start=(page-1)*pageSize;
			pStatement=connection.prepareStatement(sql2);
			pStatement.setInt(1, start);
			pStatement.setInt(2, pageSize);
			rSet=pStatement.executeQuery();
			while(rSet.next()){
				String questionid=rSet.getString("questionid");
				String description=rSet.getString("description");
				String type=rSet.getString("type");
				String level=rSet.getString("level");
				String paperid=rSet.getString("paperid");
				String adddate=rSet.getString("adddate");
				questions.add(new Question(questionid, description, type, level, paperid, adddate));
			}
			return questions;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(connection);
		}
	}
	//=============================删除题目==================================================================================
	public boolean delete(String questionid) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("update question set states=0 where questionid=?");
			pStatement.setString(1, questionid);
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
	//=============================重新启用题目==================================================================================
	public boolean reAdd(String questionid) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("update question set states=1 where questionid=?");
			pStatement.setString(1, questionid);
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
	//============================= 根据ID返回题目信息==================================================================================
	public Question findByKey(String id) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		Question question=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select questionid, description, type, level, a, b, c, d, e, f, answer, paperid, remark, adddate from question where questionid=?");
			pStatement.setString(1, id);
			rSet=pStatement.executeQuery();
			while(rSet.next()){
				String questionid=rSet.getString(1);
				String description=rSet.getString(2);
				String type=rSet.getString(3);
				String level=rSet.getString(4);
				String a=rSet.getString(5);
				String b=rSet.getString(6);
				String c=rSet.getString(7);
				String d=rSet.getString(8);
				String e=rSet.getString(9);
				String f=rSet.getString(10);
				String answer=rSet.getString(11);
				String paperid=rSet.getString(12);
				String remark=rSet.getString(13);
				String adddate=rSet.getString(14);
				question=new Question(questionid, description, type, level, a, b, c, d, e, f, answer, paperid, remark, adddate);
			}
			return question;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(connection);
		}
	}
	//============================= 查看题目的状态==================================================================================
	public boolean states(String id) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select states from question where questionid=?");
			pStatement.setString(1, id);
			rSet=pStatement.executeQuery();
			if (rSet.next()) {
				if (rSet.getString("states").equals("0")) {
					return true;
				}
				return false;
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
	//=============================查询题目是否存在==================================================================================
	public boolean checkKey(String id) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select questionid from question where questionid=?");
			pStatement.setString(1, id);
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
	//=============================修改题目信息==================================================================================
	public boolean modify(Question question)throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("update question set description=?, type=?, level=?, a=?, b=?, c=?, d=?, e=?, f=?, answer=?, paperid=?, remark=?  where questionid=? ");
			pStatement.setString(1,question.getDescription());
			pStatement.setString(2,question.getType());
			pStatement.setString(3,question.getLevel());
			pStatement.setString(4,question.getA());
			pStatement.setString(5,question.getB());
			pStatement.setString(6,question.getC());
			pStatement.setString(7,question.getD());
			pStatement.setString(8,question.getE());
			pStatement.setString(9,question.getF());
			pStatement.setString(10,question.getAnswer());
			pStatement.setString(11,question.getPaperid());
			pStatement.setString(12,question.getRemark());
			pStatement.setString(13, question.getQuestionid());
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
//	//========================返回所有试卷ID=======================================================================
//	public List<Paper> getPaperId()throws Exception{
//		Connection connection=null;
//		PreparedStatement pStatement=null;
//		ResultSet rSet=null;
//		List<Paper> paperids=new ArrayList<Paper>();
//		try {
//			connection=DBUtil.getConnection();
//			pStatement=connection.prepareStatement("select paperid from paper");
//			rSet=pStatement.executeQuery();
//			while(rSet.next()){
//				Paper p=new Paper(rSet.getString(1));
//				paperids.add(p);
//			}
//			return paperids;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}finally{
//			DBUtil.close(connection);
//		}
//	}
	//=============================添加题目==================================================================================
	public boolean add(Question question) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("insert into question(description,type,level,a,b,c,d,e,f,answer,paperid,remark,adddate)values(?,?,?,?,?,?,?,?,?,?,?,?,now())");
			pStatement.setString(1, question.getDescription());
			pStatement.setString(2, question.getType());
			pStatement.setString(3, question.getLevel());
			pStatement.setString(4, question.getA());
			pStatement.setString(5, question.getB());
			pStatement.setString(6, question.getC());
			pStatement.setString(7, question.getD());
			pStatement.setString(8, question.getE());
			pStatement.setString(9, question.getF());
			pStatement.setString(10, question.getAnswer());
			pStatement.setString(11, question.getPaperid());
			pStatement.setString(12, question.getRemark());
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
//	public static void main(String[] args) {
//		try {
//			QuestionDAO dao=new QuestionDAO();
//			List<Question> questions=dao.findAllByPage(1, 7);
//			for (Question question : questions) {
//				System.out.println(question);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	public List<Question> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
