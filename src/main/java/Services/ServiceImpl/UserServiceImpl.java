package Services.ServiceImpl;

import Model.UserEntity;
import Repositories.UserRepository;
import Services.UserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by drowerik3 on 08.05.17.
 */
@Service
public class UserServiceImpl implements UserService{
    @Inject
    UserRepository userRepository;

    public UserEntity getUser(int id){
        return userRepository.findById(id);
    }

    public void saveUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    public UserEntity authenticate(String login, String password){
        return userRepository.findByUsernameAndPassword(login, password);
    }

    public UserEntity getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
