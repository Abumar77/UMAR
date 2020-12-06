package com.boots.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Set;

@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cont_id;

    private String cont_name;

    @OneToMany (mappedBy = "contentV")
    private Set<VideoMaterials> videos;
    private int cont_vi_id;

    @OneToMany (mappedBy = "contentT")
    private Set<TextMaterials> texts;
    private int cont_text_id;

    @OneToMany (mappedBy = "content")
    private Set<Week> weeks;
//
//    @OneToOne(mappedBy = "contents")
//    private Course courses;



    public Content(String cont_name, Set<VideoMaterials> videos, int cont_vi_id, Set<TextMaterials> texts, int cont_text_id, Set<Week> weeks, Course courses) {
        this.cont_name = cont_name;
        this.videos = videos;
        this.cont_vi_id = cont_vi_id;
        this.texts = texts;
        this.cont_text_id = cont_text_id;
        this.weeks = weeks;
      //  this.courses = courses;
    }

    public Content() {

    }

    public Set<VideoMaterials> getVideos() {
        return videos;
    }

    public void setVideos(Set<VideoMaterials> videos) {
        this.videos = videos;
    }

    public Set<TextMaterials> getTexts() {
        return texts;
    }

    public void setTexts(Set<TextMaterials> texts) {
        this.texts = texts;
    }

    public Set<Week> getWeeks() {
        return weeks;
    }

    public void setWeeks(Set<Week> weeks) {
        this.weeks = weeks;
    }

    public int getCont_id() {
        return cont_id;
    }

    public void setCont_id(int cont_id) {
        this.cont_id = cont_id;
    }

    public String getCont_name() {
        return cont_name;
    }

    public void setCont_name(String cont_name) {
        this.cont_name = cont_name;
    }

    public int getCont_vi_id() {
        return cont_vi_id;
    }

    public void setCont_vi_id(int cont_vi_id) {
        this.cont_vi_id = cont_vi_id;
    }

    public int getCont_text_id() {
        return cont_text_id;
    }

    public void setCont_text_id(int cont_text_id) {
        this.cont_text_id = cont_text_id;
    }
//
//    public Course getCourses() {
//        return courses;
//    }
//
//    public void setCourses(Course courses) {
//        this.courses = courses;
//    }
}
