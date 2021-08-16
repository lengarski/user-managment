package eu.lengarski.usermanagment.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import eu.lengarski.usermanagment.users.entity.UserEntity;

/**
 * Created by Georgi Lengarski on  Monday 16/08/2021   07:40
 */
public interface UserRepository
        extends JpaRepository<UserEntity, Long>
{
    Optional<UserEntity> getUserByEmail(String email);

    public List<UserEntity> findAll();

}
