package edu.cooper.ece366.project.coopercars.server.repository;

import edu.cooper.ece366.project.coopercars.server.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    //Optional<Vehicle> findByVIN(String VIN);
    // Optional<User> findById(Long id);
    //static Boolean existsByEmail(String email);
}

