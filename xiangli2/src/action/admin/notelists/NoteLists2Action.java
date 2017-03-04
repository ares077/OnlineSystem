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
public class NoteLists2Action extends BaseAction{
	private List<Note> notes;
	private String nowPN;
	private String studentid;
	@Resource
	private InNoteDAO inNoteDAO;
	public String execute() {
		notes=new ArrayList<Note>();
		int now=1;
		try {
			if (studentid==null||studentid.equals("")) {
				return "fail";
			}
			int maxPage=inNoteDAO.countPageBySize(7,studentid);	
			if (maxPage==0) {
				return "fail";
			}
			if (nowPN!=null){
				now=Integer.parseInt(nowPN);
			}else {
				if (session.get("nowPN")!=null){
					now=Integer.parseInt(session.get("nowPN").toString());
				}
			}
			now=now<1?1:now;
			now=now>maxPage?maxPage:now;
			notes=inNoteDAO.findByPage(now, 7,studentid,"");
			session.put("nowPN", now);
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
	public String getNowPN() {
		return nowPN;
	}
	public void setNowPN(String nowPN) {
		this.nowPN = nowPN;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	
}
