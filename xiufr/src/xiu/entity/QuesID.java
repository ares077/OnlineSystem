package xiu.entity;

import java.util.LinkedList;

public class QuesID {
	private LinkedList<String> qid;

	public LinkedList<String> getQid() {
		return qid;
	}

	public void setQid(LinkedList<String> qid) {
		this.qid = qid;
	}

	@Override
	public String toString() {
		return "QuesID [qid=" + qid + "]";
	}

	public QuesID(LinkedList<String> qid) {
		super();
		this.qid = qid;
	}

	public QuesID() {
		super();
	}
	
}
