package Services.ServiceImpl;

import Model.CategoryEntity;
import Model.RecipeEntity;
import Repositories.CategoryRepository;
import Services.CategoriesService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by drowerik3 on 04.05.17.
 */
@Service
public class CategoriesServiceImpl implements CategoriesService {
    @Inject
    CategoryRepository categoryRepository;

    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }
    public CategoryEntity getCategory(int id) { return categoryRepository.findById(id); }

    public CategoryEntity saveCategory(CategoryEntity categoryEntity){
        return categoryRepository.save(categoryEntity);
    }
}
