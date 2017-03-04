package action.admin.questionlists;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import action.BaseAction;
import dao.InQuestionDAO;
import dao.admin.CourseDAO;
import entity.admin.Course;
import entity.admin.Question;
@Controller
@Scope("prototype")
public class AddQuestionAction extends BaseAction{
	private String  description;
	private String  type;
	private String  level;
	private String  a;
	private String  b;
	private String  c;
	private String  d;
	private String  e;
	private String  f;
	private String  answer;
	private String  paperid;
	private String  remark;
	private String addq_msg;
	private Question question;
	private List<Course> courses;
	@Resource
	private InQuestionDAO inQuestionDAO;
	public String execute() {
		try {
			question=new Question(description, type, level, a, b, c, this.d, this.e, f, answer, paperid, remark);
			courses=new CourseDAO().findAll();
			if (description.equals("")) {
				 addq_msg="题目描述不能为空";
				 return "fail";
			}else if (type.equals("")) {
				addq_msg="题目类型不能为空";
				 return "fail";
			}else if (level.equals("")) {
				addq_msg="题目难度不能为空";
				 return "fail";
			}else if (a.equals("")||b.equals("")||c.equals("")||d.equals("")) {
				addq_msg="题目选项不能为空";
				 return "fail";
			}else if (answer.equals("")) {
				addq_msg="题目答案不能为空";
				 return "fail";
			}else if (paperid.equals("")) {
				addq_msg="所属试卷不能为空";
				 return "fail";
			}
			if (inQuestionDAO.add(question)) {
				addq_msg="添加成功";
				session.put("addq_msg", addq_msg);
				return "success";
			} else {
				addq_msg="添加失败";
				return "fail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	public String getE() {
		return e;
	}
	public void setE(String e) {
		this.e = e;
	}
	public String getF() {
		return f;
	}
	public void setF(String f) {
		this.f = f;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getPaperid() {
		return paperid;
	}
	public void setPaperid(String paperid) {
		this.paperid = paperid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAddq_msg() {
		return addq_msg;
	}
	public void setAddq_msg(String addqMsg) {
		addq_msg = addqMsg;
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
