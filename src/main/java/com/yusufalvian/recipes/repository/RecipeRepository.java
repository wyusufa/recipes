package com.yusufalvian.recipes.repository;

import com.yusufalvian.recipes.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
    List<Recipe> findRecipeByNameIgnoreCaseContainsOrderByDateDesc(String name);
    List<Recipe> findRecipeByCategoryIgnoreCaseOrderByDateDesc(String category);



}

