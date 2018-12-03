package com.development.ordering.config;

import com.development.ordering.model.User;
import com.development.ordering.model.UserRole;
import com.development.ordering.service.UserRoleService;
import com.development.ordering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class InitData {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public InitData(){

    }

    @Bean
    public boolean insertTestData(){
        try{
            userRoleService.addOrUpdateUserRole(new UserRole("ADMIN"));
            userRoleService.addOrUpdateUserRole(new UserRole("USER"));
            userService.save(new User("admin", "admin", "admin@gmail.com", "11211", "admin", "admin", userRoleService.getUserRoleByName("ADMIN")));
            userService.save(new User("user", "user", "user@gmail.com", "11211", "user","admin", userRoleService.getUserRoleByName("USER")));
            return true;
        }
        catch (Exception e){
            System.out.println("error while inserting data " + e.toString());
            return false;
        }
    }
}
