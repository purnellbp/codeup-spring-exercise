package com.codeup.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    // Setting the primary id of the column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Username cant be null and has to be unique.
    @Column(nullable = false, unique = true)
    private String username;

    //Email
    @Column(nullable = false)
    private String email;

    //password
    @Column
    private String password;


    // one-to-many, because each user can have multiple posts
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
