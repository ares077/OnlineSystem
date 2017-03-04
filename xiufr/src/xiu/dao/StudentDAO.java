package xiu.dao;

import xiu.entity.Student;

public interface StudentDAO {
	//根据ID查询出一个学生
	Student findByKey(String id)throws Exception;
	//修改信息
	void modify(Student student)throws Exception;
	//修改密码
	void modify2(Student student)throws Exception;
}
