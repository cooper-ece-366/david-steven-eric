package edu.cooper.ece366.project.coopercars.server.repository;
import edu.cooper.ece366.project.coopercars.server.model.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    User user = new User();

    @BeforeEach
    void init(){
        user.setName("Steven");
        user.setPassword("somePassword");
        user.setEmail("test@cooper.edu");
    }

//    @Test
//    void NameAndEmailCheck() {
//        System.out.println("Checking User By Name and Email...");
//        assertNotNull(userRepository.findByEmail("cho15@cooper.edu"));
//    }


}
