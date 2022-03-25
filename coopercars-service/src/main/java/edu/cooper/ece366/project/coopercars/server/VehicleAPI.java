package edu.cooper.ece366.project.coopercars.server;

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
    private int wheelSizeRearIn;

    //drivetrain
    private String driveType;
    private int axles;
    private String transmissionStyle;

    public VehicleAPI(String myVIN) throws IOException {
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

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getPlantCountry() {
        return plantCountry;
    }

    public void setPlantCountry(String plantCountry) {
        this.plantCountry = plantCountry;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public String getEntertainSys() {
        return entertainSys;
    }

    public void setEntertainSys(String entertainSys) {
        this.entertainSys = entertainSys;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public int getNumOfSeatRows() {
        return numOfSeatRows;
    }

    public void setNumOfSeatRows(int numOfSeatRows) {
        this.numOfSeatRows = numOfSeatRows;
    }

    public String getAntiLockBraking() {
        return antiLockBraking;
    }

    public void setAntiLockBraking(String antiLockBraking) {
        this.antiLockBraking = antiLockBraking;
    }

    public String getElectronicStability() {
        return electronicStability;
    }

    public void setElectronicStability(String electronicStability) {
        this.electronicStability = electronicStability;
    }

    public String getTractionControl() {
        return tractionControl;
    }

    public void setTractionControl(String tractionControl) {
        this.tractionControl = tractionControl;
    }

    public String getKeylessIgnition() {
        return keylessIgnition;
    }

    public void setKeylessIgnition(String keylessIgnition) {
        this.keylessIgnition = keylessIgnition;
    }

    public String getAutoCrashNotif() {
        return autoCrashNotif;
    }

    public void setAutoCrashNotif(String autoCrashNotif) {
        this.autoCrashNotif = autoCrashNotif;
    }

    public String getBackupCam() {
        return backupCam;
    }

    public void setBackupCam(String backupCam) {
        this.backupCam = backupCam;
    }

    public String getParkingAssist() {
        return parkingAssist;
    }

    public void setParkingAssist(String parkingAssist) {
        this.parkingAssist = parkingAssist;
    }

    public String getRearCrossTrafficAlert() {
        return rearCrossTrafficAlert;
    }

    public void setRearCrossTrafficAlert(String rearCrossTrafficAlert) {
        this.rearCrossTrafficAlert = rearCrossTrafficAlert;
    }

    public String getRearAutoEmergBraking() {
        return rearAutoEmergBraking;
    }

    public void setRearAutoEmergBraking(String rearAutoEmergBraking) {
        this.rearAutoEmergBraking = rearAutoEmergBraking;
    }

    public String getCrashImmBraking() {
        return crashImmBraking;
    }

    public void setCrashImmBraking(String crashImmBraking) {
        this.crashImmBraking = crashImmBraking;
    }

    public String getForwColliWarn() {
        return forwColliWarn;
    }

    public void setForwColliWarn(String forwColliWarn) {
        this.forwColliWarn = forwColliWarn;
    }

    public String getDynamicBrakeSupp() {
        return dynamicBrakeSupp;
    }

    public void setDynamicBrakeSupp(String dynamicBrakeSupp) {
        this.dynamicBrakeSupp = dynamicBrakeSupp;
    }

    public String getPedestrianAutoEmergBrak() {
        return pedestrianAutoEmergBrak;
    }

    public void setPedestrianAutoEmergBrak(String pedestrianAutoEmergBrak) {
        this.pedestrianAutoEmergBrak = pedestrianAutoEmergBrak;
    }

    public String getBlindSpotWarn() {
        return blindSpotWarn;
    }

    public void setBlindSpotWarn(String blindSpotWarn) {
        this.blindSpotWarn = blindSpotWarn;
    }

    public String getLaneDepartWarn() {
        return laneDepartWarn;
    }

    public void setLaneDepartWarn(String laneDepartWarn) {
        this.laneDepartWarn = laneDepartWarn;
    }

    public String getLaneKeepAssist() {
        return laneKeepAssist;
    }

    public void setLaneKeepAssist(String laneKeepAssist) {
        this.laneKeepAssist = laneKeepAssist;
    }

    public String getBlindSpotIntervention() {
        return blindSpotIntervention;
    }

    public void setBlindSpotIntervention(String blindSpotIntervention) {
        this.blindSpotIntervention = blindSpotIntervention;
    }

    public String getLaneCenterAssist() {
        return laneCenterAssist;
    }

    public void setLaneCenterAssist(String laneCenterAssist) {
        this.laneCenterAssist = laneCenterAssist;
    }

    public String getDaytimeRunLights() {
        return daytimeRunLights;
    }

    public void setDaytimeRunLights(String daytimeRunLights) {
        this.daytimeRunLights = daytimeRunLights;
    }

    public String getHeadlampLightSrc() {
        return headlampLightSrc;
    }

    public void setHeadlampLightSrc(String headlampLightSrc) {
        this.headlampLightSrc = headlampLightSrc;
    }

    public String getHeadlampBeamSwitch() {
        return headlampBeamSwitch;
    }

    public void setHeadlampBeamSwitch(String headlampBeamSwitch) {
        this.headlampBeamSwitch = headlampBeamSwitch;
    }

    public String getAdaptDrivingBeam() {
        return adaptDrivingBeam;
    }

    public void setAdaptDrivingBeam(String adaptDrivingBeam) {
        this.adaptDrivingBeam = adaptDrivingBeam;
    }

    public String getAdaptiveCruiseControl() {
        return adaptiveCruiseControl;
    }

    public void setAdaptiveCruiseControl(String adaptiveCruiseControl) {
        this.adaptiveCruiseControl = adaptiveCruiseControl;
    }

    public int getNumOfCylinders() {
        return numOfCylinders;
    }

    public void setNumOfCylinders(int numOfCylinders) {
        this.numOfCylinders = numOfCylinders;
    }

    public double getDisplacementCC() {
        return displacementCC;
    }

    public void setDisplacementCC(double displacementCC) {
        this.displacementCC = displacementCC;
    }

    public double getDisplacementCI() {
        return displacementCI;
    }

    public void setDisplacementCI(double displacementCI) {
        this.displacementCI = displacementCI;
    }

    public double getDisplacementL() {
        return displacementL;
    }

    public void setDisplacementL(double displacementL) {
        this.displacementL = displacementL;
    }

    public double getEnginePowerkW() {
        return enginePowerkW;
    }

    public void setEnginePowerkW(double enginePowerkW) {
        this.enginePowerkW = enginePowerkW;
    }

    public String getFuelTypePrim() {
        return fuelTypePrim;
    }

    public void setFuelTypePrim(String fuelTypePrim) {
        this.fuelTypePrim = fuelTypePrim;
    }

    public String getFuelTypeSec() {
        return fuelTypeSec;
    }

    public void setFuelTypeSec(String fuelTypeSec) {
        this.fuelTypeSec = fuelTypeSec;
    }

    public String getFuelInjectionType() {
        return fuelInjectionType;
    }

    public void setFuelInjectionType(String fuelInjectionType) {
        this.fuelInjectionType = fuelInjectionType;
    }

    public String getEngineConfig() {
        return engineConfig;
    }

    public void setEngineConfig(String engineConfig) {
        this.engineConfig = engineConfig;
    }

    public double getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(double horsepower) {
        this.horsepower = horsepower;
    }

    public String getElectricificationLevel() {
        return electricificationLevel;
    }

    public void setElectricificationLevel(String electricificationLevel) {
        this.electricificationLevel = electricificationLevel;
    }

    public String getOtherEngineInfo() {
        return otherEngineInfo;
    }

    public void setOtherEngineInfo(String otherEngineInfo) {
        this.otherEngineInfo = otherEngineInfo;
    }

    public String getTurbo() {
        return turbo;
    }

    public void setTurbo(String turbo) {
        this.turbo = turbo;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getEngineManufact() {
        return engineManufact;
    }

    public void setEngineManufact(String engineManufact) {
        this.engineManufact = engineManufact;
    }

    public String getBodyClass() {
        return bodyClass;
    }

    public void setBodyClass(String bodyClass) {
        this.bodyClass = bodyClass;
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(int numOfDoors) {
        this.numOfDoors = numOfDoors;
    }

    public int getNumOfWindows() {
        return numOfWindows;
    }

    public void setNumOfWindows(int numOfWindows) {
        this.numOfWindows = numOfWindows;
    }

    public String getWheelBaseType() {
        return wheelBaseType;
    }

    public void setWheelBaseType(String wheelBaseType) {
        this.wheelBaseType = wheelBaseType;
    }

    public double getBedLength() {
        return bedLength;
    }

    public void setBedLength(double bedLength) {
        this.bedLength = bedLength;
    }

    public double getCurbWeight() {
        return curbWeight;
    }

    public void setCurbWeight(double curbWeight) {
        this.curbWeight = curbWeight;
    }

    public double getWheelBase() {
        return wheelBase;
    }

    public void setWheelBase(double wheelBase) {
        this.wheelBase = wheelBase;
    }

    public double getGrossCombWeight() {
        return grossCombWeight;
    }

    public void setGrossCombWeight(double grossCombWeight) {
        this.grossCombWeight = grossCombWeight;
    }

    public String getTruckBedType() {
        return truckBedType;
    }

    public void setTruckBedType(String truckBedType) {
        this.truckBedType = truckBedType;
    }

    public String getTruckCabType() {
        return truckCabType;
    }

    public void setTruckCabType(String truckCabType) {
        this.truckCabType = truckCabType;
    }

    public int getNumOfWheels() {
        return numOfWheels;
    }

    public void setNumOfWheels(int numOfWheels) {
        this.numOfWheels = numOfWheels;
    }

    public int getWheelSizeFrontIn() {
        return wheelSizeFrontIn;
    }

    public void setWheelSizeFrontIn(int wheelSizeFrontIn) {
        this.wheelSizeFrontIn = wheelSizeFrontIn;
    }

    public int getWheelSizeRearIn() {
        return wheelSizeRearIn;
    }

    public void setWheelSizeRearIn(int wheelSizeRearIn) {
        this.wheelSizeRearIn = wheelSizeRearIn;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public int getAxles() {
        return axles;
    }

    public void setAxles(int axles) {
        this.axles = axles;
    }

    public String getTransmissionStyle() {
        return transmissionStyle;
    }

    public void setTransmissionStyle(String transmissionStyle) {
        this.transmissionStyle = transmissionStyle;
    }

    @Override
    public String toString() {
        return "{" +
                "VIN='" + VIN + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", series='" + series + '\'' +
                ", trim='" + trim + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", plantCountry='" + plantCountry + '\'' +
                ", basePrice=" + basePrice +
                ", horsepower=" + horsepower +
                '}';
    }
}
