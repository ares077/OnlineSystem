package xiu.dao;

import xiu.entity.Admin;
import xiu.entity.Student;

public interface LoginDAO {
	//判断学生是否匹配
	Student studentMatched(Student student)throws Exception;
	//判断管理员是否匹配额
	Admin adminMatched(Admin admin)throws Exception;
}
