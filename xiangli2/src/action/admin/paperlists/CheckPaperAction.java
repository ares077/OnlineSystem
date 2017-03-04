package action.admin.paperlists;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import dao.InPaperDAO;
@Controller
@Scope("prototype")
public class CheckPaperAction {
	private String paperid;
	private String papername;
	private String checkp_mag;
	@Resource
	private InPaperDAO inPaperDAO;
	public String execute() {
		try {
			if (paperid==null) {
				if (inPaperDAO.checkName(papername)) {
					checkp_mag="请修改名称";
					return "success";
				}else {
					checkp_mag="V";
					return "success";
				}
			}else {
				if (inPaperDAO.checkKey(paperid)) {
					checkp_mag="已经存在";
					return "success";
				}else {
					checkp_mag="V";
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
	public String getCheckp_mag() {
		return checkp_mag;
	}
	public void setCheckp_mag(String checkpMag) {
		checkp_mag = checkpMag;
	}
	
}
