package dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import util.DBUtil;
import dao.InCourseDAO;
import entity.admin.Course;
@Repository
public class CourseDAO implements InCourseDAO{
	//==============================查询所有课程===========================================================
	public List<Course> findAll() throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		List<Course> courses=new ArrayList<Course>();
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select courseid,coursename from course where states=1");
			rSet=pStatement.executeQuery();
			while(rSet.next()){
				courses.add(new Course(rSet.getString(1), rSet.getString(2)));
			}
			return courses;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(connection);
		}
	}
	//==============================符合条件的===========================================================
	public List<Course> findByCondition(String sql) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		List<Course> courses=new ArrayList<Course>();
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement(sql);
			rSet=pStatement.executeQuery();
			while(rSet.next()){
				courses.add(new Course(rSet.getString(1), rSet.getString(2)));
			}
			return courses;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(connection);
		}
	}
	//====================================修改课程名====================================================
	public boolean modify(Course course) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("update course set coursename=? where courseid=?");
			pStatement.setString(1, course.getCoursename());
			pStatement.setString(2, course.getCourseid());
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
	//====================================删除课程名====================================================
	public boolean delete(String id) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("update course set states=0 where courseid=?");
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
	//==========================查看课程名是否存在=================================
	public boolean checkKey(String id) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select courseid from course where courseid=?");
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
	//==========================添加课程=================================
	public boolean add(Course course) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("insert into course(coursename,courseid) values(?,?)");
			pStatement.setString(1, course.getCoursename());
			pStatement.setString(2, course.getCourseid());
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
	public Course findByKey(String key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
