package edu.cooper.ece366.project.coopercars.server.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleTest {
    Vehicle vehicle;
    private String VIN;
    private double dealerPrice;
    private double salePrice;
    private double profit;
    private double mileage;
    private String status;
    private String imgURL;
    private String enteredDate;

    @BeforeEach
    void createVehicle(){
        vehicle = new Vehicle();
    }

    @Test
    void Vin() {
        vehicle.setVIN("vin");
        System.out.println("check VIN");
        assertEquals("vin", vehicle.getVIN());
    }

    @Test
    void DealerPrice() {
        vehicle.setDealerPrice(100);
        System.out.println("check dealer price");
        assertEquals(100, vehicle.getDealerPrice());
    }

    @Test
    void SalePrice() {
        vehicle.setSalePrice(500);
        System.out.println("Check sale price");
        assertEquals(500, vehicle.getSalePrice());
    }


    @Test
    void Profit() {
        vehicle.setProfit(500);
        System.out.println("check profit");
        assertEquals(500, vehicle.getProfit());
    }

    @Test
    void ImageUrl() {
        vehicle.setImgURL("test");
        System.out.println("check imageurl");
        assertEquals("test", vehicle.getImgURL());
    }

    @Test
    void Mileage() {
        vehicle.setMileage(1000);
        System.out.println("checking email verified");
        assertEquals(1000, vehicle.getMileage());
    }

    @Test
    void Status() {
        vehicle.setStatus("YO");
        System.out.println("checking email verified");
        assertEquals("YO", vehicle.getStatus());
    }

    @Test
    void EnteredDate() {
        vehicle.setEnteredDate("YO");
        System.out.println("checking email verified");
        assertEquals("YO", vehicle.getEnteredDate());
    }

    @AfterEach
    void deleteUser(){
        vehicle = null;
    }
}
