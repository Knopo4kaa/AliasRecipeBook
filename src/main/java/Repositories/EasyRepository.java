package Repositories;

import Model.EasyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by drowerik on 22.05.16.
 */
public interface EasyRepository extends JpaRepository<EasyEntity, Integer> {
//    List<EasyEntity> getWordsBy
}
