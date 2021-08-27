package com.bm.bank.repos;

import java.util.Optional;

import com.bm.bank.models.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//User Repo Interface
@Repository
public interface UserDAO extends CrudRepository<User, Long> {
    public Optional<User> findById(Long userId);
    public User save(User user);
    public void delete(User user);
}
