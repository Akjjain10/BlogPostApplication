package com.upgrad.BlogPostApplication.service;

import com.upgrad.BlogPostApplication.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //Contain all the business logic and communicate to db
    public boolean login(User user){
        if(user.getUsername().equals("akjjain10")&&user.getPassword().equals("akshit123"))
            return true;
        else
            return false;
    }
}
