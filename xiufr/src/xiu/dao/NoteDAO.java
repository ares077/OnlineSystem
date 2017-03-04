package xiu.dao;

import java.util.List;

import xiu.entity.Course;
import xiu.entity.Note;
import xiu.entity.Page;

public interface NoteDAO {
	//查询总记录数量
	int countNote(String id)throws Exception;
	//根据课程查询总记录
	int countNoteByCID(Page page)throws Exception;
	//分页查询学生的
	List<Note> findByPage(Page page)throws Exception;
	//根据课程分页查询学生的
	List<Note> findByPageByCID(Page page)throws Exception;
	//查询所有课程ID
	List<Course> findCourses()throws Exception;
}
