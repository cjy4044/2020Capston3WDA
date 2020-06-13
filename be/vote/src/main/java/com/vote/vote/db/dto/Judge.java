package com.vote.vote.db.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="judge")
public class Judge {
    @Id
    @Column(name="judge_id", nullable=false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JUDEGE_SEQ_GENERATOR")
    @SequenceGenerator(name="JUDGE_SEQ_GENERATOR", sequenceName="JUDEGE_SEQ", allocationSize = 1)
    private int judgeid;

    @Column(name="program_id", nullable=false)
    private int pid;

    @Column(name="r_id", nullable=false)
    private int rid;

    

  


	public int getJudgeid() {
		return judgeid;
	}






	public void setJudgeid(int judgeid) {
		this.judgeid = judgeid;
	}






	public int getPid() {
		return pid;
	}






	public void setPid(int pid) {
		this.pid = pid;
	}






	public int getRid() {
		return rid;
	}






	public void setRid(int rid) {
		this.rid = rid;
	}






	public String toString(){
        return "judge_id["+judgeid+"] program_id["+pid+"] r_id["+rid+"]";
        }

    
}