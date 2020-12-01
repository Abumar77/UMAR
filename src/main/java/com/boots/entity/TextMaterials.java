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
}
