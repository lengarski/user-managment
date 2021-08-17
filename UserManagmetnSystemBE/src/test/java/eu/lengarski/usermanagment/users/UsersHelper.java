package eu.lengarski.usermanagment.users;

import java.time.LocalDate;

import eu.lengarski.usermanagment.users.entity.UserEntity;

/**
 * Created by Georgi Lengarski on  Tuesday 17/08/2021   07:54
 */
public class UsersHelper
{

    public static UserEntity generateUserEntity(String firstName, String lastName, String email)
    {
        UserEntity user = new UserEntity();
        user.setDateOfBirth(LocalDate.now());
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return user;
    }

}
