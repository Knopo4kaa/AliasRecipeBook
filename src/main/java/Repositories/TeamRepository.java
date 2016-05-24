package Repositories;

import Model.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by drowerik on 24.05.16.
 */
public interface TeamRepository extends JpaRepository<TeamEntity, Integer> {

}
