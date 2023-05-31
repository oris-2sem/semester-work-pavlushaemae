package com.example.dragi.services;

import com.example.dragi.models.User;

import java.security.Principal;
import java.util.List;
import java.util.Map;

public interface UserService {
    void setSeller(User user);
    boolean createUser(User user);
    List<User> list();

    void banUser(Long id);

    void changeUserRoles(User user, Map<String, String> form);

    User getUserByPrincipal(Principal principal);
}
