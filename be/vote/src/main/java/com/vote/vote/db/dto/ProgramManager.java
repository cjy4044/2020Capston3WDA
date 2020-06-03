package com.vote.vote.db.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="P_MANAGER")
public class ProgramManager {
	@Id // real pk는아니지만 없으면 오류나기때문에 임의로 지정해준다. 
	@Column(name="R_ID", nullable=false)
    private int id;

    @Column(name="PROGRAM_ID", nullable=false)
    private int programId;

  
    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getProgramId() {
		return programId;
	}


	public void setProgramId(int programId) {
		this.programId = programId;
	}


	public String toString(){
        return "id["+id+"] program_id["+programId+"]";
        }

    
}