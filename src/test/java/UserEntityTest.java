import Model.UserEntity;
import Repositories.UserRepository;
import Services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/root.xml",
        "/view-resolver.xml" })
public class UserEntityTest {


    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void testUserWhenCreating(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("test");
        userEntity.setName("test");
        userEntity.setSurname("test");
        userEntity.setPassword("testpass");
        UserEntity savedUser = userService.saveUser(userEntity);
        UserEntity userFromDB = userService.getUser(savedUser.getId());
        userRepository.delete(savedUser);
        Assert.assertEquals(userFromDB, savedUser);
    }
}
