package com.myprojects.blogging.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="Post")
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    private String title;

    @Column(length = 1000)
    private String content;

    private String imageName;
    private Date addedDate;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    @ManyToOne
    private User user;
}
