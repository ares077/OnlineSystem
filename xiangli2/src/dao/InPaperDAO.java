package dao;



import entity.admin.Paper;

public interface InPaperDAO extends DAO<Paper>{
	//检查名称
	boolean checkName(String name)throws Exception;
	//
	Paper findByCondition(String sql)throws Exception;
}
