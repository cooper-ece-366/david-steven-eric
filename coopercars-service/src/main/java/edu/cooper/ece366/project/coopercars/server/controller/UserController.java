package edu.cooper.ece366.project.coopercars.server.controller;

import edu.cooper.ece366.project.coopercars.server.exception.ResourceNotFoundException;
import edu.cooper.ece366.project.coopercars.server.model.User;
import edu.cooper.ece366.project.coopercars.server.repository.UserRepository;
import edu.cooper.ece366.project.coopercars.server.security.CurrentUser;
import edu.cooper.ece366.project.coopercars.server.security.UserPrincipal;
import edu.cooper.ece366.project.coopercars.server.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//UserControlled edited by Steven
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    private UserService userService;

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        LOGGER.info(String.format("userPrincipal = %s", userPrincipal.toString()));
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
