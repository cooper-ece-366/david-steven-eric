package edu.cooper.ece366.project.coopercars.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping(value = "/api")
public class ControllerApi {
    @Autowired
    private VehicleRepository vehicleRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerApi.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping(path = "/vehicle/{vin}/{dealerPrice}/{salePrice}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getVehicleInfo(@PathVariable final String vin, @PathVariable final String dealerPrice, @PathVariable final String salePrice) throws JsonProcessingException {
        try {
            VehicleAPI vehicle = new VehicleAPI(vin,dealerPrice,salePrice);
            Vehicle theVehicle = vehicleRepository.save(vehicle.getTheVehicle());
            LOGGER.debug(vehicle.getTheVehicle().toString());
            String theVehicleJSON = objectMapper.writeValueAsString(vehicle.getTheVehicle());
            LOGGER.debug(theVehicleJSON);
            return(theVehicleJSON);
        }
        catch (IOException ex) {
            System.out.println("Unable to communicate to Vehicle API.");
            return("ex.toString()");
        }
    }

    @GetMapping(path = "/vehicles", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> getAllVehicles() {
        // This returns a JSON or XML with the users
        return vehicleRepository.findAll();
    }
}
