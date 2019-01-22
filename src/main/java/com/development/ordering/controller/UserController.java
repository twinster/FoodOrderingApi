package com.development.ordering.controller;

import com.development.ordering.model.User;
import com.development.ordering.model.UserDto;
import com.development.ordering.service.UserDetailServiceImpl;
import com.development.ordering.service.UserService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public User saveUser(@RequestBody UserDto userDto, @PathVariable(value = "id") Long id) throws Exception{
        User user = userService.convertToEntity(userDto);
        return userService.userSave(user);
    }
}