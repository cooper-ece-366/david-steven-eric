package edu.cooper.ece366.project.coopercars.server.controller;

//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import edu.cooper.ece366.project.coopercars.server.exception.BadRequestException;
import edu.cooper.ece366.project.coopercars.server.payload.AuthResponse;
import edu.cooper.ece366.project.coopercars.server.payload.LoginRequest;
import edu.cooper.ece366.project.coopercars.server.model.User;
import edu.cooper.ece366.project.coopercars.server.payload.SignUpRequest;
import edu.cooper.ece366.project.coopercars.server.repository.UserRepository;
import edu.cooper.ece366.project.coopercars.server.security.TokenProvider;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;


@RestController
@RequestMapping(value="/auth")
public class AuthController {

    @Autowired
    public AuthenticationManager authenticationManager;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping(value="/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);
        return ResponseEntity.ok(new AuthResponse(token));
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

        user.setPassword(passwordEncoder.encode(user.getPassword()));


        User result = userRepository.save(user);
    }

}
