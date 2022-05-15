package edu.cooper.ece366.project.coopercars.server.repository;
import edu.cooper.ece366.project.coopercars.server.model.Vehicle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
public class VehicleRepositoryTest {
    @Autowired
    private VehicleRepository vehicleRepository;

    Vehicle vehicle = new Vehicle();

    @BeforeEach
    void init(){
        vehicle.setStatus("someStatus");
        vehicle.setVIN("123456");
        vehicle.setBackupCam("Test BackupCam");
    }

    @Test
    void CheckByVIN() {
        System.out.println("Checking User By Name and Email...");
        assertNotNull(vehicleRepository.findByVIN("123456"));
    }
}
