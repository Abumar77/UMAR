package com.boots.entity;


import javax.persistence.*;
import java.util.Set;


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

    @OneToOne(fetch = FetchType.EAGER)
    private Content contents;


    public Content getContents() {
        return contents;
    }

    public void setContents(Content contents) {
        this.contents = contents;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCprice() {
        return cprice;
    }

    public void setCprice(String cprice) {
        this.cprice = cprice;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

   public Course(){

   }

    public Course(String cname, String description, String cprice, Set<User> users, Content contents) {
        this.cname = cname;
        this.description = description;
        this.cprice = cprice;
        this.users = users;
        this.contents = contents;
    }
}
