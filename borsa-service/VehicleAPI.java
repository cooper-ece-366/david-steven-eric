import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.net.URL;

// VehicleAPI take in a VIN number and returns a Vehicle object
public class VehicleAPI
{
    private String VIN;

    //general
    private String make;
    private String model;
    private int year;
    private String series;
    private String trim;
    private String vehicleType;
    private String plantCountry;
    private double basePrice;
    private String entertainSys;
    private int numOfSeats;
    private int numOfSeatRows;

    //Active Safety systems
    private String antiLockBraking;
    private String electronicStability;
    private String tractionControl;
    private String keylessIgnition;
    private String autoCrashNotif;
    private String backupCam;
    private String parkingAssist;
    private String rearCrossTrafficAlert;
    private String rearAutoEmergBraking;
    private String crashImmBraking;
    private String forwColliWarn;
    private String dynamicBrakeSupp;
    private String pedestrianAutoEmergBrak;
    private String blindSpotWarn;
    private String laneDepartWarn;
    private String laneKeepAssist;
    private String blindSpotIntervention;
    private String laneCenterAssist;
    private String daytimeRunLights;
    private String headlampLightSrc;
    private String headlampBeamSwitch;
    private String adaptDrivingBeam;
    private String adaptiveCruiseControl;

    // engine
    private int numOfCylinders;
    private double displacementCC;
    private double displacementCI;
    private double displacementL;
    private double enginePowerkW;
    private String fuelTypePrim;
    private String fuelTypeSec;
    private String fuelInjectionType;
    private String engineConfig;
    private double horsepower;
    private String electricificationLevel;
    private String otherEngineInfo;
    private String turbo;
    private int topSpeed;
    private String engineManufact;

    // body
    private String bodyClass;
    private int numOfDoors;
    private int numOfWindows;
    private String wheelBaseType;

    // dimension
    private double bedLength;
    private double curbWeight;
    private double wheelBase;
    private double grossCombWeight;

    //truck
    private String truckBedType;
    private String truckCabType;

    //wheels
    private int numOfWheels;
    private int wheelSizeFrontIn;
    private int wheelsSizeRearIn;

    //drivetrain
    private String driveType;
    private int axles;
    private String transmissionStyle;

    public VehicleAPI(String VIN)
    {
        String theVIN = VIN;

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

    }
}
