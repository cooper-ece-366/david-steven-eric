
package edu.cooper.ece366.project.coopercars.server.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

//David
class VehicleAPITest {

    VehicleAPI vehicleAPI;

    Vehicle vehicle;
    private String VIN;
    private double dealerPrice;
    private double salePrice;
    private double profit;
    private double mileage;
    private String status;
    private String imgURL;
    private String enteredDate;

    @BeforeEach
    void createVehicle(){
        try {
            vehicleAPI = new VehicleAPI("3HGGK5H88KM742051", "TestStatus", "1000.0", "1000.0", "1000.0");
        }
        catch (IOException ex) {
            System.out.println("Unable to communicate to Vehicle API.");
        }
        vehicle = new Vehicle();
        vehicleAPI.setTheVehicle(vehicle);
        vehicle = vehicleAPI.getTheVehicle();
    }

    @Test
    void Vin() {
        vehicle.setVIN("vin");
        System.out.println("check VIN");
        assertEquals("vin", vehicle.getVIN());
    }

    @Test
    void DealerPrice() {
        vehicle.setDealerPrice(100);
        System.out.println("check dealer price");
        assertEquals(100, vehicle.getDealerPrice());
    }

    @Test
    void SalePrice() {
        vehicle.setSalePrice(500);
        System.out.println("Check sale price");
        assertEquals(500, vehicle.getSalePrice());
    }


    @Test
    void Profit() {
        vehicle.setProfit(500);
        System.out.println("check profit");
        assertEquals(500, vehicle.getProfit());
    }

    @Test
    void ImageUrl() {
        vehicle.setImgURL("test");
        System.out.println("check imageurl");
        assertEquals("test", vehicle.getImgURL());
    }

    @Test
    void Mileage() {
        vehicle.setMileage(1000);
        System.out.println("checking mileage");
        assertEquals(1000, vehicle.getMileage());
    }

    @Test
    void Status() {
        vehicle.setStatus("YO");
        System.out.println("checking status");
        assertEquals("YO", vehicle.getStatus());
    }

