package com.upgrad.BlogPostApplication.controller;

import com.upgrad.BlogPostApplication.model.Post;
import com.upgrad.BlogPostApplication.model.User;
import com.upgrad.BlogPostApplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class UserController {

    private UserService userService=new UserService();

    //GET Request to "/users/login"
    @RequestMapping(method = RequestMethod.GET,value = "/users/login")
    public String login(Model model){
        model.addAttribute("user",new User());
        return "users/login";
    }

    //POST Request to "/users/login"
    @RequestMapping(method = RequestMethod.POST,value = "/users/login")
    public String loginUser(User user){
        //check if credentials match
        if(userService.login(user)){
            return "redirect:/posts";
        }else{
            return "/users/login";
        }
    }

    //AGENDA 3:- Create the user Registration
    //Registration:- "/users/registration"
    //Logout :- "/users/logout"

    @RequestMapping(method =RequestMethod.GET,value = "/users/registration")
    public String registration(){
        return "users/registration";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/users/registration")
    public String userRegistration(User user){
        //Business logic to save the creds. of the user to the given database

        return "redirect:/users/login";
    }

    @RequestMapping(value = "/users/logout")
    public String userLogout(){
        return "redirect:/";
    }
}
