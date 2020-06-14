package com.vote.vote.db.dto;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "p_color")
public class PrdColor {

    @Id
    @Column(name="color_id",nullable = false)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="P_COLOR_SEQ_GENERATOR")
    @SequenceGenerator(name="P_COLOR_SEQ_GENERATOR", sequenceName="P_COLOR_SEQ", allocationSize = 1)
    private int colorId;

    @Column(name="p_color",nullable = false)
    private String pColor;

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getpColor() {
        return pColor;
    }

    public void setpColor(String pColor) {
        this.pColor = pColor;
    }
}