package com.myprojects.blogging.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.myprojects.blogging.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	

}
