package edu.cooper.ece366.project.coopercars.server.controller;

//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import edu.cooper.ece366.project.coopercars.server.payload.LoginRequest;
import edu.cooper.ece366.project.coopercars.server.model.User;
import edu.cooper.ece366.project.coopercars.server.payload.SignUpRequest;
import edu.cooper.ece366.project.coopercars.server.repository.UserRepository;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;


@RestController
@RequestMapping(value="/auth")
public class AuthController {

//    @Autowired
//    public AuthenticationManager authenticationManager;


    @Autowired
    private UserRepository userRepository;


    @PostMapping(value="/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

//        Neo4jProperties.Authentication authentication = (Neo4jProperties.Authentication) authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginRequest.getEmail(),
//                        loginRequest.getPassword()
//                )
//        );
//
//        SecurityContextHolder.getContext().setAuthentication((Authentication) authentication);

        return ResponseEntity.ok("Hello");
    }

    @PostMapping(value ="/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public void registerUser(@RequestBody SignUpRequest signUpRequest) {
//        if(UserRepository.existsByEmail(signUpRequest.getEmail())) {
//            throw new BadRequestException("Email address already in use.");
//        }

        // Creating user's account
        User user = new User();
        user.setName(signUpRequest.getFirstName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());


        User result = userRepository.save(user);
    }

}
