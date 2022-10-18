package com.yusufalvian.recipes.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class RecipeDtoOut {

    private String name;

    private LocalDateTime date;

    private String category;

    private String description;

    private List<String> ingredients;

    private List<String> directions;
}
