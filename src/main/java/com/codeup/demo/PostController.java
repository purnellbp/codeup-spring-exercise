package com.codeup.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String hello() {
        return "This is posts index!";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String viewPost(@PathVariable Long id) {
        return "The is post # " + id;
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String createPost() {
        return "The is the post creation page";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPostSubmit() {
        return "This is the post creation page";
    }
}
