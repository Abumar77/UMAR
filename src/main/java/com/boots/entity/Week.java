package com.boots.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
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


    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
