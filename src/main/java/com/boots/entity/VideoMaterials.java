package com.boots.entity;

import javax.persistence.*;
import java.sql.Blob;


@Entity
public class VideoMaterials {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vid;

    private String nameVideoMaterial;
    private String description;


    @ManyToOne
    @JoinColumn(name = "cont_id")
    private Content contentV;


    @Lob()
    private Blob blob;


    public VideoMaterials(String nameVideoMaterial, String description, Content contentV, Blob blob) {
        this.nameVideoMaterial = nameVideoMaterial;
        this.description = description;
        this.contentV = contentV;
        this.blob = blob;
    }

    public Blob getBlob() {
        return blob;
    }

    public void setBlob(Blob blob) {
        this.blob = blob;
    }

    public VideoMaterials() {

    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }

    public String getNameVideoMaterial() {
        return nameVideoMaterial;
    }

    public void setNameVideoMaterial(String nameVideoMaterial) {
        this.nameVideoMaterial = nameVideoMaterial;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Content getContentV() {
        return contentV;
    }

    public void setContentV(Content contentV) {
        this.contentV = contentV;
    }
}
