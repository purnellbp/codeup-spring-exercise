package com.codeup.demo.controllers;

import com.blogproject.blog.model.Post;
import com.blogproject.blog.model.User;
import com.blogproject.blog.repositories.PostRepository;
import com.blogproject.blog.repositories.UserRepository;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PostController {

    private UserRepository userDao;
    private PostRepository postRepo;

    public PostController(UserRepository userDao, PostRepository postRepo) {
        this.userDao = userDao;
        this.postRepo = postRepo;
    }

    @GetMapping("/posts")
    public String showPostsIndexPage(Model model) {
        List<Post> postList = postRepo.findAll();
        model.addAttribute("posts", postList);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showAnIndividualPost(@PathVariable long id, Model model) {
        Post thisPost = postRepo.getOne(id);
        model.addAttribute("post", thisPost);

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createPost() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String submitCreatePost(@RequestParam String title, @RequestParam String body) {
        // before saving a post to the db, assign a user to that post
        User author = userDao.getOne(1L);
        Post newPost = new Post();
        newPost.setTitle(title);
        newPost.setBody(body);

        // TODO: Manually inserting user id 1 until user login implemented.
        newPost.setUser(author);

        postRepo.save(newPost);
        return "redirect:/posts";
    }



    @GetMapping("/posts/{id}/edit")
    public String getEditPostForm(@PathVariable long id, Model model) {
        Post aPost = postRepo.getOne(id);
        model.addAttribute("post", aPost);
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String savePostEdit(@PathVariable long id, @RequestParam String title, @RequestParam String body, Model model) {
        Post editPost = postRepo.getOne(id);

        editPost.setTitle(title);
        editPost.setBody(body);
        postRepo.save(editPost);

        return "redirect:/posts/" + id;
    }

    @GetMapping("/posts/{id}/delete")
    public String getDeletePostForm(@PathVariable long id, Model model) {
        Post aPost = postRepo.getOne(id);
        model.addAttribute("post", aPost);
        return "posts/delete";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        Post aPost = postRepo.getOne(id);
        postRepo.delete(aPost);
        return "redirect:/posts";
    }


}
