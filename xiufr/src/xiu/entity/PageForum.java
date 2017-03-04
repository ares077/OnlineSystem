package xiu.entity;

public class PageForum {
	private String title;
	private String category;
	private String author;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getTotalNotes() {
		return totalNotes;
	}
	public void setTotalNotes(int totalNotes) {
		this.totalNotes = totalNotes;
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
	
	public PageForum(String title, String category, String author, int totalNotes, int totalPages, int pageSize,
			int page, int start) {
		super();
		this.title = title;
		this.category = category;
		this.author = author;
		this.totalNotes = totalNotes;
		this.totalPages = totalPages;
		this.pageSize = pageSize;
		this.page = page;
		this.start = start;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public PageForum() {
		super();
	}
	public PageForum(String title, String category, String author) {
		super();
		this.title = title;
		this.category = category;
		this.author = author;
	}
	public PageForum(String title, String category, String author, int totalNotes, int pageSize) {
		super();
		this.title = title;
		this.category = category;
		this.author = author;
		this.totalNotes = totalNotes;
		this.pageSize = pageSize;
	}

	
}
