package action.admin.paperlists;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import action.BaseAction;
import dao.InPaperDAO;
import entity.admin.Paper;
@Controller
@Scope("prototype")
public class ModifyPaperAction extends BaseAction{
	private String paperid;
	private String papername;
	private String mpaper_msg;
	@Resource
	private InPaperDAO inPaperDAO;
	public String execute() {
		try {
			Paper paper=new Paper(paperid, papername);
			if (inPaperDAO.checkName(papername)) {
				session.put("mpa", "修该失败，请重新命名");
				return "success";
			}
			if (inPaperDAO.modify(paper)) {
				session.put("mpa", "修该成功");
				return "success";
			}else {
				session.put("mpa", "失败，请重稍后重试");
				return "success";
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
	public String getMpaper_msg() {
		return mpaper_msg;
	}
	public void setMpaper_msg(String mpaperMsg) {
		mpaper_msg = mpaperMsg;
	}
	
}
