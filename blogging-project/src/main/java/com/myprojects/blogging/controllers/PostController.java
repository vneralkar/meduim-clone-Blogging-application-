package com.myprojects.blogging.controllers;

import com.myprojects.blogging.entities.Post;
import com.myprojects.blogging.payloads.PostDto;
import com.myprojects.blogging.services.PostService;
import lombok.Getter;
import org.modelmapper.internal.TypeResolvingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postservice;
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postdto, @PathVariable Integer userId, @PathVariable Integer categoryId){

        PostDto  createPost = this.postservice.createPost(postdto, userId, categoryId);

        return new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUserId(@PathVariable Integer userId){
        List<PostDto> posts = this.postservice.getPostByUserId(userId);

        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategoryId(@PathVariable Integer categoryId){
        List<PostDto> posts = this.postservice.getPostsByCategoryId(categoryId);

        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }


}
