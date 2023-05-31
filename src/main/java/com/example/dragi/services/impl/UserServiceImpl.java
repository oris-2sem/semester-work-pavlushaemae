package com.example.dragi.services.impl;

import com.example.dragi.models.User;
import com.example.dragi.models.enums.Role;
import com.example.dragi.repositories.UserRepository;
import com.example.dragi.services.UserService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void setSeller(User user) {
        Set<Role> roles = user.getRoles();
        roles.add(Role.ROLE_SELLER);
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public boolean createUser(User user) {
        String email = user.getEmail();
        if (!validateEmail(email)) return false;
        if (userRepository.findByEmail(email) != null) return false;
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        log.info("Saving new User with email: {}", email);
        userRepository.save(user);
        return true;
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public void banUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setActive(!user.isActive());
            log.info("Ban/nUnblock user with id = {}; email: {}", user.getId(), user.getEmail());
            userRepository.save(user);
        }
    }

    @Override
    public void changeUserRoles(User user, Map<String, String> form) {
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key: form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepository.save(user);
    }

    private boolean validateEmail(String email) {
        String url = "https://api.usebouncer.com/v1.1/email/verify?email=" + email;
        Pair<String, String> auth = Pair.of("x-api-key", "c6Nt9LwRTxHYoQDLciUpAOsV3IqbUZ6McL0Btcu5");
        try {
            HttpURLConnection connection =(HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty(auth.getFirst(), auth.getSecond());
            if (connection.getResponseCode() != 200) {
                return false;
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            JsonObject jsonObject = JsonParser.parseString(Objects.requireNonNull(response.toString())).getAsJsonObject();
            return jsonObject.get("status").getAsString().equals("deliverable");
        } catch (IOException e) {
            return false;
        }
    }
}
