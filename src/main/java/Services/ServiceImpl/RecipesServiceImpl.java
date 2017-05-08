package Services.ServiceImpl;

import Model.RecipeEntity;
import Model.UserEntity;
import Repositories.RecipeRepository;
import Services.RecipesService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by drowerik3 on 04.05.17.
 */
@Service
public class RecipesServiceImpl implements RecipesService {
    @Inject
    RecipeRepository recipeRepository;

    public List<RecipeEntity> getAllRecipes() {
        return recipeRepository.findAll();
    }
    public RecipeEntity getRecipe(int id) { return recipeRepository.findById(id);}
    public RecipeEntity saveRecipe(RecipeEntity recipeEntity) { return recipeRepository.save(recipeEntity);}
    public List<RecipeEntity> getRecipesByUser(UserEntity userEntity){
        return recipeRepository.findByUser(userEntity);
    }
}
