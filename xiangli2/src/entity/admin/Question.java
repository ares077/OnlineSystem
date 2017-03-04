package entity.admin;

public class Question {
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
	
	@Override
	public String toString() {
		return "Question [questionid=" + questionid + ", description="
				+ description + ", type=" + type + ", level=" + level
				+ ", paperid=" + paperid + ", adddate=" + adddate + ", a=" + a
				+ ", b=" + b + ", c=" + c + ", remark=" + remark + ", d=" + d
				+ ", e=" + e + ", f=" + f + ", answer=" + answer + "]";
	}
	public Question(String questionid, String description, String type,
			String level, String a, String b, String c, String d, String e,
			String f, String answer, String paperid, String remark,
			String adddate) {
		super();
		this.questionid = questionid;
		this.description = description;
		this.type = type;
		this.level = level;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		this.answer = answer;
		this.paperid = paperid;
		this.remark = remark;
		this.adddate = adddate;
	}
	public Question() {
		super();
	}
	public Question(String questionid, String description, String type,
			String level, String paperid, String adddate) {
		super();
		this.questionid = questionid;
		this.description = description;
		this.type = type;
		this.level = level;
		this.paperid = paperid;
		this.adddate = adddate;
	}
	public Question(String description, String type, String level, String a,
			String b, String c, String d, String e, String f, String answer,
			String paperid, String remark) {
		super();
		this.description = description;
		this.type = type;
		this.level = level;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		this.answer = answer;
		this.paperid = paperid;
		this.remark = remark;
	}
	
	
}
