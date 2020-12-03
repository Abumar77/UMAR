package com.boots.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Week {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int wid;

    private String description;

    private int score;



    @ManyToOne
    @JoinColumn(name = "cont_id")
    private Content content;

    public Week(String description, int score, Content content) {
        this.description = description;
        this.score = score;
        this.content = content;
    }

    public Week() {

    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
