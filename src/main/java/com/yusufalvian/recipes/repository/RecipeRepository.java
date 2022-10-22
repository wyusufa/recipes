package com.yusufalvian.recipes.repository;

import com.yusufalvian.recipes.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe,Long> {
    List<Recipe> findRecipeByNameIgnoreCaseContainsOrderByDateDesc(String name);
    List<Recipe> findRecipeByCategoryIgnoreCaseOrderByDateDesc(String category);

    @Query("select r from Recipe r where r.userEntity.username = :username")
    List<Recipe> findRecipeByUsername(@Param("username") String username);

}

