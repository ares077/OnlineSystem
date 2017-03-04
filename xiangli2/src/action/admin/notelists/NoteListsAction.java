package action.admin.notelists;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import action.BaseAction;
import dao.InNoteDAO;
import entity.admin.Note;

@Controller
@Scope("prototype")
public class NoteListsAction extends BaseAction{
	private List<Note> notes;
	private String nowPageN;
	@Resource
	private InNoteDAO inNoteDAO;
	public String execute() {
		notes=new ArrayList<Note>();
		int now=1;
		try {
			
			int maxPage=inNoteDAO.countPageBySize(7);		
			if (nowPageN!=null){
				now=Integer.parseInt(nowPageN);
			}else {
				if (session.get("nowPageN")!=null){
					now=Integer.parseInt(session.get("nowPageN").toString());
				}
			}
			now=now<1?1:now;
			now=now>maxPage?maxPage:now;
			notes=inNoteDAO.findByPage(now, 7);
			session.put("nowPageN", now);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	public String getNowPageN() {
		return nowPageN;
	}
	public void setNowPageN(String nowPageN) {
		this.nowPageN = nowPageN;
	}
	
}
