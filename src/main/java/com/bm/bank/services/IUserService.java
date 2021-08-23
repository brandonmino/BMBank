package com.bm.bank.services;

import com.bm.bank.models.User;

//User Service Interface
public interface IUserService {
    User findById(Long id);
    User createNewUser(User user);
    void delete(Long id);
}