    @Test
    void EnteredDate() {
        vehicle.setEnteredDate("YO");
        System.out.println("checking entered date");
        assertEquals("YO", vehicle.getEnteredDate());
    }
    @Test
    void Make() {
        vehicle.setMake("TestMake");
        System.out.println("checking make");
        assertEquals("TestMake", vehicle.getMake());
    }
    @Test
    void Model() {
        vehicle.setModel("TestModel");
        System.out.println("checking model");
        assertEquals("TestModel", vehicle.getModel());
    }
    @Test
    void Year() {
        vehicle.setYear(2022);
        System.out.println("checking year");
        assertEquals(2022, vehicle.getYear());
    }
    @Test
    void Series() {
        vehicle.setSeries("TestSeries");
        System.out.println("checking series");
        assertEquals("TestSeries", vehicle.getSeries());
    }
    @Test
    void Trim() {
        vehicle.setTrim("TestTrim");
        System.out.println("checking trim");
        assertEquals("TestTrim", vehicle.getTrim());
    }
    @Test
    void Type() {
        vehicle.setVehicleType("TestType");
        System.out.println("checking vehicle type");
        assertEquals("TestType", vehicle.getVehicleType());
    }
    @Test
    void Country() {
        vehicle.setPlantCountry("TestCountry");
        System.out.println("checking plant country");
        assertEquals("TestCountry", vehicle.getPlantCountry());
    }
    @Test
    void BasePrice() {
        vehicle.setBasePrice(1000.0);
        System.out.println("checking base price");
        assertEquals(1000.0, vehicle.getBasePrice());
    }
    @Test
    void Entertainment() {
        vehicle.setEntertainSys("TestEnter");
        System.out.println("checking entertainment system");
        assertEquals("TestEnter", vehicle.getEntertainSys());
    }
    @Test
    void Seats() {
        vehicle.setNumOfSeats(5);
        System.out.println("checking number of seats");
        assertEquals(5, vehicle.getNumOfSeats());
    }
    @Test
    void SeatRows() {
        vehicle.setNumOfSeatRows(2);
        System.out.println("checking number of seat rows");
        assertEquals(2, vehicle.getNumOfSeatRows());
    }
    @Test
    void AntiLock() {
        vehicle.setAntiLockBraking("TestAnt");
        System.out.println("checking anti lock braking");
        assertEquals("TestAnt", vehicle.getAntiLockBraking());
    }
    @Test
    void ElecStab() {
        vehicle.setElectronicStability("TestElec");
        System.out.println("checking electronic stability");
        assertEquals("TestElec", vehicle.getElectronicStability());
    }
    @Test
    void Traction() {
        vehicle.setTractionControl("TestTrac");
        System.out.println("checking traction control");
        assertEquals("TestTrac", vehicle.getTractionControl());
    }
    @Test
    void Keyless() {
        vehicle.setKeylessIgnition("TestKey");
        System.out.println("checking keyless ignition");
        assertEquals("TestKey", vehicle.getKeylessIgnition());
    }
    @Test
    void AutoCrash() {
        vehicle.setAutoCrashNotif("TestAuto");
        System.out.println("checking auto crash notif");
        assertEquals("TestAuto", vehicle.getAutoCrashNotif());
    }
    @Test
    void BackupCam() {
        vehicle.setBackupCam("TestBackup");
        System.out.println("checking backup cam");
        assertEquals("TestBackup", vehicle.getBackupCam());
    }
    @Test
    void ParkAssist() {
        vehicle.setParkingAssist("TestPark");
        System.out.println("checking parking assist");
        assertEquals("TestPark", vehicle.getParkingAssist());
    }
    @Test
    void RearCross() {
        vehicle.setRearCrossTrafficAlert("TestRear");
        System.out.println("checking rear cross alert");
        assertEquals("TestRear", vehicle.getRearCrossTrafficAlert());
    }
    @Test
    void RearAuto() {
        vehicle.setRearAutoEmergBraking("TestRear");
        System.out.println("checking rear auto braking");
        assertEquals("TestRear", vehicle.getRearAutoEmergBraking());
    }
    @Test
    void CrashImm() {
        vehicle.setCrashImmBraking("TestCrash");
        System.out.println("checking crash imminent braking");
        assertEquals("TestCrash", vehicle.getCrashImmBraking());
    }
    @Test
    void Forw() {
        vehicle.setForwColliWarn("TestForw");
        System.out.println("checking forward collision warning");
        assertEquals("TestForw", vehicle.getForwColliWarn());
    }
    @Test
    void DynamicBrake() {
        vehicle.setDynamicBrakeSupp("TestDyna");
        System.out.println("dynamic brake support");
        assertEquals("TestDyna", vehicle.getDynamicBrakeSupp());
    }
    @Test
    void Pedest() {
        vehicle.setPedestrianAutoEmergBrak("TestPedes");
        System.out.println("checking pedestrian emergency braking");
        assertEquals("TestPedes", vehicle.getPedestrianAutoEmergBrak());
    }
    @Test
    void BlindWarn() {
        vehicle.setBlindSpotWarn("TestBlind");
        System.out.println("checking blind spot warning");
        assertEquals("TestBlind", vehicle.getBlindSpotWarn());
    }
    @Test
    void LaneDepart() {
        vehicle.setLaneDepartWarn("TestLane");
        System.out.println("lane daeparture warning");
        assertEquals("TestLane", vehicle.getLaneDepartWarn());
    }
    @Test
    void LaneKeep() {
        vehicle.setLaneKeepAssist("TestLane");
        System.out.println("checking lane keep assist");
        assertEquals("TestLane", vehicle.getLaneKeepAssist());
    }
    @Test
    void BlindInter() {
        vehicle.setBlindSpotIntervention("TestBlind");
        System.out.println("checking blind spot intervention");
        assertEquals("TestBlind", vehicle.getBlindSpotIntervention());
    }
    @Test
    void LaneCenter() {
        vehicle.setLaneCenterAssist("TestLane");
        System.out.println("checking lane center assist");
        assertEquals("TestLane", vehicle.getLaneCenterAssist());
    }
    @Test
    void DRL() {
        vehicle.setDaytimeRunLights("TestDRL");
        System.out.println("checking drl");
        assertEquals("TestDRL", vehicle.getDaytimeRunLights());
    }
    @Test
    void Headlamp() {
        vehicle.setHeadlampLightSrc("TestHead");
        System.out.println("checking headlamp light src");
        assertEquals("TestHead", vehicle.getHeadlampLightSrc());
    }
    @Test
    void HeadlampBeam() {
        vehicle.setHeadlampBeamSwitch("TestBeam");
        System.out.println("checking headlamp beam switch");
        assertEquals("TestBeam", vehicle.getHeadlampBeamSwitch());
    }
    @Test
    void AdaptBeam() {
        vehicle.setAdaptDrivingBeam("TestBeam");
        System.out.println("checking adaptive drive beam");
        assertEquals("TestBeam", vehicle.getAdaptDrivingBeam());
    }
    @Test
    void ACC() {
        vehicle.setAdaptiveCruiseControl("TestACC");
        System.out.println("checking adaptive cruise control");
        assertEquals("TestACC", vehicle.getAdaptiveCruiseControl());
    }
    @Test
    void Cylinder() {
        vehicle.setNumOfCylinders(4);
        System.out.println("checking number of cylinders");
        assertEquals(4, vehicle.getNumOfCylinders());
    }
    @Test
    void DisCC() {
        vehicle.setDisplacementCC(5.0);
        System.out.println("checking displacement cc");
        assertEquals(5.0, vehicle.getDisplacementCC());
    }
    @Test
    void DisCI() {
        vehicle.setDisplacementCI(5.0);
        System.out.println("checking displacement ci");
        assertEquals(5.0, vehicle.getDisplacementCI());
    }
    @Test
    void DisL() {
        vehicle.setDisplacementL(5.0);
        System.out.println("checking displacement l");
        assertEquals(5.0, vehicle.getDisplacementL());
    }
    @Test
    void EngPower() {
        vehicle.setEnginePowerkW(5.0);
        System.out.println("checking engine power");
        assertEquals(5.0, vehicle.getEnginePowerkW());
    }
    @Test
    void Fuel() {
        vehicle.setFuelTypePrim("TestFuel");
        System.out.println("checking primary fuel type");
        assertEquals("TestFuel", vehicle.getFuelTypePrim());
    }
    @Test
    void FuelSec() {
        vehicle.setFuelTypeSec("TestFuel");
        System.out.println("checking secondary fuel type");
        assertEquals("TestFuel", vehicle.getFuelTypeSec());
    }
    @Test
    void FuelInj() {
        vehicle.setFuelInjectionType("TestFuel");
        System.out.println("checking fuel injection type");
        assertEquals("TestFuel", vehicle.getFuelInjectionType());
    }
    @Test
    void EngCon() {
        vehicle.setEngineConfig("TestEng");
        System.out.println("checking engine configuration");
        assertEquals("TestEng", vehicle.getEngineConfig());
    }
    @Test
    void HorsePower() {
        vehicle.setHorsepower(5.0);
        System.out.println("checking horsepower");
        assertEquals(5.0, vehicle.getHorsepower());
    }
    @Test
    void ElecLevel() {
        vehicle.setElectricificationLevel("TestElec");
        System.out.println("checking electricification");
        assertEquals("TestElec", vehicle.getElectricificationLevel());
    }
    @Test
    void Other() {
        vehicle.setOtherEngineInfo("TestEng");
        System.out.println("checking other engine info");
        assertEquals("TestEng", vehicle.getOtherEngineInfo());
    }
    @Test
    void Turbo() {
        vehicle.setTurbo("TestTurb");
        System.out.println("checking turbo");
        assertEquals("TestTurb", vehicle.getTurbo());
    }
    @Test
    void Top() {
        vehicle.setTopSpeed(5);
        System.out.println("checking top speed");
        assertEquals(5, vehicle.getTopSpeed());
    }
    @Test
    void EngMan() {
        vehicle.setEngineManufact("TestEng");
        System.out.println("checking engine manufacturer");
        assertEquals("TestEng", vehicle.getEngineManufact());
    }
    @Test
    void BodyClass() {
        vehicle.setBodyClass("TestBody");
        System.out.println("checking body class");
        assertEquals("TestBody", vehicle.getBodyClass());
    }
    @Test
    void NumDoors() {
        vehicle.setNumOfDoors(4);
        System.out.println("checking nuber of doors");
        assertEquals(4, vehicle.getNumOfDoors());
    }
    @Test
    void NumWindows() {
        vehicle.setNumOfWindows(4);
        System.out.println("checking number of windows");
        assertEquals(4, vehicle.getNumOfWindows());
    }
    @Test
    void WheelBase() {
        vehicle.setWheelBaseType("TestWheel");
        System.out.println("checking wheel base");
        assertEquals("TestWheel", vehicle.getWheelBaseType());
    }
    @Test
    void BedLength() {
        vehicle.setBedLength(5.0);
        System.out.println("checking bed length");
        assertEquals(5.0, vehicle.getBedLength());
    }
    @Test
    void CurbWeight() {
        vehicle.setCurbWeight(5.0);
        System.out.println("checking curb weight");
        assertEquals(5.0, vehicle.getCurbWeight());
    }
    @Test
    void Wheel() {
        vehicle.setWheelBase(5.0);
        System.out.println("checking wheel base");
        assertEquals(5.0, vehicle.getWheelBase());
    }
    @Test
    void Gross() {
        vehicle.setGrossCombWeight(5.0);
        System.out.println("checking gross weight");
        assertEquals(5.0, vehicle.getGrossCombWeight());
    }
    @Test
    void TruckBed() {
        vehicle.setTruckBedType("TestBed");
        System.out.println("checking truck bed type");
        assertEquals("TestBed", vehicle.getTruckBedType());
    }
    @Test
    void TruckCab() {
        vehicle.setTruckCabType("TestCab");
        System.out.println("checking truck cab type");
        assertEquals("TestCab", vehicle.getTruckCabType());
    }
    @Test
    void NumWheels() {
        vehicle.setNumOfWheels(4);
        System.out.println("checking number of wheels");
        assertEquals(4, vehicle.getNumOfWheels());
    }
    @Test
    void WheelSizeFront() {
        vehicle.setWheelSizeFrontIn(5);
        System.out.println("checking wheel size front");
        assertEquals(5, vehicle.getWheelSizeFrontIn());
    }
    @Test
    void WheelSizeRear() {
        vehicle.setWheelSizeRearIn(5);
        System.out.println("checking wheel size rear");
        assertEquals(5, vehicle.getWheelSizeRearIn());
    }
    @Test
    void DriveType() {
        vehicle.setDriveType("TestDrive");
        System.out.println("checking drive type");
        assertEquals("TestDrive", vehicle.getDriveType());
    }
    @Test
    void Axles() {
        vehicle.setAxles(5);
        System.out.println("checking axles");
        assertEquals(5, vehicle.getAxles());
    }
    @Test
    void Trans() {
        vehicle.setTransmissionStyle("TestTrans");
        System.out.println("checking transmission style");
        assertEquals("TestTrans", vehicle.getTransmissionStyle());
    }
    @AfterEach
    void deleteVehicle(){
        vehicleAPI = null;
        vehicle = null;
    }
}