package com.myprojects.blogging.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class User {
	
	@Id //indicating the member field below is the primary key of current entity. 
	@GeneratedValue(strategy = GenerationType.AUTO) //to configure the way of increment of the specified column(field).
	private int id;
	@Column(name="user_name", nullable = false, length = 100)
	private String name;
	private String email;
	private String password;
	private String about;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // cascade all removes and adds childs to parent
	private List<Post> posts = new ArrayList<>();
	

}
