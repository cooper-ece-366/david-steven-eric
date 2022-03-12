import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.net.URL;

/*
From VIN, put into a database info about the vehicle. Prompt user continuously to add VIN.
 */
public class VehiclesDataBuilder
{
    public static void main (String[] args) throws Exception
    {
        List<String[]> initialRow = new ArrayList<String[]>();

        //        String[] populateInitialRow = {"VIN", "Anti-lock Braking", "Electronic Stability", "Traction Control",
        //        "Keyless Ignition", "Automatic Crash Notification", "Backup Camera", "Parking Assist", "Rear Cross Traffic Alert",
        //        "Rear Automatic Emerg Braking", "Crash Imminent Braking", "Forward Collision Warn", "Dynamic Brake Support",
        //        "Pedestrian Emergency Braking", "Blind Spot Warn", "Lane Departure Warn", "Lane Keep Assist",
        //        "Blind Spot Intervention", "Lane Center Assist", "Daytime Run Lights", "Headlamp Light Source",
        //        "Headlamp Mean Switch", "Adaptive Driving Beam", "Adaptive Cruise Control", "Num of Cylinders",
        //        "Displacement (CC)", "Displacement (CI)", "Displacement (L)", "Engine Power (kW)", "Fuel Type Primary",
        //        "Fuel Type Secondary", "Fuel Injection Type", "Engine Configuration", "Horsepower",
        //        "Electrification Level", "Other Engine Info", "Turbo", "Top speed (MPH)", "Engine Manufacturer",
        //        "Body Class", "Num Doors", "Num Windows", "Wheel Base Type", "Bed Length", "Curb Weight", "Wheel base",
        //        "Gross Combined Weight", "Truck Bed Type", "Truck Cab Type", "Num Wheels", "Wheel Size Front",
        //        "Wheel size Rear", "Make", "Model", "Year", "Series", "Trim", "Vehicle Type", "Plant Country",
        //        "Base Price", "Entertainment System", "Number of Seats", "Number of Seat Rows", "Drive Type", "Axles", "Transmission Style"};
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
        initialRow.add(populateInitialRow);


        Writer theWriter = new FileWriter("vehiclesDatabase.csv");
        for (String[] data : initialRow) {
            theWriter.write(String.join(",", data));
        }
        theWriter.write("\n");

        boolean run = true;
        while(run) {
            Scanner readInput = new Scanner(System.in);
            System.out.println("Enter a VIN number: ");

            // add a try catch
            String theVIN = readInput.nextLine();
            if (theVIN.equals("stop"))
                run = false;
            String theURL = "https://vpic.nhtsa.dot.gov/decoder/Decoder/ExportToExcel?VIN=" + theVIN;

            BufferedReader in = null;
            try {
                URL url = new URL(theURL);
                in = new BufferedReader(new InputStreamReader(url.openStream()));

            } catch (Exception e) {
                System.out.println("An error occured!");
            }
            //int lineCtr = 0;
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
        }
        theWriter.close();
    }
}
