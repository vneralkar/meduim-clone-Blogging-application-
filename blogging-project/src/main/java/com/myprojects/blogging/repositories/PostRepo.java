package com.myprojects.blogging.repositories;

import com.myprojects.blogging.entities.Category;
import com.myprojects.blogging.entities.Post;
import com.myprojects.blogging.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
