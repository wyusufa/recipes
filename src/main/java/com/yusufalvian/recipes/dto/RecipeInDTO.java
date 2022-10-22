package com.yusufalvian.recipes.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class RecipeInDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String category;
    @NotBlank
    private String description;
    @NotEmpty
    private List<String> ingredients;
    @NotEmpty
    private List<String> directions;
}
