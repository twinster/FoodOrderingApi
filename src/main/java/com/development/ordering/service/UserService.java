package com.development.ordering.service;

import com.development.ordering.OrderingApplication;
import com.development.ordering.model.User;
import com.development.ordering.model.UserDto;
import com.development.ordering.repository.UserRepository;
import com.development.ordering.repository.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRoleRepository userRoleRepository;

    @Autowired
    private ModelMapper modelMapper;

    //admin services

    @Autowired
    public UserService(UserRepository userRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder,
                       UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRoleRepository = userRoleRepository;
    }

    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);

        return users;
    }

    public User getUserById(Long id) {
        return userRepository.findUserById(id);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public void delete(long id) {
        userRepository.removeById(id);
    }

    public User findById(Long id) {
        return userRepository.findUserById(id);
    }

    public User userCreate(User user) throws Exception {
        user.setPassword(bCryptPasswordEncoder.encode("123qwe"));
        if (user.getUserRole() == null){
            user.setUserRole(userRoleRepository.findByName("USER"));
        }
        try{
            return userRepository.save(user);
        }
        catch (Exception e){
            throw e;
        }
    }

    //user services
    public User userSave(User user) throws Exception {
        try{
            return userRepository.save(user);
        }
        catch (Exception e){
            throw e;
        }
    }

    public UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public User convertToEntity(UserDto userDto) throws Exception {
        User user = modelMapper.map(userDto, User.class);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (userDto.getId() != null) {
            User oldUser = getUserById(userDto.getId());
            user.setPassword(oldUser.getPassword());
            user.setId(oldUser.getId());
            if (user.getUserRole() == null){
                user.setUserRole(oldUser.getUserRole());
            }

            if (user.getUserRole() != null && auth.getAuthorities().toArray()[0] != "ADMIN"){
                throw new Exception("You have no permission, good bye :))");
            }
        }
        return user;
    }
}
