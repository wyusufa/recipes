package com.yusufalvian.recipes.controller;

import com.yusufalvian.recipes.entity.Recipe;
import com.yusufalvian.recipes.dto.RecipeDtoIn;
import com.yusufalvian.recipes.repository.RecipeRepository;
import com.yusufalvian.recipes.service.RecipeService;
import com.yusufalvian.recipes.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
    private final RecipeRepository recipeRepository;
    private final RecipeService recipeService;

    private final UserService userService;


    public RecipeController(RecipeRepository recipeRepository, RecipeService recipeService, UserService userService, UserService userService1) {
        this.recipeRepository = recipeRepository;
        this.recipeService = recipeService;
        this.userService = userService1;
    }

    @PostMapping("/new")
    public String postRecipe(@Valid @RequestBody RecipeDtoIn recipeDtoIn) {
        Recipe recipe = recipeService.toRecipe(recipeDtoIn);
        recipeRepository.save(recipe);
        return String.format("{\"id\":%s}",recipe.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseGet(() -> null);
        if (recipe != null) return new ResponseEntity<>(recipe, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRecipe(@PathVariable Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseGet(() -> null);
        if (recipe != null) {
            if (Objects.equals(recipe.getUserEntity().getUsername(), userService.getAuthUserName())) {
                recipeRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRecipe(@PathVariable Long id, @Valid @RequestBody RecipeDtoIn recipeDtoIn) {
        Recipe recipe = recipeRepository.findById(id).orElseGet(() -> null);
        if (recipe != null) {
            if (Objects.equals(recipe.getUserEntity().getUsername(), userService.getAuthUserName())) {
                Recipe updateRecipe = recipeService.toPartialUpdateRecipe(recipe,recipeDtoIn);
                recipeRepository.save(updateRecipe);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/search", params = "category")
    public ResponseEntity<?> getRecipeByCategory(@RequestParam String category) {
        if (category == null || category.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        var recipes = recipeRepository.findRecipeByCategoryIgnoreCaseOrderByDateDesc(category);
        if (recipes != null) {
            var recipesDtoOut = recipeService.toRecipeDtoOuts(recipes);
            return new ResponseEntity<>(recipesDtoOut,HttpStatus.OK);
        }

        return new ResponseEntity<>("[ ]",HttpStatus.OK);
    }

    @GetMapping(value="/search", params = "name")
    public ResponseEntity<?>  getRecipeByName(@RequestParam String name) {
        if (name == null || name.isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        var recipes = recipeRepository.findRecipeByNameIgnoreCaseContainsOrderByDateDesc(name);
        if (recipes != null) {
            var recipesDtoOut = recipeService.toRecipeDtoOuts(recipes);
            return new ResponseEntity<>(recipesDtoOut,HttpStatus.OK);
        }
        return new ResponseEntity<>("[ ]",HttpStatus.OK);
    }
}
