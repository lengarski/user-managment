package eu.lengarski.usermanagment.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import eu.lengarski.usermanagment.users.dto.UserDto;

/**
 * Created by Georgi Lengarski on  Thursday 12/08/2021   21:11
 */
@RestController
public class UserController
{

    @Autowired
    private UserService userService;

    @GetMapping ("/users/{email}")
    public UserDto getUser(@PathVariable ("email") String email)
    {
        return userService.getUserByEmail(email);
    }


    @GetMapping ("/users")
    public List<UserDto> getAllUsers()
    {
        return userService.getAllUsers();
    }


    @PostMapping ("/users")
    public void createUser(@RequestBody UserDto user)
    {
        userService.addNewUser(user);
    }

    @PutMapping ("/users/{email}")
    public void updateUser(@RequestBody UserDto user, @PathVariable String email)
    {
        userService.updateUser(user, email);
    }

    @DeleteMapping ("")
    public void deleteUser(@PathVariable String email)
    {
        userService.deleteUser(email);
    }

}
