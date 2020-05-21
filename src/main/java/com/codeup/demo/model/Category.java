package com.codeup.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;


    //Many categories can be mapped to many posts and vise versa
    @ManyToMany(mappedBy = "categories")
    private List<Post> posts;

}
