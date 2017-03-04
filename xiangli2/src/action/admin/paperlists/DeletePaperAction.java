package action.admin.paperlists;

import dao.admin.PaperDAO;
import action.BaseAction;

public class DeletePaperAction extends BaseAction{
	private String paperid;
	public String execute() {
		try {
			if (new PaperDAO().delete(paperid)) {
				session.put("mpa", "删除成功");
				return "success";
			}else {
				session.put("mpa", "删除失败");
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
	
}
