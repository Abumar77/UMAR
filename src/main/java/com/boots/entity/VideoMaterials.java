package com.boots.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
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

    private String url;


    public VideoMaterials(String nameVideoMaterial, String description, Content contentV, String url) {
        this.nameVideoMaterial = nameVideoMaterial;
        this.description = description;
        this.contentV = contentV;
        this.url = url;
    }


}
