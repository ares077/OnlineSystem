package dao;

import java.util.List;

import entity.admin.Note;

public interface InNoteDAO extends DAO<Note>{
	//根据条件查询总记录数量
	int countPageBySize(int pageSize,String sql)throws Exception;
	//根据条件分页查找返回集合
	List<Note> findByPage(int page,int pageSize,String sql1,String sql2)throws Exception;
	//总记录数量
	int countPageBySize(int pageSize)throws Exception;
	//分页查找返回集合
	List<Note> findByPage(int page,int pageSize)throws Exception;
}
