package com.yusufalvian.recipes.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class RecipeOutDTO {

    private String name;

    private LocalDateTime date;

    private String category;

    private String description;

    private List<String> ingredients;

    private List<String> directions;

    private String author;
}
