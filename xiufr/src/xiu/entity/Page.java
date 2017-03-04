package xiu.entity;

public class Page {
	private String studentid;
	private String courseid;
	//总记录数量
	private int totalNotes;
	//总页数
	private int totalPages;
	//页量
	private int pageSize;
	//希望查询的页数
	private int page;
	private int start;
	public int getStart() {
		//计算总共需要多少页
		int mod=totalNotes%pageSize;
		if (mod==0) {
			totalPages=totalNotes/pageSize;
		} else {
			totalPages=totalNotes/pageSize+1;
		}
		//如果要查看的页数大于最大页，或者小于1，则取最后一页或第一页
		if (page>totalPages) {
			page=totalPages;
		}else if (page<1) {
			page=1;
		}
		start=(page-1)*pageSize;
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	@Override
	public String toString() {
		return "Page [page=" + page + ", pageSize=" + pageSize + ", start="
				+ start + ", studentid=" + studentid + ", totalNotes="
				+ totalNotes + ", totalPages=" + totalPages + "]";
	}
	public Page() {
		super();
	}
	public Page(String studentid, int totalNotes, int pageSize, int page) {
		super();
		this.studentid = studentid;
		this.totalNotes = totalNotes;
		this.pageSize = pageSize;
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPages() {
		//计算总共需要多少页
		int mod=totalNotes%pageSize;
		if (mod==0) {
			totalPages=totalNotes/pageSize;
		} else {
			totalPages=totalNotes/pageSize+1;
		}
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	
}
