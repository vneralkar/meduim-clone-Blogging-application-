package com.myprojects.blogging.payloads;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Integer categoryId;
    @NotEmpty
    private String categoryTitle;
    @NotEmpty
    private String categoryDescription;
}


