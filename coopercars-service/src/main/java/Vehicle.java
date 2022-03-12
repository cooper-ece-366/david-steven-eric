public class Vehicle
{
    /*
    A vehicle may or may not have the attributes in this class.
    This information comes from NHTSA's VIN decoder: https://vpic.nhtsa.dot.gov/decoder/
     */

    private String VIN;

    //general
    private String make;
    private String model;
    private int year;
    private String series;
    private String trim;
    private String vehicleType;
    private String plantCountry;
    private int basePrice;
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
    private int horsepower;
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

    public Vehicle(String VIN, String make, String model, int year, String series, String trim, String vehicleType, String plantCountry, int basePrice, String entertainSys, int numOfSeats, int numOfSeatRows, String antiLockBraking, String electronicStability, String tractionControl, String keylessIgnition, String autoCrashNotif, String backupCam, String parkingAssist, String rearCrossTrafficAlert, String rearAutoEmergBraking, String crashImmBraking, String forwColliWarn, String dynamicBrakeSupp, String pedestrianAutoEmergBrak, String blindSpotWarn, String laneDepartWarn, String laneKeepAssist, String blindSpotIntervention, String laneCenterAssist, String daytimeRunLights, String headlampLightSrc, String headlampBeamSwitch, String adaptDrivingBeam, String adaptiveCruiseControl, int numOfCylinders, double displacementCC, double displacementCI, double displacementL, double enginePowerkW, String fuelTypePrim, String fuelTypeSec, String fuelInjectionType, String engineConfig, int horsepower, String electricificationLevel, String otherEngineInfo, String turbo, int topSpeed, String engineManufact, String bodyClass, int numOfDoors, int numOfWindows, String wheelBaseType, double bedLength, double curbWeight, double wheelBase, double grossCombWeight, String truckBedType, String truckCabType, int numOfWheels, int wheelSizeFrontIn, int wheelsSizeRearIn, String driveType, int axles, String transmissionStyle) {
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.year = year;
        this.series = series;
        this.trim = trim;
        this.vehicleType = vehicleType;
        this.plantCountry = plantCountry;
        this.basePrice = basePrice;
        this.entertainSys = entertainSys;
        this.numOfSeats = numOfSeats;
        this.numOfSeatRows = numOfSeatRows;
        this.antiLockBraking = antiLockBraking;
        this.electronicStability = electronicStability;
        this.tractionControl = tractionControl;
        this.keylessIgnition = keylessIgnition;
        this.autoCrashNotif = autoCrashNotif;
        this.backupCam = backupCam;
        this.parkingAssist = parkingAssist;
        this.rearCrossTrafficAlert = rearCrossTrafficAlert;
        this.rearAutoEmergBraking = rearAutoEmergBraking;
        this.crashImmBraking = crashImmBraking;
        this.forwColliWarn = forwColliWarn;
        this.dynamicBrakeSupp = dynamicBrakeSupp;
        this.pedestrianAutoEmergBrak = pedestrianAutoEmergBrak;
        this.blindSpotWarn = blindSpotWarn;
        this.laneDepartWarn = laneDepartWarn;
        this.laneKeepAssist = laneKeepAssist;
        this.blindSpotIntervention = blindSpotIntervention;
        this.laneCenterAssist = laneCenterAssist;
        this.daytimeRunLights = daytimeRunLights;
        this.headlampLightSrc = headlampLightSrc;
        this.headlampBeamSwitch = headlampBeamSwitch;
        this.adaptDrivingBeam = adaptDrivingBeam;
        this.adaptiveCruiseControl = adaptiveCruiseControl;
        this.numOfCylinders = numOfCylinders;
        this.displacementCC = displacementCC;
        this.displacementCI = displacementCI;
        this.displacementL = displacementL;
        this.enginePowerkW = enginePowerkW;
        this.fuelTypePrim = fuelTypePrim;
        this.fuelTypeSec = fuelTypeSec;
        this.fuelInjectionType = fuelInjectionType;
        this.engineConfig = engineConfig;
        this.horsepower = horsepower;
        this.electricificationLevel = electricificationLevel;
        this.otherEngineInfo = otherEngineInfo;
        this.turbo = turbo;
        this.topSpeed = topSpeed;
        this.engineManufact = engineManufact;
        this.bodyClass = bodyClass;
        this.numOfDoors = numOfDoors;
        this.numOfWindows = numOfWindows;
        this.wheelBaseType = wheelBaseType;
        this.bedLength = bedLength;
        this.curbWeight = curbWeight;
        this.wheelBase = wheelBase;
        this.grossCombWeight = grossCombWeight;
        this.truckBedType = truckBedType;
        this.truckCabType = truckCabType;
        this.numOfWheels = numOfWheels;
        this.wheelSizeFrontIn = wheelSizeFrontIn;
        this.wheelsSizeRearIn = wheelsSizeRearIn;
        this.driveType = driveType;
        this.axles = axles;
        this.transmissionStyle = transmissionStyle;
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

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
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

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
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

    public int getWheelsSizeRearIn() {
        return wheelsSizeRearIn;
    }

    public void setWheelsSizeRearIn(int wheelsSizeRearIn) {
        this.wheelsSizeRearIn = wheelsSizeRearIn;
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
}

