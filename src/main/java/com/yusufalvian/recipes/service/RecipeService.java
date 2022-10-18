package com.yusufalvian.recipes.service;

import com.yusufalvian.recipes.dto.RecipeDtoOut;
import com.yusufalvian.recipes.entity.Recipe;
import com.yusufalvian.recipes.dto.RecipeDtoIn;
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

    public Recipe toRecipe(RecipeDtoIn recipeDtoIn) {
        Recipe inputRecipe = new Recipe();
        inputRecipe.setName(recipeDtoIn.getName());
        inputRecipe.setCategory(recipeDtoIn.getCategory());
        inputRecipe.setDate(LocalDateTime.now());
        inputRecipe.setDescription(recipeDtoIn.getDescription());
        inputRecipe.setIngredients(recipeDtoIn.getIngredients());
        inputRecipe.setDirections(recipeDtoIn.getDirections());
        inputRecipe.setUserEntity(userService.getUserEntity());
        return inputRecipe;
    }

    public Recipe toPartialUpdateRecipe(Recipe inputRecipe, RecipeDtoIn recipeDtoIn) {
        inputRecipe.setName(recipeDtoIn.getName());
        inputRecipe.setCategory(recipeDtoIn.getCategory());
        inputRecipe.setDate(LocalDateTime.now());
        inputRecipe.setDescription(recipeDtoIn.getDescription());
        inputRecipe.setIngredients(recipeDtoIn.getIngredients());
        inputRecipe.setDirections(recipeDtoIn.getDirections());
        return inputRecipe;
    }

    public List<RecipeDtoOut> toRecipeDtoOuts(List<Recipe> recipes) {
        var recipeDtoOuts = new ArrayList<RecipeDtoOut>();
        for (Recipe recipe : recipes) {
            recipeDtoOuts.add(toRecipeDtoOut(recipe));
        }
        return recipeDtoOuts;
    }

    public RecipeDtoOut toRecipeDtoOut(Recipe recipe) {
        RecipeDtoOut recipeDtoOut = new RecipeDtoOut();
        recipeDtoOut.setName(recipe.getName());
        recipeDtoOut.setCategory(recipe.getCategory());
        recipeDtoOut.setDate(recipe.getDate());
        recipeDtoOut.setDescription(recipe.getDescription());
        recipeDtoOut.setIngredients(recipe.getIngredients());
        recipeDtoOut.setDirections(recipe.getDirections());
        return recipeDtoOut;
    }


}
