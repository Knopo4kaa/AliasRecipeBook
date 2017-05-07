package Repositories;

import Model.IngridientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by drowerik3 on 04.05.17.
 */
public interface IngridientRepository extends JpaRepository<IngridientEntity, Integer> {
    IngridientEntity findById(int id);
    List<IngridientEntity> findByTitle(String title);
}
