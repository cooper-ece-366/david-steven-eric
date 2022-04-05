package edu.cooper.ece366.project.coopercars.server;

import java.io.*;
import java.util.*;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;


// VehicleAPI take in a VIN number and returns a Vehicle object
public class VehicleAPIDataBuilder {
//    static final String DB_URL = "jdbc:mysql://localhost:3306/coopercars-vehicles";
//    static final String USER = "root";
//    static final String PASS = "mysql";

    //, double theDealerPrice, double theSalePrice
    public VehicleAPIDataBuilder(String myVIN) throws IOException {
        String theVIN = myVIN;

        String theURL = "https://vpic.nhtsa.dot.gov/decoder/Decoder/ExportToExcel?VIN=" + theVIN;
        String[] populateInitialRow = {"VIN", "Anti-lock Braking System (ABS)", "Electronic Stability Control (ESC)", "Traction Control",
                "Keyless Ignition", "Automatic Crash Notification (ACN) / Advanced Automatic Crash Notification (AACN)",
                "Backup Camera", "Parking Assist", "Rear Cross Traffic Alert", "Rear Automatic Emergency Braking", "Crash Imminent Braking (CIB)",
                "Forward Collision Warning (FCW)", "Dynamic Brake Support (DBS)", "Pedestrian Automatic Emergency Braking (PAEB)",
                "Blind Spot Warning (BSW)", "Lane Departure Warning (LDW)", "Lane Keeping Assistance (LKA)",
                "Blind Spot Intervention (BSI)", "Lane Centering Assistance", "Daytime Running Light (DRL)", "Headlamp Light Source",
                "Semiautomatic Headlamp Beam Switching", "Adaptive Driving Beam (ADB)", "Adaptive Cruise Control (ACC)", "Engine Number of Cylinders",
                "Displacement (CC)", "Displacement (CI)", "Displacement (L)", "Engine Power (kW)", "Fuel Type - Primary", "Engine Configuration",
                "Fuel Type - Secondary", "Fuel Delivery / Fuel Injection Type", "Engine Brake (hp) From",
                "Electrification Level", "Other Engine Info", "Turbo", "Top Speed (MPH)", "Engine Manufacturer",
                "Body Class", "Doors", "Windows", "Wheel Base Type", "Bed Length (inches)", "Curb Weight (pounds)", "Wheel Base (inches) From",
                "Gross Combination Weight Rating From", "Bed Type", "Cab Type", "Number of Wheels", "Wheel Size Front (inches)",
                "Wheel Size Rear (inches)", "Make", "Model", "Model Year", "Series", "Trim", "Vehicle Type", "Plant Country",
                "Base Price ($)", "Entertainment System", "Number of Seats", "Number of Seat Rows", "Drive Type", "Axles", "Transmission Style"};
        List<String[]> initialRow = new ArrayList<String[]>();
        initialRow.add(populateInitialRow);
        boolean writeInitialLineBool = false;
        try {
            File myFile = new File("vehiclesDatabase.csv");
            if (myFile.createNewFile()) {
                writeInitialLineBool = true;
            }
        } catch (IOException e) {

        }

        Writer theWriter = new FileWriter("vehiclesDatabase.csv", true);

        if (writeInitialLineBool) {
            for (String[] data : initialRow) {
                theWriter.write(String.join(",", data));
            }
            theWriter.write("\n");
        }

        BufferedReader in = null;
        try {
            URL url = new URL(theURL);
            in = new BufferedReader(new InputStreamReader(url.openStream()));

        } catch (Exception e) {
            System.out.println("An error occured!");
        }

        String currentLine = null;
        String[] vehicleData;

        List<String[]> vehicleRows = new ArrayList<String[]>();
        String[] populateVehicleRow = new String[66];
        populateVehicleRow[0] = theVIN;
        boolean populateVehicleRowBool = true;
        while ((currentLine = in.readLine()) != null) {
            //lineCtr++;
            vehicleData = currentLine.split(",", 3);
            if (vehicleData[1].equals("Error Code") && !(vehicleData[2].equals("0")))
            {
                System.out.println("INVALID VIN!");
                populateVehicleRowBool = false;
                break;
            }
            else
            {
                populateVehicleRowBool = true;
                for (int i = 1; i < populateVehicleRow.length; i++)
                {
                    if (vehicleData[1].equals(populateInitialRow[i]))
                        populateVehicleRow[i] = vehicleData[2];
                }
            }
        }

        if(populateVehicleRowBool)
        {
            vehicleRows.add(populateVehicleRow);
            for (String[] data : vehicleRows)
                theWriter.write(String.join(",", data));

            theWriter.write("\n");
        }

        theWriter.close();
    }
}