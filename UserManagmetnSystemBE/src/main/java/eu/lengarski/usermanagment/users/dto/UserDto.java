package eu.lengarski.usermanagment.users.dto;

import java.time.LocalDate;

/**
 * Created by Georgi Lengarski on  Monday 16/08/2021   07:33
 */
public class UserDto
{
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;

    public UserDto()
    {

    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public LocalDate getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }
}
