package action.admin.paperlists;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import action.BaseAction;
import dao.InPaperDAO;
import entity.admin.Paper;
@Controller
@Scope("prototype")
public class AddPaperAction extends BaseAction{
	private String paperid;
	private String papername;
	private String courseid;
	private String paper_msg;
	@Resource
	private InPaperDAO inPaperDAO;
	public String execute() {
		try {
			Paper paper=new Paper(paperid, papername, courseid);
			if (inPaperDAO.checkKey(paperid)) {
				paper_msg="ID已经存在";
				return "fail";
			}else if (inPaperDAO.checkName(papername)) {
				paper_msg="请修改试卷名字";
				return "fail";
			}else {
				if (inPaperDAO.add(paper)) {
					session.put("apa", "添加成功");
					return "success";
				}else {
					session.put("apa", "添加失败");
					return "success";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
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
	public String getPaper_msg() {
		return paper_msg;
	}
	public void setPaper_msg(String paperMsg) {
		paper_msg = paperMsg;
	}
	
}
