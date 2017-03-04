package action.admin.notelists;

import dao.admin.NoteDAO;
import entity.admin.Note;

public class ModifyNoteAction{
	private String noteid;
	private String studentid;
	private String courseid;
	private String singlecho;
	private String multicho;
	private String adddate;
	private Note note;
	private String mnote_msg;
	public String execute() {
		try {
			String total=(Integer.parseInt(singlecho)+Integer.parseInt(multicho))+"";
			note=new Note(this.noteid, this.studentid, this.courseid, this.singlecho, this.multicho, total, this.adddate);
			if (new NoteDAO().modify(note)) {
				mnote_msg="修改成功";
				return "success";
			}else {
				mnote_msg="修改失败，请稍后重试";
				return "fail";
			}
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
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getSinglecho() {
		return singlecho;
	}
	public void setSinglecho(String singlecho) {
		this.singlecho = singlecho;
	}
	public String getMulticho() {
		return multicho;
	}
	public void setMulticho(String multicho) {
		this.multicho = multicho;
	}
	public String getAdddate() {
		return adddate;
	}
	public void setAdddate(String adddate) {
		this.adddate = adddate;
	}
	public Note getNote() {
		return note;
	}
	public void setNote(Note note) {
		this.note = note;
	}
	public String getMnote_msg() {
		return mnote_msg;
	}
	public void setMnote_msg(String mnoteMsg) {
		mnote_msg = mnoteMsg;
	}
	
}
