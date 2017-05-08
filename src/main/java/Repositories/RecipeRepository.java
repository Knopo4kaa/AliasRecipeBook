package Repositories;

import Model.RecipeEntity;
import Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by drowerik3 on 04.05.17.
 */
public interface RecipeRepository extends JpaRepository<RecipeEntity, Integer> {
    RecipeEntity findById(int id);
    List<RecipeEntity> findByUser(UserEntity user);
}