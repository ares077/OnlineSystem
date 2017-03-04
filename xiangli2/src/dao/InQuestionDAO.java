package dao;

import java.util.List;

import entity.admin.Question;

public interface InQuestionDAO extends DAO<Question>{
	//根据条件查询总记录数量
	int countPageBySize(int pageSize,String sql)throws Exception;
	//根据条件分页查找返回集合
	List<Question> findByPage(int page,int pageSize,String sql1,String sql2)throws Exception;
	//总记录数量
	int countPageBySize(int pageSize)throws Exception;
	//分页查找返回集合
	List<Question> findByPage(int page,int pageSize)throws Exception;
	//根据主键重新添加
	boolean reAdd(String key)throws Exception;
	//查看states状态 1返回true  0返回false
	boolean states(String key)throws Exception;
}
