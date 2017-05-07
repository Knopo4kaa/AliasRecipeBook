package Repositories;

import Model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by drowerik3 on 04.05.17.
 */
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    CategoryEntity findById(int id);
}
