package edu.cooper.ece366.project.coopercars.server.repository;

import edu.cooper.ece366.project.coopercars.server.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;


@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    Vehicle findByVIN(String VIN);
    void deleteById(String VIN);
    void deleteByStatus(String myStatus);

}

