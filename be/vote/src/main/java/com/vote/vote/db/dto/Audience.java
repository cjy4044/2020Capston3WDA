package com.vote.vote.db.dto;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(
  name = "B_APPLY_GENERATOR", 
  sequenceName = "B_APPLY_SEQ", // 매핑할 데이터베이스 시퀀스 이름 
  allocationSize = 1)
@Table(name = "b_apply")
public class Audience {
  
    @Id
    @Column(nullable = false, name="apply_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "B_APPLY_SEQ_GENERATOR")
    private int applyId;

    @Column(nullable = false, name="a_title")
    private String aTitle; // 제목

    @Column(nullable = false, name="a_content")
    private String aContent; // 내용41

    @Column(name = "a_startdate")
    private Date aStartdate; // 응모시작일

    @Column(name = "a_enddate")
    private Date aEnddate; // 응모마감일

    @Column(name = "a_date")
    private Date aDate; // 입장시간

    @Column(name = "a_mdate")
    private Date aMdate; // 공연시작시작

    @Column(name = "a_recruits")
    private int aRecruits; // 추첨인원\

    @Column(name = "a_view")
    private String aView; // 결과공개여부(1자리)

    @Column(name = "a_limit")
    private int aLimit; // 신청횟수 제한

    @Column(nullable = false, name="a_writer")
    private String rWriter; // 작성자

    @Column(name = "a_price")
    private int aPrice; // 소모포인트

    @Column(name = "broadcast_id")
    private int broadcastId; // 방송호ㅓㅣ차

    @Column(name = "a_view_count")
    private int aViewCount; // 조회수

    @Column(name = "a_limit_age")
    private int aLimitAge; // 연령제한

    @Column(name = "img")
    private String img; // 이미지

    @Column(name = "ticket_time")
    private Date ticketTime; // 티켓팅시간 맨아래3개 열 새로추가햇음

    public int getApplyId() {
        return this.applyId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    public String getATitle() {
        return this.aTitle;
    }

    public void setATitle(String aTitle) {
        this.aTitle = aTitle;
    }

    public String getAContent() {
        return this.aContent;
    }

    public void setAContent(String aContent) {
        this.aContent = aContent;
    }

    public Date getAStartdate() {
        return this.aStartdate;
    }

    public void setAStartdate(Date aStartdate) {
        this.aStartdate = aStartdate;
    }

    public Date getAEnddate() {
        return this.aEnddate;
    }

    public void setAEnddate(Date aEnddate) {
        this.aEnddate = aEnddate;
    }

    public Date getADate() {
        return this.aDate;
    }

    public void setADate(Date aDate) {
        this.aDate = aDate;
    }

    public Date getAMdate() {
        return this.aMdate;
    }

    public void setAMdate(Date aMdate) {
        this.aMdate = aMdate;
    }

    public int getARecruits() {
        return this.aRecruits;
    }

    public void setARecruits(int aRecruits) {
        this.aRecruits = aRecruits;
    }

    public String getAView() {
        return this.aView;
    }

    public void setAView(String aView) {
        this.aView = aView;
    }

    public int getALimit() {
        return this.aLimit;
    }

    public void setALimit(int aLimit) {
        this.aLimit = aLimit;
    }

    public String getrWriter() {
        return this.rWriter;
    }

    public void setRWriter(String rWriter) {
        this.rWriter = rWriter;
    }

    public int getAPrice() {
        return this.aPrice;
    }

    public void setAPrice(int aPrice) {
        this.aPrice = aPrice;
    }

    public int getBroadcastId() {
        return this.broadcastId;
    }

    public void setBroadcastId(int broadcastId) {
        this.broadcastId = broadcastId;
    }

    public int getAViewCount() {
        return this.aViewCount;
    }

    public void setAViewCount(int aViewCount) {
        this.aViewCount = aViewCount;
    }

    public int getALimitAge() {
        return this.aLimitAge;
    }

    public void setALimitAge(int aLimitAge) {
        this.aLimitAge = aLimitAge;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getTicketTime() {
        return this.ticketTime;
    }

    public void setTicketTime(Date ticketTime) {
        this.ticketTime = ticketTime;
    }

	public Audience toEntity() {
		return null;
	}
    

    
}