package com.boots.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Data
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cid;

    private String cname;

    private String description;

    private String cprice;


    @ManyToMany(mappedBy = "courses")
    private Set<User> users;


    public Course(String cname, String description, String cprice, Set<User> users, Content contents) {
        this.cname = cname;
        this.description = description;
        this.cprice = cprice;
        this.users = users;
      //  this.contents = contents;
    }
}
