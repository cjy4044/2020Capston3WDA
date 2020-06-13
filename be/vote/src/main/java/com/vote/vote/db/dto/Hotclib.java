package com.vote.vote.db.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.web.multipart.MultipartFile;



@Entity
@Table(name = "hotclib")
public class Hotclib {
    @Id
    @Column(nullable=false, name="hotclib_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HOTCLIB_SEQ_GENERATOR")
    @SequenceGenerator(name="HOTCLIB_SEQ_GENERATOR", sequenceName="HOTCLIB_SEQ", allocationSize = 1)
    private Integer hotclibid;
    
    @Column(nullable=false, name="h_title")
    private String htitle;
    
    @Column(nullable=false)
    private String h_content;
   
    @Column(nullable=true)
    private String filename2;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable=true)
    private Date h_date;
    
    @Column(nullable=true)
    private Date h_mdate;
    
    @Column(nullable=true, name="h_view_count")
    private int hviewcount;

    @Column(nullable=true)
    private int h_reply_count;
    
    @Column(nullable=true)
    private String h_reply;

    @Column(nullable=true, name="r_id")
    private Integer no;

    @Column(nullable=true, name="program_id")
    private Integer programid;
    
 
    public String getHtitle() {
        return htitle;
    }

    public void setHtitle(String htitle) {
        this.htitle = htitle;
    }

    public String getH_content() {
        return h_content;
    }

    public void setH_content(String h_content) {
        this.h_content = h_content;
    }

    public Date getH_date() {
        return h_date;
    }

    public void setH_date(Date h_date) {
        this.h_date = h_date;
    }

    public Date getH_mdate() {
        return h_mdate;
    }

    public void setH_mdate(Date h_mdate) {
        this.h_mdate = h_mdate;
    }

    public int getHviewcount() {
        return hviewcount;
    }

    public void setHviewcount(int hviewcount) {
        this.hviewcount = hviewcount;
    }

    public int getH_reply_count() {
        return h_reply_count;
    }

    public void setH_reply_count(int h_reply_count) {
        this.h_reply_count = h_reply_count;
    }

    public String getH_reply() {
        return h_reply;
    }

    public void setH_reply(String h_reply) {
        this.h_reply = h_reply;
    }

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public Integer getProgramid() {
		return programid;
	}

	public void setProgramid(Integer programid) {
		this.programid = programid;
	}

    public Integer getHotclibid() {
        return hotclibid;
    }

    public void setHotclibid(Integer hotclibid) {
        this.hotclibid = hotclibid;
    }

    public String getFilename2() {
        return filename2;
    }

    public void setFilename2(String filename2) {
        this.filename2 = filename2;
    }

    public String toString(){
        return filename2;
    }


}