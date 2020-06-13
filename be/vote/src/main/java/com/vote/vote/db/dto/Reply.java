package com.vote.vote.db.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "reply")
public class Reply {
    @Id
    @Column(nullable=true, name="reply_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REPLY_SEQ_GENERATOR")
    @SequenceGenerator(name="REPLY_SEQ_GENERATOR", sequenceName="REPLY_SEQ", allocationSize = 1)
    private int replyid;

    @Column(nullable=true)
    private String r_content;

    @Column(nullable=true)
    private Date r_date;

    @Column(nullable=true , name="hotclib_id")
    private Integer hotclibid;

    @Column(nullable=true)
    private Integer p_id;

    @Column(nullable=true)
    private Integer depth;

    @Column(nullable=true)
    private Integer r_id;

    public int getReplyid() {
        return replyid;
    }

    public void setReplyid(int replyid) {
        this.replyid = replyid;
    }

    public String getR_content() {
        return r_content;
    }

    public void setR_content(String r_content) {
        this.r_content = r_content;
    }

    public Date getR_date() {
        return r_date;
    }

    public void setR_date(Date r_date) {
        this.r_date = r_date;
    }

  
    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public int getHotclibid() {
        return hotclibid;
    }

    public void setHotclibid(int hotclibid) {
        this.hotclibid = hotclibid;
    }

    
}