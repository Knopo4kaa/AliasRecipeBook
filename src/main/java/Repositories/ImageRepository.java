package Repositories;

import Model.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by drowerik3 on 04.05.17.
 */
public interface ImageRepository extends JpaRepository<ImageEntity, Integer> {
}
