package xiu.entity;

public class PageLexique {
	private String mot;
	private String user;
	private String jour;
	private String declinaison;
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

	
	public PageLexique() {
		super();
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
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public String getDeclinaison() {
		return declinaison;
	}
	public void setDeclinaison(String declinaison) {
		this.declinaison = declinaison;
	}
	public int getTotalNotes() {
		return totalNotes;
	}
	public void setTotalNotes(int totalNotes) {
		this.totalNotes = totalNotes;
	}
	public PageLexique(String user, int totalNotes, int pageSize, int page) {
		super();
		this.user = user;
		this.totalNotes = totalNotes;
		this.pageSize = pageSize;
		this.page = page;
	}
	public String getMot() {
		return mot;
	}
	public void setMot(String mot) {
		this.mot = mot;
	}
	@Override
	public String toString() {
		return "PageLexique [mot=" + mot + ", user=" + user + ", jour=" + jour
				+ ", declinaison=" + declinaison + ", totalNotes=" + totalNotes
				+ ", totalPages=" + totalPages + ", pageSize=" + pageSize
				+ ", page=" + page + ", start=" + start + "]";
	}
	public PageLexique(String mot, String user, String jour,
			String declinaison, int totalNotes, int totalPages, int pageSize,
			int page, int start) {
		super();
		this.mot = mot;
		this.user = user;
		this.jour = jour;
		this.declinaison = declinaison;
		this.totalNotes = totalNotes;
		this.totalPages = totalPages;
		this.pageSize = pageSize;
		this.page = page;
		this.start = start;
	}
	
	
}
