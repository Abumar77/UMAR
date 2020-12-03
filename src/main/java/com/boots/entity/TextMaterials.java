package com.boots.entity;

import javax.persistence.*;

@Entity
public class TextMaterials {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
         private int tid;

         private String nameMaterial;
         private String full_text;


         @ManyToOne
         @JoinColumn(name = "cont_id")
         private Content contentT;


    public TextMaterials(String nameMaterial, String full_text, Content contentT) {
        this.nameMaterial = nameMaterial;
        this.full_text = full_text;
        this.contentT = contentT;
    }

    public TextMaterials() {

    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getNameMaterial() {
        return nameMaterial;
    }

    public void setNameMaterial(String nameMaterial) {
        this.nameMaterial = nameMaterial;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public Content getContentT() {
        return contentT;
    }

    public void setContentT(Content contentT) {
        this.contentT = contentT;
    }
}
