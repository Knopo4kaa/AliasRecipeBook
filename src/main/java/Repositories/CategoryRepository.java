package Repositories;

import Model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created by drowerik3 on 04.05.17.
 */
@Component
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    CategoryEntity findById(int id);
}
