package com.vote.vote.db.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="company")
public class Company{

    @Id
    @Column(name="c_id", nullable=false)
    private int id; //사업자번호 10자리
    
    @Column(name="r_id",nullable=false)
    private int rid;

    @Column(name="c_name",nullable=false)
    private String cname;
    
    @Column(name="c_content",nullable=false)
    private String ccontent;
    
    @Column(name="c_reader",nullable=false)
    private String creader;
    
    @Column(name="c_phone",nullable=false)
    private String cphone;
    
    @Column(name="c_program",nullable=false)
    private String cprogram;
  
    @Column(name="c_category",nullable=false)
    private String ccategory;
    
    @Column(name="c_startdate",nullable=false)
    private String cstartdate;
    
    @Column(name="c_enddate",nullable=false)
    private String cenddate;
    
    @Column(name="c_budget",nullable=false) //지출가능예산
    private int cbudget;
    
    @Column(name="c_confirm",nullable=false)
    private String cconfirm;
  
    





	public int getId() {
		return id;
	}







	public void setId(int id) {
		this.id = id;
	}







	public int getRid() {
		return rid;
	}







	public void setRid(int rid) {
		this.rid = rid;
	}







	public String getCname() {
		return cname;
	}







	public void setCname(String cname) {
		this.cname = cname;
	}







	public String getCcontent() {
		return ccontent;
	}







	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}







	public String getCreader() {
		return creader;
	}







	public void setCreader(String creader) {
		this.creader = creader;
	}







	public String getCphone() {
		return cphone;
	}







	public void setCphone(String cphone) {
		this.cphone = cphone;
	}







	public String getCprogram() {
		return cprogram;
	}







	public void setCprogram(String cprogram) {
		this.cprogram = cprogram;
	}







	public String getCcategory() {
		return ccategory;
	}







	public void setCcategory(String ccategory) {
		this.ccategory = ccategory;
	}







	public String getCstartdate() {
		String str = this.cstartdate;
		if(str != null) {
		String[] split = str.split(" ");
	 	return split[0]; }
		else {
			return cstartdate;
		}
	}







	public void setCstartdate(String cstartdate) {
		this.cstartdate = cstartdate;
	}







	public String getCenddate() {
		String str = this.cenddate;
		if(str != null) {
		String[] split = str.split(" ");
	 	return split[0]; }
		else {
			return cenddate;
		}
	}






	public void setCenddate(String cenddate) {
		this.cenddate = cenddate;
	}







	public int getCbudget() {
		return cbudget;
	}







	public void setCbudget(int cbudget) {
		this.cbudget = cbudget;
	}







	public String getCconfirm() {
		return cconfirm;
	}







	public void setCconfirm(String cconfirm) {
		this.cconfirm = cconfirm;
	}







	public String toString(){
        return "c_id["+id+"] r_id["+rid+"] c_name["+cname+"] c_content[ "+ccontent+"] c_reader[ "+creader+
        		"] c_phone["+cphone+"] c_program["+cprogram+"] c_category["+ccategory+
        		"] c_startdate["+cstartdate+"] c_enddate["+cenddate+"] c_budget["+cbudget+"] c_confirm["+cconfirm+"]";
        
	}
	
}