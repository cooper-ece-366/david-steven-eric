package edu.cooper.ece366.project.coopercars.server;

import edu.cooper.ece366.project.coopercars.server.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    //Optional<Vehicle> findByVIN(String VIN);
    // Optional<User> findById(Long id);
    //static Boolean existsByEmail(String email);
}

