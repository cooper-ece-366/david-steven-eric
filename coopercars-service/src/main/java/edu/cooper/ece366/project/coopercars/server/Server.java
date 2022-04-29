package edu.cooper.ece366.project.coopercars.server;


import edu.cooper.ece366.project.coopercars.server.model.VehicleAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Server {
    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) {
        logger.info("Example log from {}", Server.class.getSimpleName());
        System.out.println("The Server says hi!");

        try {

            VehicleAPI vehicle = new VehicleAPI("JTMRWRFV7LJ048851","For sale","10000","10000", "16000");
//            String theVIN = vehicle.getVIN();
//            String make = vehicle.getMake();
//            String model = vehicle.getModel();
            System.out.println(vehicle);




        }
        catch (IOException ex) {
            System.out.println("Unable to communicate to Yahoo Finance.");
        }
    }
}
