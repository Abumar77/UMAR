package com.boots.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class TextMaterials {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
         private int tid;

         private String name_material;
         private String full_text;


         @ManyToOne
         @JoinColumn(name = "cont_id")
         private Content contentT;


    public TextMaterials(String nameMaterial, String full_text, Content contentT) {
        this.name_material = nameMaterial;
        this.full_text = full_text;
        this.contentT = contentT;
    }
}
