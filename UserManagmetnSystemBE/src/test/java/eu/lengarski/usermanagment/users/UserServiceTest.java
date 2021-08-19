package eu.lengarski.usermanagment.users;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import eu.lengarski.usermanagment.users.dto.UserDto;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Georgi Lengarski on  Thursday 19/08/2021   08:25
 */
@RunWith (SpringRunner.class)
@AutoConfigureTestDatabase (connection = EmbeddedDatabaseConnection.H2)
@SpringBootTest
public class UserServiceTest
{
    private static final String USER_MAIL = "mail@test.com";
    private static final String SECOND_USER_MAIL = "mail22@test.com";

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repository;


    @Test
    public void getAllUsers_getCountOfAllUsersStoredInDB()
    {
        repository.save(UsersHelper.generateUserEntity("first 1", "last 1", "mail1"));
        repository.save(UsersHelper.generateUserEntity("first 2", "last 2", "mail2"));
        repository.save(UsersHelper.generateUserEntity("first 3", "last 3", "mail3"));


        List<UserDto> all = service.getAllUsers();
        assertThat(all.size(), is(3));
    }

    @Test
    public void addUser_expectToFoundItByEmail()
    {
        setupUser();

        UserDto userByEmail = service.getUserByEmail(USER_MAIL);
        assertNotNull(userByEmail);
    }


    @Test (expected = RuntimeException.class)
    public void deleteExistingUser_expectSearchByMailToThrowError()
    {
        setupUser();

        service.deleteUser(USER_MAIL);

        service.getUserByEmail(USER_MAIL);
    }

    @Test
    public void updateUser_shoudChangeFirstName()
    {
        UserDto userDto = UsersHelper.generateUserDto("georgi", "petrov", SECOND_USER_MAIL);
        service.addNewUser(userDto);

        UserDto userByEmail = service.getUserByEmail(SECOND_USER_MAIL);
        userByEmail.setFirstName("NewUserName");

        service.updateUser(userByEmail, SECOND_USER_MAIL);

        UserDto updatedUser = service.getUserByEmail(SECOND_USER_MAIL);

        assertThat(updatedUser.getFirstName(), is("NewUserName"));

    }

    private void setupUser()
    {
        UserDto userDto = UsersHelper.generateUserDto("georgi", "petrov", USER_MAIL);
        service.addNewUser(userDto);
    }

}