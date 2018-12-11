package com.development.ordering.service;

import com.development.ordering.model.User;
import com.development.ordering.repository.UserRepository;
import com.development.ordering.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.UniqueConstraint;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRoleRepository userRoleRepository;

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

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
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

    public User save(User user) throws Exception {
        String password = user.getPassword();
        if (user.getPassword() != null){
            user.setPassword(bCryptPasswordEncoder.encode(password));
        }

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
}
