package com.vote.vote.db.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;



@Entity
@Table(name="company")
public class Company{

    @Id
    @Column(name="c_id", nullable=false)
    private int id; //사업자번호 10자리
    
    @Column(name="r_id",nullable=false)
    private int r_id;

    @Column(nullable=false)
    private String c_name;
    
    @Column(nullable=false)
    private String c_content;
    
    @Column(nullable=false)
    private String c_reader;
    
    @Column(nullable=false)
    private String c_phone;
    
    @Column(nullable=false)
    private String c_program;
  
    @Column(nullable=false)
    private String c_category;
    
    @Column(nullable=false)
    private String c_startdate;
    
    @Column(nullable=false)
    private String c_enddate;
    
    @Column(nullable=false) //지출가능예산
    private int c_budget;
    
    @Column(nullable=false) 
    private String c_confirm;
  
    

  public int getId() {
		return id;
	}





	public void setId(int c_id) {
		this.id = c_id;
	}

//    public int getC_id() {
//		return c_id;
//	}
//
//
//
//
//
//	public void setC_id(int c_id) {
//		this.c_id = c_id;
//	}





	public int getR_id() {
		return r_id;
	}





	public void setR_id(int r_id) {
		this.r_id = r_id;
	}





	public String getC_name() {
		return c_name;
	}





	public void setC_name(String c_name) {
		this.c_name = c_name;
	}





	public String getC_content() {
		return c_content;
	}





	public void setC_content(String c_content) {
		this.c_content = c_content;
	}





	public String getC_reader() {
		return c_reader;
	}





	public void setC_reader(String c_reader) {
		this.c_reader = c_reader;
	}





	public String getC_phone() {
		return c_phone;
	}





	public void setC_phone(String c_phone) {
		this.c_phone = c_phone;
	}





	public String getC_program() {
		return c_program;
	}





	public void setC_program(String c_program) {
		this.c_program = c_program;
	}





	public String getC_category() {
		return c_category;
	}





	public void setC_category(String c_category) {
		this.c_category = c_category;
	}





	public String getC_startdate() {
		return c_startdate;
	}





	public void setC_startdate(String c_startdate) {
		this.c_startdate = c_startdate;
	}





	public String getC_enddate() {
		return c_enddate;
	}





	public void setC_enddate(String c_enddate) {
		this.c_enddate = c_enddate;
	}





	public int getC_budget() {
		return c_budget;
	}





	public void setC_budget(int c_budget) {
		this.c_budget = c_budget;
	}





	public String getC_confirm() {
		return c_confirm;
	}





	public void setC_confirm(String c_confirm) {
		this.c_confirm = c_confirm;
	}





	public String toString(){
        return "c_id["+id+"] r_id["+r_id+"] c_name["+c_name+"] c_content[ "+c_content+"] c_reader[ "+c_reader+
        		"] c_phone["+c_phone+"] c_program["+c_program+"] c_category[ "+c_category+
        		"] c_startdate[ "+c_startdate+"] c_enddate["+c_enddate+"] c_budget["+c_budget+"] c_confirm["+c_confirm+"]";
        
	}
	
}