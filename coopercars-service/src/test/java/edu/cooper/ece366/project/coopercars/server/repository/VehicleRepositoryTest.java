package edu.cooper.ece366.project.coopercars.server.repository;
import edu.cooper.ece366.project.coopercars.server.model.Vehicle;
import edu.cooper.ece366.project.coopercars.server.model.VehicleAPI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@RestController
public class VehicleRepositoryTest {
    @Autowired
    private VehicleRepository vehicleRepository;

    Vehicle vehicle = new Vehicle();

    @BeforeEach
    void init(){
        vehicle.setStatus("someStatus");
        vehicle.setVIN("123456");
        vehicle.setBackupCam("Test BackupCam");
        vehicle.setDealerPrice(30000.0);
        vehicle.setSalePrice(30000.0);
        vehicle.setMileage(8000.0);
        /*
        try {
            VehicleAPI myVehicleAPI = new VehicleAPI(vehicle.getVIN(), vehicle.getStatus(), Double.toString(vehicle.getDealerPrice()), Double.toString(vehicle.getSalePrice()), Double.toString(vehicle.getMileage()));
            Vehicle theVehicle = vehicleRepository.save(myVehicleAPI.getTheVehicle());
        }
        catch (IOException ex) {
            System.out.println("Unable to communicate to Vehicle API.");
        }*/
    }

    @Test
    void CheckByVIN() {
        System.out.println("Checking User By Name and Email...");
        vehicleRepository.save(vehicle);
        assertNotNull(vehicleRepository.findByVIN("123456"));
    }
}