package co.move.in.test.BookMyShow.model;


import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class SystemSequenceIds {
	
	public static final String UNIQUE_SYS_GEN="kshfienk988439cskfiefh";
	public static final long counter = 1L;
	
	@Id
	private String id;
	private long seq;
	
	
	
	public SystemSequenceIds() {
		super();
	}
	public SystemSequenceIds(String id, long seq) {
		super();
		this.id = id;
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getSeq() {
		return seq;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}

}
