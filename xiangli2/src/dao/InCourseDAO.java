package dao;

import java.util.List;

import entity.admin.Course;

public interface InCourseDAO extends DAO<Course>{
	List<Course> findByCondition(String sql)throws Exception;
}
