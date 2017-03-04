package xiu.controller.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xiu.dao.ExamDAO;
import xiu.entity.Course;
import xiu.entity.Paper;

@Controller
@Scope("prototype")
@RequestMapping("/exload")
public class ExamAjaxController {
	@Resource
	private ExamDAO dao;
	@RequestMapping("/cname.xiu")
	@ResponseBody
	public Map<String, String> execute(String courseid){
		try {
			Course course=dao.findCourseByID(courseid);
			Map<String, String> map=new HashMap<String, String>();
			map.put("cname", course.getCoursename());
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("/pname.xiu")
	@ResponseBody
	public Map<String, String> execute3(String paperid){
		try {
			Paper paper=dao.findPaperByID(paperid);
			Map<String, String> map=new HashMap<String, String>();
			map.put("pname", paper.getPapername());
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping("/pid.xiu")
	@ResponseBody
	public List<Paper> execute2(String courseid){
		try {
			List<Paper> papers=dao.findPaperByCid(courseid);
			return papers;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
