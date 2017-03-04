package entity.admin;

public class Note {
	private String noteid;
	private String studentid;
	private String courseid;
	private String singlecho;
	private String multicho;
	private String total;
	private String adddate;
	private String nandu;
	
	public String getNandu() {
		return nandu;
	}
	public void setNandu(String nandu) {
		this.nandu = nandu;
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
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getAdddate() {
		return adddate;
	}
	public void setAdddate(String adddate) {
		this.adddate = adddate;
	}
	
	public Note(String noteid, String studentid, String courseid,
			String singlecho, String multicho, String total, String adddate) {
		super();
		this.noteid = noteid;
		this.studentid = studentid;
		this.courseid = courseid;
		this.singlecho = singlecho;
		this.multicho = multicho;
		this.total = total;
		this.adddate = adddate;
	}
	public Note(String noteid, String studentid, String courseid,
			String singlecho, String multicho, String total, String adddate,
			String nandu) {
		super();
		this.noteid = noteid;
		this.studentid = studentid;
		this.courseid = courseid;
		this.singlecho = singlecho;
		this.multicho = multicho;
		this.total = total;
		this.adddate = adddate;
		this.nandu = nandu;
	}
	public Note() {
		super();
	}
	@Override
	public String toString() {
		return "Note [adddate=" + adddate + ", courseid=" + courseid
				+ ", multicho=" + multicho + ", noteid=" + noteid
				+ ", singlecho=" + singlecho + ", studentid=" + studentid
				+ ", total=" + total + "]";
	}
	
}
