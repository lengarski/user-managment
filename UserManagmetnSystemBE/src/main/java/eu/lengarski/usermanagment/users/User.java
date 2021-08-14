package eu.lengarski.usermanagment.users;

import java.time.LocalDate;

import javax.persistence.*;

/**
 * Created by Georgi Lengarski on  Thursday 12/08/2021   08:19
 */
@Entity (name = "user")
public class User
{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Long id;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "email")
    private String email;

    @Column (name = "date_of_birth")
    private LocalDate dateOfBirth;

}
