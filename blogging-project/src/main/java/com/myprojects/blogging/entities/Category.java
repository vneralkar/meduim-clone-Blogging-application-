package com.myprojects.blogging.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="Categories")
public class Category {

    @Id //indicating the member field below is the primary key of current entity.
    @GeneratedValue(strategy = GenerationType.AUTO) //to configure the way of increment of the specified column(field).
    private Integer categoryId;
    @Column(name="Title", length=100, nullable=false)
    private String categoryTitle;
    @Column(name="Description", length=1000)
    private String categoryDescription;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // cascade all removes and adds childs to parent
    private List<Post> posts = new ArrayList<>();

}
