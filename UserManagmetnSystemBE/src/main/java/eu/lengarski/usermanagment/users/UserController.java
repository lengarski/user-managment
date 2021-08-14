package eu.lengarski.usermanagment.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Georgi Lengarski on  Thursday 12/08/2021   21:11
 */
@RestController
public class UserController
{
    @GetMapping ("/test")
    public String test()
    {
        return "hello world";
    }
}
