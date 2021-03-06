package edu.cooper.ece366.project.coopercars.server.repository;

import edu.cooper.ece366.project.coopercars.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//Steven
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByNameAndEmail(String name, String email);
    // Optional<User> findById(Long id);
    //static Boolean existsByEmail(String email);
}
