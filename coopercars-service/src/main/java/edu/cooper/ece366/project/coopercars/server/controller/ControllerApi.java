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
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

//ControllerAPI Edited by Eric

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
            VehicleAPI myVehicleAPI = new VehicleAPI(addVehicleRequest.getVIN(), addVehicleRequest.getStatus(), addVehicleRequest.getDealerPrice(),addVehicleRequest.getSalePrice(), addVehicleRequest.getMileage());
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
        return vehicleRepository.findAll();
    }

    // desc meaning high to low

    @GetMapping(path = "/vehicles/sort/mileage-asc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortByMileageAsc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.ASC, "mileage"));
    }

    @GetMapping(path = "/vehicles/sort/mileage-desc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortByMileageDesc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.DESC, "mileage"));
    }

    // sale price, dealer price, profit, date, year, engine power, hp

    @GetMapping(path = "/vehicles/sort/sale-asc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortSalePriceAsc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.ASC, "salePrice"));
    }

    @GetMapping(path = "/vehicles/sort/sale-desc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortSalePriceDesc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.DESC, "salePrice"));
    }

    @GetMapping(path = "/vehicles/sort/dealer-asc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortDealerPriceAsc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.ASC, "dealerPrice"));
    }

    @GetMapping(path = "/vehicles/sort/dealer-desc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortDealerPriceDesc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.DESC, "dealerPrice"));
    }

    @GetMapping(path = "/vehicles/sort/profit-asc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortProfitAsc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.ASC, "profit"));
    }

    @GetMapping(path = "/vehicles/sort/profit-desc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortProfitDesc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.DESC, "profit"));
    }

    @GetMapping(path = "/vehicles/sort/date-asc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortDateAsc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.ASC, "enteredDate"));
    }

    @GetMapping(path = "/vehicles/sort/date-desc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortDateDesc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.DESC, "enteredDate"));
    }

    @GetMapping(path = "/vehicles/sort/year-asc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortYearAsc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.ASC, "year"));
    }

    @GetMapping(path = "/vehicles/sort/year-desc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortYearDesc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.DESC, "year"));
    }

    @GetMapping(path = "/vehicles/sort/enginepower-asc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortEnginePowerAsc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.ASC, "enginePowerkW"));
    }

    @GetMapping(path = "/vehicles/sort/enginepower-desc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortEnginePowerDesc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.DESC, "enginePowerkW"));
    }

    @GetMapping(path = "/vehicles/sort/horsepower-asc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortHPAsc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.ASC, "horsepower"));
    }

    @GetMapping(path = "/vehicles/sort/horsepower-desc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortHPDesc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.DESC, "horsepower"));
    }

    @GetMapping(path = "/vehicles/sort/displacementCC-asc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortDisCCAsc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.ASC, "displacementCC"));
    }

    @GetMapping(path = "/vehicles/sort/displacementCC-desc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortDisCCDesc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.DESC, "displacementCC"));
    }

    @GetMapping(path = "/vehicles/sort/make-asc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortMakeAsc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.ASC, "make"));
    }

    @GetMapping(path = "/vehicles/sort/make-desc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortMakeDesc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.DESC, "make"));
    }

    @GetMapping(path = "/vehicles/sort/model-asc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortModelAsc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.ASC, "model"));
    }

    @GetMapping(path = "/vehicles/sort/model-desc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortModelDesc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.DESC, "model"));
    }

    @GetMapping(path = "/vehicles/sort/displacementcc-asc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortDisplacementCCAsc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.ASC, "displacementCC"));
    }

    @GetMapping(path = "/vehicles/sort/displacementcc-desc", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<Vehicle> sortModelDisplacementCCDesc() {
        return vehicleRepository.findAll(Sort.by(Sort.Direction.DESC, "displacementCC"));
    }

}
