package com.myprojects.blogging.services.impl;

import com.myprojects.blogging.entities.Category;
import com.myprojects.blogging.entities.Post;
import com.myprojects.blogging.entities.User;
import com.myprojects.blogging.exceptions.ResourceNotFoundException;
import com.myprojects.blogging.payloads.CategoryDto;
import com.myprojects.blogging.payloads.PostDto;
import com.myprojects.blogging.repositories.CategoryRepo;
import com.myprojects.blogging.repositories.PostRepo;
import com.myprojects.blogging.repositories.UserRepo;
import com.myprojects.blogging.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId){

        User user =  this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","userId",userId));
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", categoryId));
        Post post = this.dtoToPost(postDto);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setCategory(cat);
        post.setUser(user);

        Post newpost = this.postRepo.save(post);

        return this.postToDto(newpost);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public PostDto getPostById(Integer postId) {
        return null;
    }

    @Override
    public List<PostDto> getAllPost() {
        return null;
    }

    @Override
    public List<PostDto> getPostsByCategoryId(Integer categoryId) {

        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category", "CategoryId",categoryId));
        List<Post> posts = this.postRepo.findByCategory(cat);
        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        return postDtos;
    }


    @Override
    public List<PostDto> getPostByUserId(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "UserId",userId));
        List<Post> posts = this.postRepo.findByUser(user);
        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    public Post dtoToPost(PostDto postDto){
        Post post = this.modelMapper.map(postDto, Post.class);

        return post;
    }

    public PostDto postToDto(Post post){
        PostDto postDto = this.modelMapper.map(post, PostDto.class);

//        postDto.setTitle(post.getTitle());
//        postDto.setContent(post.getContent());
//        postDto.setUser(post.getUser());
//        postDto.setCategory(post.getCategory());
//        postDto.setImageName(post.getImageName());
//        postDto.setAddedDate(post.getAddedDate());

        return postDto;
    }
}
