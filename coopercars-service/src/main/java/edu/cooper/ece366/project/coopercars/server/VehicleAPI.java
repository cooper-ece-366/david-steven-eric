package edu.cooper.ece366.project.coopercars.server;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.net.URL;

// VehicleAPI takes in a VIN number and returns a Vehicle object. It also adds the vehicle to a csv database.
public class VehicleAPI
{
    private Vehicle theVehicle;

    public Vehicle getTheVehicle() {
        return theVehicle;
    }

    public void setTheVehicle(Vehicle theVehicle) {
        this.theVehicle = theVehicle;
    }

    public VehicleAPI(String myVIN, String dealerPrice, String salePrice) throws IOException {
        String theVIN = myVIN;
        String VIN;
        String imgURL;

        //general
        String make;
        String model;
        int year;
        String series;
        String trim;
        String vehicleType;
        String plantCountry;
        double basePrice;
        String entertainSys;
        int numOfSeats;
        int numOfSeatRows;

        //Active Safety systems
        String antiLockBraking;
        String electronicStability;
        String tractionControl;
        String keylessIgnition;
        String autoCrashNotif;
        String backupCam;
        String parkingAssist;
        String rearCrossTrafficAlert;
        String rearAutoEmergBraking;
        String crashImmBraking;
        String forwColliWarn;
        String dynamicBrakeSupp;
        String pedestrianAutoEmergBrak;
        String blindSpotWarn;
        String laneDepartWarn;
        String laneKeepAssist;
        String blindSpotIntervention;
        String laneCenterAssist;
        String daytimeRunLights;
        String headlampLightSrc;
        String headlampBeamSwitch;
        String adaptDrivingBeam;
        String adaptiveCruiseControl;

        // engine
        int numOfCylinders;
        double displacementCC;
        double displacementCI;
        double displacementL;
        double enginePowerkW;
        String fuelTypePrim;
        String fuelTypeSec;
        String fuelInjectionType;
        String engineConfig;
        double horsepower;
        String electricificationLevel;
        String otherEngineInfo;
        String turbo;
        int topSpeed;
        String engineManufact;

        // body
        String bodyClass;
        int numOfDoors;
        int numOfWindows;
        String wheelBaseType;

        // dimension
        double bedLength;
        double curbWeight;
        double wheelBase;
        double grossCombWeight;

        //truck
        String truckBedType;
        String truckCabType;

        //wheels
        int numOfWheels;
        int wheelSizeFrontIn;
        int wheelSizeRearIn;

        //drivetrain
        String driveType;
        int axles;
        String transmissionStyle;
        String theURL = "https://vpic.nhtsa.dot.gov/decoder/Decoder/ExportToExcel?VIN=" + theVIN;
        String[] populateInitialRow = {"VIN","Anti-lock Braking System (ABS)", "Electronic Stability Control (ESC)", "Traction Control",
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
                "Base Price ($)", "Entertainment System", "Number of Seats", "Number of Seat Rows", "Drive Type", "Axles", "Transmission Style", "Dealer Price", "Sale Price","Image URL"};

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

        //int lineCtr = 0;
        String currentLine = null;
        String[] vehicleData;

        List<String[]> vehicleRows = new ArrayList<String[]>();
        String[] populateVehicleRow = new String[69];
        // TODO: loop through database, if VIN exists, do not add
        populateVehicleRow[0] = theVIN;

        boolean populateVehicleRowBool = true;
        while ((currentLine = in.readLine()) != null) {
            vehicleData = currentLine.split(",", 3);
            if (vehicleData[1].equals("Error Code") && !(vehicleData[2].equals("0")))
            {
                System.out.println("INVALID VIN!");
                break;
            }
            else
            {
                for (int i = 1; i < populateVehicleRow.length; i++)
                {
                    if (vehicleData[1].equals(populateInitialRow[i]))
                        populateVehicleRow[i] = vehicleData[2];
                }
            }
        }
        populateVehicleRow[66] = dealerPrice;
        populateVehicleRow[67] = salePrice;
        populateVehicleRow[68] = "https://pictures.topspeed.com/IMG/crop/201609/smart-fortwo-nypd-ed-9_1600x0w.jpg";

        if(populateVehicleRowBool)
        {
            vehicleRows.add(populateVehicleRow);
            for (String[] data : vehicleRows)
                theWriter.write(String.join(",", data));

            theWriter.write("\n");
        }

        theWriter.close();

        VIN = populateVehicleRow[0];
        antiLockBraking = populateVehicleRow[1];
        electronicStability = populateVehicleRow[2];
        tractionControl = populateVehicleRow[3];
        keylessIgnition = populateVehicleRow[4];
        autoCrashNotif = populateVehicleRow[5];
        backupCam = populateVehicleRow[6];
        parkingAssist = populateVehicleRow[7];
        rearCrossTrafficAlert = populateVehicleRow[8];
        rearAutoEmergBraking = populateVehicleRow[9];
        crashImmBraking = populateVehicleRow[10];
        forwColliWarn = populateVehicleRow[11];
        dynamicBrakeSupp = populateVehicleRow[12];
        pedestrianAutoEmergBrak = populateVehicleRow[13];
        blindSpotWarn = populateVehicleRow[14];
        laneDepartWarn = populateVehicleRow[15];
        laneKeepAssist = populateVehicleRow[16];
        blindSpotIntervention = populateVehicleRow[17];
        laneCenterAssist = populateVehicleRow[18];
        daytimeRunLights = populateVehicleRow[19];
        headlampLightSrc = populateVehicleRow[20];
        headlampBeamSwitch = populateVehicleRow[21];
        adaptDrivingBeam = populateVehicleRow[22];
        adaptiveCruiseControl = populateVehicleRow[23];
        year = Integer.parseInt("0" + populateVehicleRow[54]);

        numOfCylinders = Integer.parseInt("0" + populateVehicleRow[24]);
        displacementCC = Double.parseDouble("0" + populateVehicleRow[25]);
        displacementCI = Double.parseDouble("0" + populateVehicleRow[26]);
        displacementL = Double.parseDouble("0" + populateVehicleRow[27]);
        enginePowerkW = Double.parseDouble("0" + populateVehicleRow[28]);
        horsepower = Double.parseDouble("0" + populateVehicleRow[33]);
        topSpeed = Integer.parseInt("0" + populateVehicleRow[37]);
        numOfDoors = Integer.parseInt("0" + populateVehicleRow[40]);
        numOfWindows = Integer.parseInt("0" + populateVehicleRow[41]);
        bedLength = Double.parseDouble("0" + populateVehicleRow[43]);
        curbWeight = Double.parseDouble("0" + populateVehicleRow[44]);
        wheelBase = Double.parseDouble("0" + populateVehicleRow[45]);
        grossCombWeight = Double.parseDouble("0" + populateVehicleRow[46]);
        numOfWheels = Integer.parseInt("0" + populateVehicleRow[49]);
        wheelSizeFrontIn = Integer.parseInt("0" + populateVehicleRow[50]);
        wheelSizeRearIn = Integer.parseInt("0" + populateVehicleRow[51]);

        basePrice = Double.parseDouble("0"+populateVehicleRow[59]);
        numOfSeats = Integer.parseInt("0" + populateVehicleRow[61]);
        numOfSeatRows = Integer.parseInt("0" + populateVehicleRow[62]);
        axles = Integer.parseInt("0" + populateVehicleRow[64]);

        Double theDealerPrice = Double.parseDouble("0"+populateVehicleRow[66]);
        Double theSalePrice = Double.parseDouble("0"+populateVehicleRow[67]);

        fuelTypePrim = populateVehicleRow[29];
        engineConfig = populateVehicleRow[30];
        fuelTypeSec = populateVehicleRow[31];
        fuelInjectionType = populateVehicleRow[32];
        electricificationLevel = populateVehicleRow[34];
        otherEngineInfo = populateVehicleRow[35];
        turbo = populateVehicleRow[36];
        engineManufact = populateVehicleRow[38];
        bodyClass = populateVehicleRow[39];
        wheelBaseType = populateVehicleRow[42];
        truckBedType = populateVehicleRow[47];
        truckCabType = populateVehicleRow[48];
        make = populateVehicleRow[52];
        model = populateVehicleRow[53];
        series = populateVehicleRow[55];
        trim = populateVehicleRow[56];
        vehicleType = populateVehicleRow[57];
        plantCountry = populateVehicleRow[58];
        entertainSys = populateVehicleRow[60];
        driveType = populateVehicleRow[63];
        transmissionStyle = populateVehicleRow[65];
        imgURL = populateVehicleRow[68];

        theVehicle = new Vehicle(VIN, theDealerPrice, theSalePrice, imgURL, make, model, year, series, trim, vehicleType, plantCountry, basePrice, entertainSys, numOfSeats,
                numOfSeatRows, antiLockBraking, electronicStability, tractionControl, keylessIgnition, autoCrashNotif, backupCam, parkingAssist, rearCrossTrafficAlert,
                rearAutoEmergBraking, crashImmBraking, forwColliWarn, dynamicBrakeSupp, pedestrianAutoEmergBrak, blindSpotWarn,
                laneDepartWarn, laneKeepAssist, blindSpotIntervention, laneCenterAssist, daytimeRunLights, headlampLightSrc, headlampBeamSwitch,
                adaptDrivingBeam, adaptiveCruiseControl, numOfCylinders, displacementCC, displacementCI, displacementL, enginePowerkW, fuelTypePrim, fuelTypeSec, fuelInjectionType,
                engineConfig, horsepower, electricificationLevel, otherEngineInfo, turbo, topSpeed, engineManufact, bodyClass, numOfDoors, numOfWindows, wheelBaseType, bedLength, curbWeight,
                wheelBase, grossCombWeight, truckBedType, truckCabType, numOfWheels, wheelSizeFrontIn, wheelSizeRearIn, driveType, axles, transmissionStyle);
    }

}
