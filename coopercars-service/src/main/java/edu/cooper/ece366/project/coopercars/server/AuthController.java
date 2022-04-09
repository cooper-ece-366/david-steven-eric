package edu.cooper.ece366.project.coopercars.server;


import edu.cooper.ece366.project.coopercars.server.model.User;
import edu.cooper.ece366.project.coopercars.server.payload.SignUpRequest;
import edu.cooper.ece366.project.coopercars.server.repository.UserRepository;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.security.crypto.password.PasswordEncoder;



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
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());


        User result = userRepository.save(user);
    }

}
