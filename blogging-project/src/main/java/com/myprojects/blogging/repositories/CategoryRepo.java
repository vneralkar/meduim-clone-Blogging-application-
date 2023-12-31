package com.myprojects.blogging.repositories;

import com.myprojects.blogging.entities.Category;
import com.myprojects.blogging.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
