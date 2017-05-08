package Services;

import Model.UserEntity;

import javax.xml.registry.infomodel.User;

/**
 * Created by drowerik3 on 08.05.17.
 */
public interface UserService {
    void saveUser(UserEntity userEntity);
    UserEntity getUser(int id);
    UserEntity getUserByUsername(String username);
    UserEntity authenticate(String login, String password);
}
