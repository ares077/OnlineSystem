package action.admin.paperlists;

import java.util.List;

import dao.admin.PaperDAO;

import entity.admin.Paper;

public class PaperListsAction {
	private List<Paper> papers;
	public String execute() {
		try {
			papers=new PaperDAO().findAll();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public List<Paper> getPapers() {
		return papers;
	}
	public void setPapers(List<Paper> papers) {
		this.papers = papers;
	}
	
}
