package action.admin.notelists;

import dao.admin.NoteDAO;
import entity.admin.Note;

public class LoadOneNoteAction {
	private String noteid;
	private Note note;
	public String execute() {
		try {
			note=new NoteDAO().findByKey(noteid);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public String getNoteid() {
		return noteid;
	}
	public void setNoteid(String noteid) {
		this.noteid = noteid;
	}
	public Note getNote() {
		return note;
	}
	public void setNote(Note note) {
		this.note = note;
	}
	
}
