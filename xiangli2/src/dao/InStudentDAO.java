package dao;

import java.util.List;

import entity.admin.Student;

public interface InStudentDAO extends DAO<Student>{
	//总记录数量
	int countPageBySize(int pageSize)throws Exception;
	//分页查找返回集合
	List<Student> findByPage(int page,int pageSize)throws Exception;
	//查看states状态 1返回true  0返回false
	boolean states(String key)throws Exception;
	//
	boolean matched(String id,String pw)throws Exception;
}
