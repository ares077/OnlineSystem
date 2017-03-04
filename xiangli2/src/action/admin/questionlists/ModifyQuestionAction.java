package action.admin.questionlists;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import action.BaseAction;
import dao.InQuestionDAO;
import entity.admin.Question;
@Controller
@Scope("prototype")
public class ModifyQuestionAction extends BaseAction{
	private String  questionid;
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
	private String  adddate;
	private String modify_msg;
	private String isOn;
	private Question question;
	private String states;
	@Resource
	private InQuestionDAO inQuestionDAO;
	public String  execute() {
		try {
			//question=new Question(questionid, description, type, level, a, b, c, d, e, f, answer, paperid, remark, adddate);
			//question=new Question(questionid, description, type, level, a, b, c, d, description, f, answer, paperid, remark, adddate);
		    question = new Question(questionid, description, type, level, a, b, c, d, this.e, f, answer, paperid, remark, adddate); 
		     if (isOn.equals("1")) {
				inQuestionDAO.reAdd(question.getQuestionid());
				states="正在使用";
				modify_msg="启用成功";
				return "success";
			}
		    if (inQuestionDAO.modify(question)) {
				modify_msg="修改成功";
				return "success";
			}
			modify_msg="有错误，请稍后重试";
			return "fail";
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
	public String getAdddate() {
		return adddate;
	}
	public void setAdddate(String adddate) {
		this.adddate = adddate;
	}
	public String getModify_msg() {
		return modify_msg;
	}
	public void setModify_msg(String modifyMsg) {
		modify_msg = modifyMsg;
	}
	public String getIsOn() {
		return isOn;
	}
	public void setIsOn(String isOn) {
		this.isOn = isOn;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public String getStates() {
		return states;
	}
	public void setStates(String states) {
		this.states = states;
	}

	
}
