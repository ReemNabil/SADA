/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author medox
 */
@RestController
@RequestMapping("/user")
public class UserRestController {
    
    @Autowired
    UserRepository userRepository;
    
    @RequestMapping(value = "/addNewUser",method = RequestMethod.POST)
    public void addNewUser(@RequestBody UserModel model){
        userRepository.save(model);
    }    
      @RequestMapping(value = "/getAllUsers",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody List<UserModel> getAllUsers(){
        return userRepository.findAll();
    }
    
      @RequestMapping(value = "/getUser/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Optional<UserModel> getUser(@PathVariable Long id){
      
        return userRepository.findById(id);
    }
    
}
