package io.reflectoring.spring_boot_simple.service;

import io.reflectoring.spring_boot_simple.entity.User;
import io.reflectoring.spring_boot_simple.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepositoty;
public List<User> getAllUser() {
    return this.userRepositoty.findAll();
}

}
