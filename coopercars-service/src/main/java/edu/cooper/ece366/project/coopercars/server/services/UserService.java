package edu.cooper.ece366.project.coopercars.server.services;

import edu.cooper.ece366.project.coopercars.server.RestApiServer;
import edu.cooper.ece366.project.coopercars.server.model.User;
import edu.cooper.ece366.project.coopercars.server.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional

//Steven
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public List<User> listAllUser() {
        List<User> listOfAllUsers = userRepository.findAll();
        LOGGER.info(String.format("all users = %s", listOfAllUsers.toString()));
        return listOfAllUsers;
    }

}