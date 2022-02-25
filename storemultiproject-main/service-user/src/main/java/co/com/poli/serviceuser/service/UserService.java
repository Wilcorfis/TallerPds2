package co.com.poli.serviceuser.service;

import co.com.poli.serviceuser.entities.User;

import java.util.List;

public interface UserService {

    void save(User user);
    void delete(User user);
    List<User> findAll();
    User findById(Long id);
    User findByName(String numberID);

}
