package dao.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import util.DBUtil;
import dao.InStudentDAO;
import entity.admin.Student;
@Repository
public class StudentDAO implements InStudentDAO{
	//==============================查询总共有所少条学生记录=======================================================================
	public int countPageBySize(int pageSize) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		int total=-1;
		int pages=-1;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select count(*) from studentinfo where states=1");
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
	//=============================分页查询所有学生==================================================================================
	public List<Student> findByPage(int page,int pageSize)throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		List<Student> students=new ArrayList<Student>();
		int total=-1;
		int pages=-1;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select count(*) from studentinfo where states=1");
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
			pStatement=connection.prepareStatement("select studentid,studentpw,name,sex,idnumber,phonum,email,department,major,classinfo,notice,answer from studentinfo where states=1 order by studentid limit ?,?");
			pStatement.setInt(1, start);
			pStatement.setInt(2, pageSize);
			rSet=pStatement.executeQuery();
			while(rSet.next()){
				String studentid=rSet.getString("studentid");
				String studentpw=rSet.getString("studentpw");
				String name=rSet.getString("name");
				String sex=rSet.getString("sex");
				String idnumber=rSet.getString("idnumber");
				String phonum=rSet.getString("phonum");
				String email=rSet.getString("email");
				String department=rSet.getString("department");
				String major=rSet.getString("major");
				String classinfo=rSet.getString("classinfo");
				String notice=rSet.getString("notice");
				String answer=rSet.getString("answer");
				students.add(new Student(studentid, studentpw, name, sex, idnumber, phonum, email, department,major, classinfo, notice, answer));
			}
			return students;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(connection);
		}
	}
	//=============================添加新学生==================================================================================
	public boolean add(Student student)throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("insert into studentinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pStatement.setString(1, student.getStudentid());
			pStatement.setString(2, student.getStudentpw());
			pStatement.setString(3, student.getName());
			pStatement.setString(4, student.getSex());
			pStatement.setString(5, student.getIdnumber());
			pStatement.setString(6, student.getPhonum());
			pStatement.setString(7, student.getEmail());
			pStatement.setString(8, student.getDepartment());
			pStatement.setString(9, student.getMajor());
			pStatement.setString(10, student.getClassinfo());
			pStatement.setString(11, student.getNotice());
			pStatement.setString(12, student.getAnswer());
			pStatement.setInt(13, 1);
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
	//=============================删除学生==================================================================================
	public boolean delete(String studentid) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("update studentinfo set states=0 where studentid=?");
			pStatement.setString(1, studentid);
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
	//=============================查询学生是否存在==================================================================================
	public boolean checkKey(String studentid) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select studentid from studentinfo where studentid=?");
			pStatement.setString(1, studentid);
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
	//=============================修改学生信息==================================================================================
	public boolean modify(Student student)throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("update studentinfo set name=?,sex=?,idnumber=?," +
					"phonum=?,email=?,department=?,major=?,classinfo=?,notice=?,answer=? where studentid=?");
			pStatement.setString(1, student.getName());
			pStatement.setString(2, student.getSex());
			pStatement.setString(3, student.getIdnumber());
			pStatement.setString(4, student.getPhonum());
			pStatement.setString(5, student.getEmail());
			pStatement.setString(6, student.getDepartment());
			pStatement.setString(7, student.getMajor());
			pStatement.setString(8, student.getClassinfo());
			pStatement.setString(9, student.getNotice());
			pStatement.setString(10, student.getAnswer());
			pStatement.setString(11, student.getStudentid());
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
	//============================= 根据ID返回学生信息==================================================================================
	public Student findByKey(String id) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		Student student=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select studentid,studentpw,name,sex,idnumber,phonum,email,department,major,classinfo,notice,answer from studentinfo where studentid=?");
			pStatement.setString(1, id);
			rSet=pStatement.executeQuery();
			while(rSet.next()){
				String studentid=rSet.getString("studentid");
				String studentpw=rSet.getString("studentpw");
				String name=rSet.getString("name");
				String sex=rSet.getString("sex");
				String idnumber=rSet.getString("idnumber");
				String phonum=rSet.getString("phonum");
				String email=rSet.getString("email");
				String department=rSet.getString("department");
				String major=rSet.getString("major");
				String classinfo=rSet.getString("classinfo");
				String notice=rSet.getString("notice");
				String answer=rSet.getString("answer");
				student =new Student(studentid, studentpw, name, sex, idnumber, phonum, email, department,major, classinfo, notice, answer);
			}
			return student;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			DBUtil.close(connection);
		}
	}
	//============================= 查看学生是否匹配==================================================================================
	public boolean matched(String id,String pw) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select studentid,studentpw from studentinfo where studentid=? and studentpw=? and states=1");
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
//	//============================= 查看管理员是否匹配==================================================================================
//	public boolean oneAdminSelected(String id,String pw) throws Exception{
//		Connection connection=null;
//		PreparedStatement pStatement=null;
//		try {
//			connection=DBUtil.getConnection();
//			pStatement=connection.prepareStatement("select adminid,adminpw from admin where adminid=? and adminpw=?");
//			pStatement.setString(1, id);
//			pStatement.setString(2, pw);
//			if (pStatement.executeQuery().next()) {
//				return true;
//			}else {
//				return false;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}finally{
//			DBUtil.close(connection);
//		}
//	}
	//============================= 查看学生的状态==================================================================================
	public boolean states(String id) throws Exception{
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		try {
			connection=DBUtil.getConnection();
			pStatement=connection.prepareStatement("select states from studentinfo where studentid=?");
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
//	public static void main(String[] args) {
//		StudentDAO studentDAO=new StudentDAO();
//		try {
//			System.out.println(studentDAO.countStudentsPageBySize7(3));
//			System.out.println("==================================================================");
//			List<Student> students=studentDAO.findAllByPage(100, 3);
//			for (Student student : students) {
//				System.out.println(student);
//			}
//			System.out.println("==================================================================");
//			System.out.println(studentDAO.oneStudentSelected("20114070416", "123456"));
//			System.out.println(studentDAO.deleteStudent("20114070416"));
//			System.out.println(studentDAO.oneStudentSelected("20114070416", "123456"));
//			List<Student> students2=studentDAO.findAllByPage(100, 3);
//			for (Student student : students2) {
//				System.out.println(student);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//	}
	public List<Student> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
