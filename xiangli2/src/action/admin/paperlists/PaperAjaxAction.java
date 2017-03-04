package action.admin.paperlists;

import dao.admin.PaperDAO;
import entity.admin.Paper;

public class PaperAjaxAction {
	private String pid;
	private String pname;
	private Paper paper;
	public String execute() {
		try {
			String sql;
			if (pid==null)sql="select paperid,papername,courseid from paper where states=1 and papername='"+pname+"'";
			else if (pname==null) sql="select paperid,papername,courseid from paper where states=1 and paperid='"+pid+"'";
			else return "error";
			paper=new PaperDAO().findByCondition(sql);
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	
}
