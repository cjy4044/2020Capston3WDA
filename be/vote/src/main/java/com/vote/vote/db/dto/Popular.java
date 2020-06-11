package com.vote.vote.db.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="popular")
public class Popular {
    @Id
    @Column(name="popular_id", nullable=false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POPULAR_SEQ_GENERATOR")
    @SequenceGenerator(name="POPULAR_SEQ_GENERATOR", sequenceName="POPULAR_SEQ", allocationSize = 1)
    private int id;

    @Column(name="p_name", nullable=false) //인기인 이름
    private String name;

    @Column(name="p_image", nullable=false) //인기인 이미지
    private String img;

    @Column(name="program_id", nullable=false)
    private int pid;
    


    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}







	public int getPid() {
		return pid;
	}



	public void setPid(int pid) {
		this.pid = pid;
	}



	public String toString(){
        return "id["+id+"] p_name["+name+"] p_image["+img+"] program_id[ "+pid+"]";
        }

    
}