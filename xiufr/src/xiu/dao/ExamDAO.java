package xiu.dao;

import java.util.List;

import xiu.entity.Course;
import xiu.entity.Note;
import xiu.entity.Paper;
import xiu.entity.QuesID;
import xiu.entity.Question;

public interface ExamDAO {
	//查询所有课程ID
	List<Course> findCourses()throws Exception;
	//查询单个课程
	Course findCourseByID(String id)throws Exception;
	//根据课程查询Papers
	List<Paper> findPaperByCid(String id)throws Exception;
	//查找单个paper
	Paper findPaperByID(String id)throws Exception;
	//查看学生今天是否考试，查询noteid
	Note findNoteID(Note note)throws Exception;
	//查询所有符合规定的试题
	List<Question> findQuestionsSin(String id)throws Exception;
	//查询所有符合规定的试题
	List<Question> finQuestionsMul(String id)throws Exception;
	//查询所有符合规定的答案
	List<Question> findAnswer(QuesID quesID)throws Exception;
	//根据paperid找courseid
	String findCidByPid(String id)throws Exception;
	//添加记录
	void addNote(Note note)throws Exception;
	//根据noteid查询出一个note
	Note findNoteById(String id)throws Exception;
}
