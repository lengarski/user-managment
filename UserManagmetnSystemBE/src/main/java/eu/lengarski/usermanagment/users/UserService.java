package eu.lengarski.usermanagment.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import eu.lengarski.usermanagment.users.dto.UserDto;
import eu.lengarski.usermanagment.users.entity.UserEntity;

/**
 * Created by Georgi Lengarski on  Monday 16/08/2021   07:38
 */
@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public UserDto getUserByEmail(String email)
    {
        validate(email);

        Optional<UserEntity> userEntity = userRepository.getUserByEmail(email);
        if (!userEntity.isPresent())
        {
            throw new RuntimeException("User with mail " + email + " not exists");
        }
        return convertEntityToDto(userEntity.get());
    }

    public List<UserDto> getAllUsers()
    {
        List<UserEntity> allUserEntities = userRepository.findAll();
        return allUserEntities.stream().map(this :: convertEntityToDto).collect(Collectors.toList());
    }

    public void addNewUser(UserDto userDto)
    {
        validate(userDto);

        Optional<UserEntity> userEntity = userRepository.getUserByEmail(userDto.getEmail());
        if (userEntity.isPresent())
        {
            throw new RuntimeException("User with this mail address exists.");
        }

        UserEntity user = convertDtoToEntity(userDto);
        userRepository.save(user);
    }


    public void updateUser(UserDto userDto, String email)
    {
        validate(email);
        validate(userDto);

        Optional<UserEntity> userEntity = userRepository.getUserByEmail(email);
        if (!userEntity.isPresent())
        {
            throw new RuntimeException("User with mail " + email + " not exists");
        }

        UserEntity user = userEntity.get();
        user.setLastName(userDto.getLastName());
        user.setFirstName(userDto.getFirstName());
        user.setDateOfBirth(userDto.getDateOfBirth());

        userRepository.save(user);
    }


    private UserDto convertEntityToDto(UserEntity userEntity)
    {
        UserDto user = new UserDto();
        user.setDateOfBirth(userEntity.getDateOfBirth());
        user.setEmail(userEntity.getEmail());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        return user;
    }

    private UserEntity convertDtoToEntity(UserDto userDto)
    {
        UserEntity user = new UserEntity();

        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());

        return user;
    }

    public void deleteUser(String email)
    {
        Optional<UserEntity> userEntity = userRepository.getUserByEmail(email);
        if (!userEntity.isPresent())
        {
            throw new RuntimeException("User with mail " + email + " not exists");
        }
        userRepository.delete(userEntity.get());
    }

    private void validate(UserDto userDto)
    {
        if (userDto == null)
        {
            throw new RuntimeException("Not valid request object");
        }
    }

    private void validate(String email)
    {
        if (null == email || email.isEmpty())
        {
            throw new RuntimeException("Not valid mail!");
        }
    }

}
