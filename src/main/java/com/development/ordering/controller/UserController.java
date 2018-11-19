package com.development.ordering.controller;


import com.development.ordering.model.User;
import com.development.ordering.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    private UserDetailServiceImpl userDetailServiceImpl;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List listUser(){
        return userDetailServiceImpl.findAll();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id") Long id){
        return userDetailServiceImpl.findById(id);
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user){
        return userDetailServiceImpl.save(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/user/{id}", method = RequestMethod.DELETE)
    public boolean deleteUser(@PathVariable(value = "id") Long id){
        try {
            userDetailServiceImpl.delete(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

}