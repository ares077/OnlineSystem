package xiu.entity;

public class Forum {
	private int postsid;
	private String title;
	private String category;
	private String jour;
	private String author;
	private String content;
	private String lien;
	private String state;
	@Override
	public String toString() {
		return "Forum [postsid=" + postsid + ", title=" + title + ", category=" + category + ", jour=" + jour
				+ ", author=" + author + ", content=" + content + ", lien=" + lien + ", state=" + state
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public int getPostsid() {
		return postsid;
	}
	public void setPostsid(int postsid) {
		this.postsid = postsid;
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
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Forum(int postsid, String title, String category, String jour, String author, String content, String lien,
			String state) {
		super();
		this.postsid = postsid;
		this.title = title;
		this.category = category;
		this.jour = jour;
		this.author = author;
		this.content = content;
		this.lien = lien;
		this.state = state;
	}
	public Forum() {
		super();
	}
	
}
