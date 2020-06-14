package com.vote.vote.db.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

@DynamicUpdate
@DynamicInsert
@Entity
@Table(name="popular_board")
public class PopularBoard {
    @Id
    @Column(name="p_id", nullable=false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POPULAR_BOARD_SEQ_GENERATOR")
    @SequenceGenerator(name="POPULAR_BOARD_SEQ_GENERATOR", sequenceName="POPULAR_BOARD_SEQ", allocationSize = 1)
    private int id;

    @Column(name="popular_id", nullable=false) //인기인 이름
    private int popularid;

    @Column(name="p_title") //인기인 이미지
    private String title;

    @Column(name="p_content")
    private String content;
    
//    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name="p_date")
    private String date;
//
//    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name="p_mdate")
    private String mdate;
    
    @Column(name="p_view_count")
    private int viewcount;
    
    @Column(name="p_reply_count")
    private int replycount;
    
    @Column(name="r_id", nullable=false)
    private int rid;



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getPopularid() {
		return popularid;
	}



	public void setPopularid(int popularid) {
		this.popularid = popularid;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getDate() {
//		String str = this.date;
//		if(str != null) {
//		String[] split = str.split(" ");
//	 	return split[0]; }
//		else {}
			return date; 
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getMdate() {
		return mdate;
	}



	public void setMdate(String mdate) {
		this.mdate = mdate;
	}



	public int getViewcount() {
		return viewcount;
	}



	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}



	public int getReplycount() {
		return replycount;
	}



	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}



	public int getRid() {
		return rid;
	}



	public void setRid(int rid) {
		this.rid = rid;
	}



	public String toString(){
        return "id["+id+"] popular_id["+popularid+"] r_id["+rid+"] p_title["+title+"] p_content[ "+content+"]"
        		+ "p_date["+date+"] m_date["+mdate+"] p_view_count["+viewcount+"] p_reply_count[ "+replycount+"]";
        }

    
}