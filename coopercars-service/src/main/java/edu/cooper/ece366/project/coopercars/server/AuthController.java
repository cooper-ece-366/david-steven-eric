package edu.cooper.ece366.project.coopercars.server;

//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
@RequestMapping(value="/auth")
public class AuthController {

//    @Autowired
//    public AuthenticationManager authenticationManager;

    @PostMapping(value="/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> authenticateUser(@RequestBody LoginRequest loginRequest) {

//        Neo4jProperties.Authentication authentication = (Neo4jProperties.Authentication) authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginRequest.getEmail(),
//                        loginRequest.getPassword()
//                )
//        );

//        SecurityContextHolder.getContext().setAuthentication((Authentication) authentication);

//        String token = tokenProvider.createToken(authentication);
//        HttpHeaders responseHeaders = new HttpHeaders();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");
        return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
    }

}
