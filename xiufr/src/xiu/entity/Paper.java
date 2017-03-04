package xiu.entity;

public class Paper {
	private String paperid;
	private String papername;
	private String courseid;
	public String getPaperid() {
		return paperid;
	}
	public void setPaperid(String paperid) {
		this.paperid = paperid;
	}
	public String getPapername() {
		return papername;
	}
	public void setPapername(String papername) {
		this.papername = papername;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	@Override
	public String toString() {
		return "Paper [courseid=" + courseid + ", paperid=" + paperid
				+ ", papername=" + papername + "]";
	}
	public Paper(String paperid, String papername, String courseid) {
		super();
		this.paperid = paperid;
		this.papername = papername;
		this.courseid = courseid;
	}
	public Paper() {
		super();
	}
	public Paper(String paperid) {
		super();
		this.paperid = paperid;
	}
	public Paper(String paperid, String courseid) {
		super();
		this.paperid = paperid;
		this.courseid = courseid;
	}
	
}
