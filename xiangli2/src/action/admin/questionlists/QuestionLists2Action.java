package action.admin.questionlists;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import util.QuestionFindSql;
import action.BaseAction;
import dao.InQuestionDAO;
import dao.admin.CourseDAO;
import entity.admin.Course;
import entity.admin.Question;
@Controller
@Scope("prototype")
public class QuestionLists2Action extends BaseAction{
	private List<Question> questions;
	private String nowPageQ2;
	private List<Course> courses;
	private String paperid;
	private String type;
	private String level;
	private String key;
	@Resource
	private InQuestionDAO inQuestionDAO;
	public String execute() {
		questions=new ArrayList<Question>();
		int now=1;
		try {
			courses=new CourseDAO().findAll();
//			System.out.println("p:"+paperid);
//			System.out.println("t:"+type);
//			System.out.println("l:"+level);
//			System.out.println("k:"+key);
//			System.out.println("=====================================");
			String countSql=QuestionFindSql.findCountSql(paperid, type, level, key);
			int maxPage=inQuestionDAO.countPageBySize(5,countSql);
			if (maxPage==0) {
				return "fail";
			}
			String countSql2=countSql.replace("count(*)", "questionid,description,type,level,paperid,adddate");
			countSql2=countSql2+" order by questionid limit ?,?";
			if (nowPageQ2!=null){
				now=Integer.parseInt(nowPageQ2);
			}else {
				if (session.get("nowPageQ2")!=null){
					now=Integer.parseInt(session.get("nowPageQ2").toString());
				}
			}
			now=now<1?1:now;
			now=now>maxPage?maxPage:now;
			questions=inQuestionDAO.findByPage(now, 5,countSql,countSql2);
			session.put("nowPageQ2", now);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public String getNowPageQ2() {
		return nowPageQ2;
	}
	public void setNowPageQ2(String nowPageQ2) {
		this.nowPageQ2 = nowPageQ2;
	}
	
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public String getPaperid() {
		return paperid;
	}
	public void setPaperid(String paperid) {
		this.paperid = paperid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}	
	
}
