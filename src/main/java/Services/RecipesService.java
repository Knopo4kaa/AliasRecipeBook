package Services;

import Model.RecipeEntity;
import Model.UserEntity;

import java.util.List;

/**
 * Created by drowerik3 on 04.05.17.
 */
public interface RecipesService {
    List<RecipeEntity> getAllRecipes();
    RecipeEntity getRecipe(int id);
    RecipeEntity saveRecipe(RecipeEntity recipeEntity) ;
    List<RecipeEntity> getRecipesByUser(UserEntity userEntity) ;
}
