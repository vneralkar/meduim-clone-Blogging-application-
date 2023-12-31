package com.myprojects.blogging.services;

import com.myprojects.blogging.entities.Post;
import com.myprojects.blogging.payloads.PostDto;

import java.util.List;

public interface PostService {
   PostDto createPost(PostDto postDto,Integer userId, Integer categoryId);

   PostDto updatePost(PostDto postDto, Integer postId);

   void deletePost(Integer postId);

   PostDto getPostById( Integer postId);

   List<PostDto> getAllPost();

   List<PostDto> getPostsByCategoryId(Integer categoryId);

   List<PostDto> getPostByUserId(Integer userId);
}
