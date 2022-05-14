
package edu.cooper.ece366.project.coopercars.server.model;

import edu.cooper.ece366.project.coopercars.server.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user = new User();

    @Test
    void Id() {
        user.setId((long)20);
        System.out.println("check ID");
        assertEquals(20, user.getId());
    }

    @Test
    void Name() {
        user.setName("someName");
        System.out.println("check name");
        assertEquals("someName", user.getName());
    }

    @Test
    void Email() {
        user.setEmail("test email");
        System.out.println("Check email");
        assertEquals("test email", user.getEmail());
    }


    @Test
    void Password() {
        user.setPassword("test");
        System.out.println("check password");
        assertEquals("test", user.getPassword());
    }

    @Test
    void ImageUrl() {
        user.setImageUrl("test");
        System.out.println("check imageurl");
        assertEquals("test", user.getImageUrl());
    }

    @Test
    void EmailVerified() {
        user.setEmailVerified(true);
        System.out.println("checking email verified");
        assertEquals(true, user.getEmailVerified());
    }

    @Test
    void ProviderId() {
        user.setProviderId("YO");
        System.out.println("checking email verified");
        assertEquals("YO", user.getProviderId());
    }



}