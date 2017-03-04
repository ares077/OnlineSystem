package action.admin.questionlists;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import dao.InQuestionDAO;
import dao.admin.CourseDAO;
import entity.admin.Course;
import entity.admin.Question;
@Controller
@Scope("prototype")
public class LoadOneQuestionAction {
	private String questionid;
	private String nowPageQ;
	private String states;
	private Question question;
	private List<Course> courses;
	@Resource
	private InQuestionDAO inQuestionDAO;
	public String execute() {
		try {
			if (nowPageQ==null) {
				nowPageQ="1";
			}
			if (questionid==null||questionid.equals("")||!inQuestionDAO.checkKey(questionid)) {
				return "fail";
			}else {
				courses=new CourseDAO().findAll();
				question=inQuestionDAO.findByKey(questionid);
				boolean idDelete=inQuestionDAO.states(questionid);
				if (idDelete) {
					states="已禁用";
				}else {
					states="正在使用";
				}
				return "success";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String getQuestionid() {
		return questionid;
	}

	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}

	public String getNowPageQ() {
		return nowPageQ;
	}
	public void setNowPageQ(String nowPageQ) {
		this.nowPageQ = nowPageQ;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	
	

}
