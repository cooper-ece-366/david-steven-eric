package edu.cooper.ece366.project.coopercars.server.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.cooper.ece366.project.coopercars.server.model.User;
import edu.cooper.ece366.project.coopercars.server.model.VehicleAPI;
import edu.cooper.ece366.project.coopercars.server.model.Vehicle;
import edu.cooper.ece366.project.coopercars.server.payload.AddVehicleRequest;
import edu.cooper.ece366.project.coopercars.server.payload.SignUpRequest;
import edu.cooper.ece366.project.coopercars.server.repository.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;
@Transactional
@RestController
@RequestMapping(value = "/api")
public class ControllerApi
{
    @Autowired
    private VehicleRepository vehicleRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerApi.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping(path = "/vehicle/getinfo/{vin}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Vehicle getVehicleInfo(@PathVariable final String vin)
    {
        return vehicleRepository.findByVIN(vin);
    }

    @DeleteMapping(path = "/vehicle/remove/{vin}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeVehicle(@PathVariable final String vin)
    {
        vehicleRepository.deleteById(vin);
    }

    @DeleteMapping(path = "/vehicle/remove/status/{theStat}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeVehicleSold(@PathVariable final String theStat)
    {
        vehicleRepository.deleteByStatus(theStat);
    }

    @PostMapping(value ="/vehicle/addvehicle", produces = MediaType.APPLICATION_JSON_VALUE)
    public String addVehicle(@RequestBody AddVehicleRequest addVehicleRequest) throws IOException {
        try {
            VehicleAPI myVehicleAPI = new VehicleAPI(addVehicleRequest.getVIN(), addVehicleRequest.getStatus(), addVehicleRequest.getDealerPrice(),addVehicleRequest.getSalePrice() );
            Vehicle theVehicle = vehicleRepository.save(myVehicleAPI.getTheVehicle());
            LOGGER.debug(myVehicleAPI.getTheVehicle().toString());
            String theVehicleJSON = objectMapper.writeValueAsString(myVehicleAPI.getTheVehicle());
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
