package edu.cooper.ece366.project.coopercars.server.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VehicleTest {
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
        vehicle = new Vehicle();
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
        assertEquals("TestMake", vehicle.getMake());
    }
    @Test
    void Model() {
        vehicle.setModel("TestModel");
        assertEquals("TestModel", vehicle.getModel());
    }
    @Test
    void Year() {
        vehicle.setYear(2022);
        assertEquals(2022, vehicle.getYear());
    }
    @Test
    void Series() {
        vehicle.setSeries("TestSeries");
        assertEquals("TestSeries", vehicle.getSeries());
    }
    @Test
    void Trim() {
        vehicle.setTrim("TestTrim");
        assertEquals("TestTrim", vehicle.getTrim());
    }
    @Test
    void Type() {
        vehicle.setVehicleType("TestType");
        assertEquals("TestType", vehicle.getVehicleType());
    }
    @Test
    void Country() {
        vehicle.setPlantCountry("TestCountry");
        assertEquals("TestCountry", vehicle.getPlantCountry());
    }
    @Test
    void BasePrice() {
        vehicle.setBasePrice(1000.0);
        assertEquals(1000.0, vehicle.getBasePrice());
    }
    @Test
    void Entertainment() {
        vehicle.setEntertainSys("TestEnter");
        assertEquals("TestEnter", vehicle.getEntertainSys());
    }
    @Test
    void Seats() {
        vehicle.setNumOfSeats(5);
        assertEquals(5, vehicle.getNumOfSeats());
    }
    @Test
    void SeatRows() {
        vehicle.setNumOfSeatRows(2);
        assertEquals(2, vehicle.getNumOfSeatRows());
    }
    @Test
    void AntiLock() {
        vehicle.setAntiLockBraking("TestAnt");
        assertEquals("TestAnt", vehicle.getAntiLockBraking());
    }
    @Test
    void ElecStab() {
        vehicle.setElectronicStability("TestElec");
        assertEquals("TestElec", vehicle.getElectronicStability());
    }
    @Test
    void Traction() {
        vehicle.setTractionControl("TestTrac");
        assertEquals("TestTrac", vehicle.getTractionControl());
    }
    @Test
    void Keyless() {
        vehicle.setKeylessIgnition("TestKey");
        assertEquals("TestKey", vehicle.getKeylessIgnition());
    }
    @Test
    void AutoCrash() {
        vehicle.setAutoCrashNotif("TestAuto");
        assertEquals("TestAuto", vehicle.getAutoCrashNotif());
    }
    @Test
    void BackupCam() {
        vehicle.setBackupCam("TestBackup");
        assertEquals("TestBackup", vehicle.getBackupCam());
    }
    @Test
    void ParkAssist() {
        vehicle.setParkingAssist("TestPark");
        assertEquals("TestPark", vehicle.getParkingAssist());
    }
    @Test
    void RearCross() {
        vehicle.setRearCrossTrafficAlert("TestRear");
        assertEquals("TestRear", vehicle.getRearCrossTrafficAlert());
    }
    @Test
    void RearAuto() {
        vehicle.setRearAutoEmergBraking("TestRear");
        assertEquals("TestRear", vehicle.getRearAutoEmergBraking());
    }
    @Test
    void CrashImm() {
        vehicle.setCrashImmBraking("TestCrash");
        assertEquals("TestCrash", vehicle.getCrashImmBraking());
    }
    @Test
    void Forw() {
        vehicle.setForwColliWarn("TestForw");
        assertEquals("TestForw", vehicle.getForwColliWarn());
    }
    @Test
    void DynamicBrake() {
        vehicle.setDynamicBrakeSupp("TestDyna");
        assertEquals("TestDyna", vehicle.getDynamicBrakeSupp());
    }
    @Test
    void Pedest() {
        vehicle.setPedestrianAutoEmergBrak("TestPedes");
        assertEquals("TestPedes", vehicle.getPedestrianAutoEmergBrak());
    }
    @Test
    void BlindWarn() {
        vehicle.setBlindSpotWarn("TestBlind");
        assertEquals("TestBlind", vehicle.getBlindSpotWarn());
    }
    @Test
    void LaneDepart() {
        vehicle.setLaneDepartWarn("TestLane");
        assertEquals("TestLane", vehicle.getLaneDepartWarn());
    }
    @Test
    void LaneKeep() {
        vehicle.setLaneKeepAssist("TestLane");
        assertEquals("TestLane", vehicle.getLaneKeepAssist());
    }
    @Test
    void BlindInter() {
        vehicle.setBlindSpotIntervention("TestBlind");
        assertEquals("TestBlind", vehicle.getBlindSpotIntervention());
    }
    @Test
    void LaneCenter() {
        vehicle.setLaneCenterAssist("TestLane");
        assertEquals("TestLane", vehicle.getLaneCenterAssist());
    }
    @Test
    void DRL() {
        vehicle.setDaytimeRunLights("TestDRL");
        assertEquals("TestDRL", vehicle.getDaytimeRunLights());
    }
    @Test
    void Headlamp() {
        vehicle.setHeadlampLightSrc("TestHead");
        assertEquals("TestHead", vehicle.getHeadlampLightSrc());
    }
    @Test
    void HeadlampBeam() {
        vehicle.setHeadlampBeamSwitch("TestBeam");
        assertEquals("TestBeam", vehicle.getHeadlampBeamSwitch());
    }
    @Test
    void AdaptBeam() {
        vehicle.setAdaptDrivingBeam("TestBeam");
        assertEquals("TestBeam", vehicle.getAdaptDrivingBeam());
    }
    @Test
    void ACC() {
        vehicle.setAdaptiveCruiseControl("TestACC");
        assertEquals("TestACC", vehicle.getAdaptiveCruiseControl());
    }
    @Test
    void Cylinder() {
        vehicle.setNumOfCylinders(4);
        assertEquals(4, vehicle.getNumOfCylinders());
    }
    @Test
    void DisCC() {
        vehicle.setDisplacementCC(5.0);
        assertEquals(5.0, vehicle.getDisplacementCC());
    }
    @Test
    void DisCI() {
        vehicle.setDisplacementCI(5.0);
        assertEquals(5.0, vehicle.getDisplacementCI());
    }
    @Test
    void DisL() {
        vehicle.setDisplacementL(5.0);
        assertEquals(5.0, vehicle.getDisplacementL());
    }
    @Test
    void EngPower() {
        vehicle.setEnginePowerkW(5.0);
        assertEquals(5.0, vehicle.getEnginePowerkW());
    }
    @Test
    void Fuel() {
        vehicle.setFuelTypePrim("TestFuel");
        assertEquals("TestFuel", vehicle.getFuelTypePrim());
    }
    @Test
    void FuelSec() {
        vehicle.setFuelTypeSec("TestFuel");
        assertEquals("TestFuel", vehicle.getFuelTypeSec());
    }
    @Test
    void FuelInj() {
        vehicle.setFuelInjectionType("TestFuel");
        assertEquals("TestFuel", vehicle.getFuelInjectionType());
    }
    @Test
    void EngCon() {
        vehicle.setEngineConfig("TestEng");
        assertEquals("TestEng", vehicle.getEngineConfig());
    }
    @Test
    void HorsePower() {
        vehicle.setHorsepower(5.0);
        assertEquals(5.0, vehicle.getHorsepower());
    }
    @Test
    void ElecLevel() {
        vehicle.setElectricificationLevel("TestElec");
        assertEquals("TestElec", vehicle.getElectricificationLevel());
    }
    @Test
    void Other() {
        vehicle.setOtherEngineInfo("TestEng");
        assertEquals("TestEng", vehicle.getOtherEngineInfo());
    }
    @Test
    void Turbo() {
        vehicle.setTurbo("TestTurb");
        assertEquals("TestTurb", vehicle.getTurbo());
    }
    @Test
    void Top() {
        vehicle.setTopSpeed(5);
        assertEquals(5, vehicle.getTopSpeed());
    }
    @Test
    void EngMan() {
        vehicle.setEngineManufact("TestEng");
        assertEquals("TestEng", vehicle.getEngineManufact());
    }
    @Test
    void BodyClass() {
        vehicle.setBodyClass("TestBody");
        assertEquals("TestBody", vehicle.getBodyClass());
    }
    @Test
    void NumDoors() {
        vehicle.setNumOfDoors(4);
        assertEquals(4, vehicle.getNumOfDoors());
    }
    @Test
    void NumWindows() {
        vehicle.setNumOfWindows(4);
        assertEquals(4, vehicle.getNumOfWindows());
    }
    @Test
    void WheelBase() {
        vehicle.setWheelBaseType("TestWheel");
        assertEquals("TestWheel", vehicle.getWheelBaseType());
    }
    @Test
    void BedLength() {
        vehicle.setBedLength(5.0);
        assertEquals(5.0, vehicle.getBedLength());
    }
    @Test
    void CurbWeight() {
        vehicle.setCurbWeight(5.0);
        assertEquals(5.0, vehicle.getCurbWeight());
    }
    @Test
    void Wheel() {
        vehicle.setWheelBase(5.0);
        assertEquals(5.0, vehicle.getWheelBase());
    }
    @Test
    void Gross() {
        vehicle.setGrossCombWeight(5.0);
        assertEquals(5.0, vehicle.getGrossCombWeight());
    }
    @Test
    void TruckBed() {
        vehicle.setTruckBedType("TestBed");
        assertEquals("TestBed", vehicle.getTruckBedType());
    }
    @Test
    void TruckCab() {
        vehicle.setTruckCabType("TestCab");
        assertEquals("TestCab", vehicle.getTruckCabType());
    }
    @Test
    void NumWheels() {
        vehicle.setNumOfWheels(4);
        assertEquals(4, vehicle.getNumOfWheels());
    }
    @Test
    void WheelSizeFront() {
        vehicle.setWheelSizeFrontIn(5);
        assertEquals(5, vehicle.getWheelSizeFrontIn());
    }
    @Test
    void WheelSizeRear() {
        vehicle.setWheelSizeRearIn(5);
        assertEquals(5, vehicle.getWheelSizeRearIn());
    }
    @Test
    void DriveType() {
        vehicle.setDriveType("TestDrive");
        assertEquals("TestDrive", vehicle.getDriveType());
    }
    @Test
    void Axles() {
        vehicle.setAxles(5);
        assertEquals(5, vehicle.getAxles());
    }
    @Test
    void Trans() {
        vehicle.setTransmissionStyle("TestTrans");
        assertEquals("TestTrans", vehicle.getTransmissionStyle());
    }
    @AfterEach
    void deleteVehicle(){
        vehicle = null;
        assertNull(vehicle);
    }
}
