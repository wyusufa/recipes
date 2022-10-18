package com.yusufalvian.recipes.repository;

import com.yusufalvian.recipes.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findUserEntityByUsername(String username);
}
