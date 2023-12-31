package com.myprojects.blogging.payloads;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@NoArgsConstructor
public class PostDto {


    @NotEmpty
    private String title;
    @NotEmpty
    private String content;

    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;
}
