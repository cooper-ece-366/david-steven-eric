package edu.cooper.ece366.project.coopercars.server;

import java.util.ArrayList;
import java.util.List;

public class Vehicles
{
    // instance variables
    private List<Vehicle> vehicles;

    // constructor
    public Vehicles()
    {

        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle v)
    {
        vehicles.add(v);
    }

//    @Override
//    public String toString() {
//        String output = "";
//        for (Vehicle v : vehicles)
//            output += v.toString() + "\n";
//        return output;
//    }
    public List<Vehicle> getVehiclesList()
    {
        return vehicles;
    }

}
