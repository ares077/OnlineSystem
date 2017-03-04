package dao;

import java.util.List;

public interface DAO<T> {
	//添加
	boolean add(T t)throws Exception;
	//检查主键唯一
	boolean checkKey(String key)throws Exception;
	//根据主键删除
	boolean delete(String key)throws Exception;
	//修改
	boolean modify(T t)throws Exception;
	//根据ID查找
	T findByKey(String key)throws Exception;
//	//总记录数量
//	int countPageBySize(int pageSize)throws Exception;
//	//分页查找返回集合
//	List<T> findByPage(int page,int pageSize)throws Exception;
	//查询所有
	List<T> findAll() throws Exception;
}
