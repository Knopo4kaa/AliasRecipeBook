package Repositories;

import Model.HardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by drowerik on 22.05.16.
 */
public interface HardRepository extends JpaRepository<HardEntity, Integer> {
}
