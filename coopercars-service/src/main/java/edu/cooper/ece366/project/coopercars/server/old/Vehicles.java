package edu.cooper.ece366.project.coopercars.server.old;

import edu.cooper.ece366.project.coopercars.server.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

// NOTE: replaced by mySQL database; this is no longer needed.
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
