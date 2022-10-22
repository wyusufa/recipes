package com.yusufalvian.recipes.service;

import com.yusufalvian.recipes.dto.RecipeOutDTO;
import com.yusufalvian.recipes.entity.Recipe;
import com.yusufalvian.recipes.dto.RecipeInDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    final UserService userService;

    public RecipeService(UserService userService) {
        this.userService = userService;
    }

    public Recipe toRecipe(RecipeInDTO recipeInDTO) {
        Recipe inputRecipe = new Recipe();
        inputRecipe.setName(recipeInDTO.getName());
        inputRecipe.setCategory(recipeInDTO.getCategory());
        inputRecipe.setDate(LocalDateTime.now());
        inputRecipe.setDescription(recipeInDTO.getDescription());
        inputRecipe.setIngredients(recipeInDTO.getIngredients());
        inputRecipe.setDirections(recipeInDTO.getDirections());
        inputRecipe.setUserEntity(userService.getUserEntity());
        return inputRecipe;
    }

    public Recipe toPartialUpdateRecipe(Recipe inputRecipe, RecipeInDTO recipeInDTO) {
        inputRecipe.setName(recipeInDTO.getName());
        inputRecipe.setCategory(recipeInDTO.getCategory());
        inputRecipe.setDate(LocalDateTime.now());
        inputRecipe.setDescription(recipeInDTO.getDescription());
        inputRecipe.setIngredients(recipeInDTO.getIngredients());
        inputRecipe.setDirections(recipeInDTO.getDirections());
        return inputRecipe;
    }

    public List<RecipeOutDTO> toRecipeDtoOuts(List<Recipe> recipes) {
        var recipeDtoOuts = new ArrayList<RecipeOutDTO>();
        for (Recipe recipe : recipes) {
            recipeDtoOuts.add(toRecipeDtoOut(recipe));
        }
        return recipeDtoOuts;
    }

    public RecipeOutDTO toRecipeDtoOut(Recipe recipe) {
        RecipeOutDTO recipeOutDTO = new RecipeOutDTO();
        recipeOutDTO.setName(recipe.getName());
        recipeOutDTO.setCategory(recipe.getCategory());
        recipeOutDTO.setDate(recipe.getDate());
        recipeOutDTO.setDescription(recipe.getDescription());
        recipeOutDTO.setIngredients(recipe.getIngredients());
        recipeOutDTO.setDirections(recipe.getDirections());
        recipeOutDTO.setAuthor(recipe.getUserEntity().getUsername());
        return recipeOutDTO;
    }


}
