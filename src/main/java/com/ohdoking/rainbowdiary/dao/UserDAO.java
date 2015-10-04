package com.ohdoking.rainbowdiary.dao;

import java.util.List;

import com.ohdoking.rainbowdiary.model.User;

public interface UserDAO {
 
    public void addPerson(User p);
    public User checkPersonByUserId(String userId);
    
}