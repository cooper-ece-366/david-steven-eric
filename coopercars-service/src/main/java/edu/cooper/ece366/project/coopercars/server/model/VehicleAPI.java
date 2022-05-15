package edu.cooper.ece366.project.coopercars.server.model;

import edu.cooper.ece366.project.coopercars.server.model.Vehicle;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.net.URL;

// Eric
// VehicleAPI takes in a VIN number, sales information and returns a Vehicle object.
public class VehicleAPI
{
    // Vehicle object is instance object of this class
    private Vehicle theVehicle;

    public Vehicle getTheVehicle() {
        return theVehicle;
    }

    public void setTheVehicle(Vehicle theVehicle) {
        this.theVehicle = theVehicle;
    }

    // constructor take a VIN, status, dealer/sale price, mileage
    public VehicleAPI(String myVIN, String myStatus, String dealerPrice, String salePrice, String mileage) throws IOException {
        String theVIN = myVIN.trim();
        String theStatus = myStatus;
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

        // call to NHTSA's VIN Decoder Tool
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

        // buffered reader to read returned CSV file from NHTSA
        BufferedReader in = null;
        try {
            URL url = new URL(theURL);
            in = new BufferedReader(new InputStreamReader(url.openStream()));

        } catch (Exception e) {
            System.out.println("An error occured!");
        }

        String currentLine = null;
        String[] vehicleData;

        // vehicle details are parse and populated in an array
        String[] populateVehicleRow = new String[69];
        populateVehicleRow[0] = theVIN;

        // reads line by line; parses with comma seperated delimiter
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

        // populating strings
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

        // converting string to ints
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
        Double theProfit = theSalePrice - theDealerPrice;
        Double theMileage = Double.parseDouble("0" + mileage);

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

        // storing the date/time of when this object was created
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = dateFormat.format(date);

        // web scraper that returns image URL from year, make, model
        imgURL = returnLink(year + "+" + make + "+" +model);

        theVehicle = new Vehicle(VIN, theStatus, theDealerPrice, theSalePrice, theProfit, theMileage, imgURL, strDate, make, model, year, series, trim, vehicleType, plantCountry, basePrice, entertainSys, numOfSeats,
                numOfSeatRows, antiLockBraking, electronicStability, tractionControl, keylessIgnition, autoCrashNotif, backupCam, parkingAssist, rearCrossTrafficAlert,
                rearAutoEmergBraking, crashImmBraking, forwColliWarn, dynamicBrakeSupp, pedestrianAutoEmergBrak, blindSpotWarn,
                laneDepartWarn, laneKeepAssist, blindSpotIntervention, laneCenterAssist, daytimeRunLights, headlampLightSrc, headlampBeamSwitch,
                adaptDrivingBeam, adaptiveCruiseControl, numOfCylinders, displacementCC, displacementCI, displacementL, enginePowerkW, fuelTypePrim, fuelTypeSec, fuelInjectionType,
                engineConfig, horsepower, electricificationLevel, otherEngineInfo, turbo, topSpeed, engineManufact, bodyClass, numOfDoors, numOfWindows, wheelBaseType, bedLength, curbWeight,
                wheelBase, grossCombWeight, truckBedType, truckCabType, numOfWheels, wheelSizeFrontIn, wheelSizeRearIn, driveType, axles, transmissionStyle);
    }

    // web scraper that returns first result from Google Images
    // reference: https://stackoverflow.com/questions/67852467/java-load-first-link-from-google-image-search-jsoup
    public String returnLink(String str) {
        String links = null;
        try {
            String url = "https://www.google.com/search?tbm=isch&q="+str+"+exterior+image+cars.com";
            Document doc = Jsoup.connect(url).get();
            Elements el = doc.getElementsByAttribute("data-src");
            if(!el.isEmpty()) {
                links = el.get(0).attr("data-src");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return links;
    }
}
