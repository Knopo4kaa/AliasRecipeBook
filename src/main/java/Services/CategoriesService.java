package Services;

import Model.CategoryEntity;

import java.util.List;

/**
 * Created by drowerik3 on 04.05.17.
 */
public interface CategoriesService {
    List<CategoryEntity> getAllCategories();
    CategoryEntity getCategory(int id);
    CategoryEntity saveCategory(CategoryEntity categoryEntity);
}
