package edu.cooper.ece366.project.coopercars.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping(value = "/api")
public class ControllerApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerApi.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping(path = "/vehicle/{vin}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getVehicleInfo(@PathVariable final String vin) throws JsonProcessingException {
        try {
            VehicleAPI vehicle = new VehicleAPI(vin);
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
    public String getVehiclesInfo() throws JsonProcessingException {
        try {
            VehiclesAPI vehicles = new VehiclesAPI();
            LOGGER.debug(vehicles.getTheVehicles().toString());
            //ObjectMapper mapper = new ObjectMapper();
            //List<Vehicle> myVehicles = mapper.readValue(jsonInput, new TypeReference<List<Vehicle>>(){});

            String theVehiclesJSON = objectMapper.writeValueAsString(vehicles.getTheVehicles().getVehiclesList());
            LOGGER.debug(theVehiclesJSON);
            return(theVehiclesJSON);
        }
        catch (IOException ex) {
            System.out.println("Unable to communicate to Vehicles API.");
            return("ex.toString()");
        }
    }
}
