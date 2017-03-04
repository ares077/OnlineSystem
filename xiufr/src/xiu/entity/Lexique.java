package xiu.entity;

public class Lexique {
	private int lexiqueid;
	private String mot;
	private String declinaison;
	private String sensch;
	private String sensfr;
	private String locution1;
	private String locution2;
	private String locution3;
	private String phrase1;
	private String phrase2;
	private String phrase3;
	private String jour;
	private String user;
	private String state;
	public int getLexiqueid() {
		return lexiqueid;
	}
	public void setLexiqueid(int lexiqueid) {
		this.lexiqueid = lexiqueid;
	}
	public String getMot() {
		return mot;
	}
	public void setMot(String mot) {
		this.mot = mot;
	}
	public String getDeclinaison() {
		return declinaison;
	}
	public void setDeclinaison(String declinaison) {
		this.declinaison = declinaison;
	}
	public String getSensch() {
		return sensch;
	}
	public void setSensch(String sensch) {
		this.sensch = sensch;
	}
	public String getSensfr() {
		return sensfr;
	}
	public void setSensfr(String sensfr) {
		this.sensfr = sensfr;
	}
	public String getLocution1() {
		return locution1;
	}
	public void setLocution1(String locution1) {
		this.locution1 = locution1;
	}
	public String getLocution2() {
		return locution2;
	}
	public void setLocution2(String locution2) {
		this.locution2 = locution2;
	}
	public String getLocution3() {
		return locution3;
	}
	public void setLocution3(String locution3) {
		this.locution3 = locution3;
	}
	public String getPhrase1() {
		return phrase1;
	}
	public void setPhrase1(String phrase1) {
		this.phrase1 = phrase1;
	}
	public String getPhrase2() {
		return phrase2;
	}
	public void setPhrase2(String phrase2) {
		this.phrase2 = phrase2;
	}
	public String getPhrase3() {
		return phrase3;
	}
	public void setPhrase3(String phrase3) {
		this.phrase3 = phrase3;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Lexique(int lexiqueid, String mot, String declinaison,
			String sensch, String sensfr, String locution1, String locution2,
			String locution3, String phrase1, String phrase2, String phrase3,
			String jour, String user, String state) {
		super();
		this.lexiqueid = lexiqueid;
		this.mot = mot;
		this.declinaison = declinaison;
		this.sensch = sensch;
		this.sensfr = sensfr;
		this.locution1 = locution1;
		this.locution2 = locution2;
		this.locution3 = locution3;
		this.phrase1 = phrase1;
		this.phrase2 = phrase2;
		this.phrase3 = phrase3;
		this.jour = jour;
		this.user = user;
		this.state = state;
	}
	public Lexique() {
		super();
	}
	public Lexique(String mot, String declinaison, String sensch,
			String sensfr, String locution1, String locution2,
			String locution3, String phrase1, String phrase2, String phrase3,
			String jour, String user) {
		super();
		this.mot = mot;
		this.declinaison = declinaison;
		this.sensch = sensch;
		this.sensfr = sensfr;
		this.locution1 = locution1;
		this.locution2 = locution2;
		this.locution3 = locution3;
		this.phrase1 = phrase1;
		this.phrase2 = phrase2;
		this.phrase3 = phrase3;
		this.jour = jour;
		this.user = user;
	}
	@Override
	public String toString() {
		return "Lexique [lexiqueid=" + lexiqueid + ", mot=" + mot
				+ ", declinaison=" + declinaison + ", sensch=" + sensch
				+ ", sensfr=" + sensfr + ", locution1=" + locution1
				+ ", locution2=" + locution2 + ", locution3=" + locution3
				+ ", phrase1=" + phrase1 + ", phrase2=" + phrase2
				+ ", phrase3=" + phrase3 + ", jour=" + jour + ", user=" + user
				+ ", state=" + state + "]";
	}
	public Lexique(String mot, String user) {
		super();
		this.mot = mot;
		this.user = user;
	}
	public Lexique(int lexiqueid, String user) {
		super();
		this.lexiqueid = lexiqueid;
		this.user = user;
	}
	
}
