package com.vote.vote.db.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name= "r_file")
public class Rfile {

   @Id 
   @Column(nullable=true, name="file_id")
   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="R_FILE_SEQ_GENERATOR")
   @SequenceGenerator(name="R_FILE_SEQ_GENERATOR", sequenceName="R_FILE_SEQ", allocationSize = 1)
    private int fileid;
   
    @Column(nullable=false, name="hotclib_id")
    private Integer hotclibid;

    @Column(nullable=true, name="apply_id")
    private Integer applyid;

    @Column(nullable=true, name="p_id")
    private Integer pid;

    @Column(nullable=true)
    private String filename;

    
    public int getFileid() {
		return fileid;
	}

	public void setFileid(int fileid) {
		this.fileid = fileid;
	}

	public Integer getHotclibid() {
        return hotclibid;
    }

    public void setHotclibid(Integer hotclibid) {
        this.hotclibid = hotclibid;
    }

    public Integer getApplyid() {
        return applyid;
    }

    public void setApplyid(Integer applyid) {
        this.applyid = applyid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public String toString(){
        return filename;
    }

}