package Repositories;

import Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by drowerik3 on 08.05.17.
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findById(int id);
    UserEntity findByUsernameAndPassword(String username, String password);
    UserEntity findByUsername(String username);
}
