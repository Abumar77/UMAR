package com.boots.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Week {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int wid;

    @OneToOne
    private VideoMaterials videoMaterials;

    @OneToOne
    private TextMaterials textMaterials;


    @ManyToOne
    @JoinColumn(name = "cont_id")
    private Content content;



}
