package com.boots.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
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


//
//    public Course getCourses() {
//        return courses;
//    }
//
//    public void setCourses(Course courses) {
//        this.courses = courses;
//    }
}
