package com.vote.vote.db.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="program")
public class Program {
    @Id
    @Column(name="program_id", nullable=false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROGRAM_SEQ_GENERATOR")
    @SequenceGenerator(name="PROGRAM_SEQ_GENERATOR", sequenceName="PROGRAM_SEQ", allocationSize = 1)
    private int id;

    @Column(name="p_name", nullable=false)
    private String name;

    @Column(name="p_image", nullable=false)
    private String img;

    @Column(name="p_category", nullable=false)
    private String category;

    @Column(name="p_info", nullable=true)
    private String info;
    

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String toString(){
        return "id["+id+"] p_name["+name+"] p_image["+img+"] p_category[ "+category+"]";
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

    
}