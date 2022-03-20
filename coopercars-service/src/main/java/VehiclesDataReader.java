import java.io.File;
import java.util.List;
import java.util.Scanner;

public class VehiclesDataReader
{
    public static void main (String[] args) throws Exception
    {
        String filename = "vehiclesDatabase.csv";
        File inputFile = new File(filename);
        if (!inputFile.exists())
            System.out.println("File cannot be found");
        else
        {
            Vehicles vehiclesDatabase = new Vehicles();

            Scanner input = new Scanner(inputFile);
            String currentLine;
            String[] vehicleData;
            Vehicle theVehicle;

            input.nextLine();

            String VIN, make, model, series, trim, vehicleType, plantCountry, entertainSys, antiLockBraking, electronicStability,
                    tractionControl, keylessIgnition, autoCrashNotif, backupCam, parkingAssist, rearCrossTrafficAlert, rearAutoEmergBraking,
                    crashImmBraking, forwColliWarn, dynamicBrakeSupp, pedestrianAutoEmergBrak, blindSpotWarn, laneDepartWarn,
                    laneKeepAssist, blindSpotIntervention, laneCenterAssist, daytimeRunLights, headlampLightSrc, headlampBeamSwitch,
                    adaptDrivingBeam, adaptiveCruiseControl, fuelTypePrim, fuelTypeSec, fuelInjectionType, engineConfig, electricificationLevel,
                    otherEngineInfo, turbo, engineManufact, bodyClass, wheelBaseType, truckBedType, truckCabType, driveType, transmissionStyle;
            int year= 0,  numOfSeats= 0, numOfSeatRows= 0, numOfCylinders= 0, topSpeed= 0, numOfDoors= 0, numOfWindows= 0,
                    numOfWheels= 0, wheelSizeFrontIn= 0, wheelSizeRearIn= 0, axles = 0;
            double displacementCC = 0.0, displacementCI = 0.0, displacementL = 0.0, enginePowerkW = 0.0, bedLength = 0.0, curbWeight = 0.0,
                    wheelBase = 0.0, grossCombWeight = 0.0, basePrice = 0.0, horsepower = 0.0;

            while(input.hasNextLine())
            {
                currentLine = input.nextLine();
                vehicleData = currentLine.split(",",66);
                VIN = vehicleData[0];
                antiLockBraking = vehicleData[1];
                electronicStability = vehicleData[2];
                tractionControl = vehicleData[3];
                keylessIgnition = vehicleData[4];
                autoCrashNotif = vehicleData[5];
                backupCam = vehicleData[6];
                parkingAssist = vehicleData[7];
                rearCrossTrafficAlert = vehicleData[8];
                rearAutoEmergBraking = vehicleData[9];
                crashImmBraking = vehicleData[10];
                forwColliWarn = vehicleData[11];
                dynamicBrakeSupp = vehicleData[12];
                pedestrianAutoEmergBrak = vehicleData[13];
                blindSpotWarn = vehicleData[14];
                laneDepartWarn = vehicleData[15];
                laneKeepAssist = vehicleData[16];
                blindSpotIntervention = vehicleData[17];
                laneCenterAssist = vehicleData[18];
                daytimeRunLights = vehicleData[19];
                headlampLightSrc = vehicleData[20];
                headlampBeamSwitch = vehicleData[21];
                adaptDrivingBeam = vehicleData[22];
                adaptiveCruiseControl = vehicleData[23];
                year = Integer.parseInt("0" + vehicleData[54]);

                numOfCylinders = Integer.parseInt("0" + vehicleData[24]);
                displacementCC = Double.parseDouble("0" + vehicleData[25]);
                displacementCI = Double.parseDouble("0" + vehicleData[26]);
                displacementL = Double.parseDouble("0" + vehicleData[27]);
                enginePowerkW = Double.parseDouble("0" + vehicleData[28]);
                horsepower = Double.parseDouble("0" + vehicleData[33]);
                topSpeed = Integer.parseInt("0" + vehicleData[37]);
                numOfDoors = Integer.parseInt("0" + vehicleData[40]);
                numOfWindows = Integer.parseInt("0" + vehicleData[41]);
                bedLength = Double.parseDouble("0" + vehicleData[43]);
                curbWeight = Double.parseDouble("0" + vehicleData[44]);
                wheelBase = Double.parseDouble("0" + vehicleData[45]);
                grossCombWeight = Double.parseDouble("0" + vehicleData[46]);
                numOfWheels = Integer.parseInt("0" + vehicleData[49]);
                wheelSizeFrontIn = Integer.parseInt("0" + vehicleData[50]);
                wheelSizeRearIn = Integer.parseInt("0" + vehicleData[51]);

                basePrice = Double.parseDouble("0"+vehicleData[59]);
                numOfSeats = Integer.parseInt("0" + vehicleData[61]);
                numOfSeatRows = Integer.parseInt("0" + vehicleData[62]);
                axles = Integer.parseInt("0" + vehicleData[64]);


                fuelTypePrim = vehicleData[29];
                engineConfig = vehicleData[30];
                fuelTypeSec = vehicleData[31];
                fuelInjectionType = vehicleData[32];
                electricificationLevel = vehicleData[34];
                otherEngineInfo = vehicleData[35];
                turbo = vehicleData[36];
                engineManufact = vehicleData[38];
                bodyClass = vehicleData[39];
                wheelBaseType = vehicleData[42];
                truckBedType = vehicleData[47];
                truckCabType = vehicleData[48];
                make = vehicleData[52];
                model = vehicleData[53];
                series = vehicleData[55];
                trim = vehicleData[56];
                vehicleType = vehicleData[57];
                plantCountry = vehicleData[58];
                entertainSys = vehicleData[60];
                driveType = vehicleData[63];
                transmissionStyle = vehicleData[65];

                theVehicle = new Vehicle(VIN,make,model,year,series,trim,vehicleType,plantCountry,basePrice,entertainSys,numOfSeats,
                        numOfSeatRows,antiLockBraking,electronicStability,tractionControl,keylessIgnition,autoCrashNotif,backupCam,parkingAssist,rearCrossTrafficAlert,
                        rearAutoEmergBraking,crashImmBraking,forwColliWarn,dynamicBrakeSupp,pedestrianAutoEmergBrak,blindSpotWarn,
                        laneDepartWarn,laneKeepAssist,blindSpotIntervention,laneCenterAssist,daytimeRunLights,headlampLightSrc,headlampBeamSwitch,
                        adaptDrivingBeam,adaptiveCruiseControl,numOfCylinders,displacementCC,displacementCI,displacementL,enginePowerkW,fuelTypePrim,fuelTypeSec,fuelInjectionType,
                        engineConfig,horsepower,electricificationLevel,otherEngineInfo,turbo,topSpeed,engineManufact,bodyClass,numOfDoors,numOfWindows,wheelBaseType,bedLength,curbWeight,
                        wheelBase,grossCombWeight,truckBedType,truckCabType,numOfWheels,wheelSizeFrontIn,wheelSizeRearIn,driveType,axles,transmissionStyle);

                vehiclesDatabase.addVehicle(theVehicle);


            }
            input.close();

            System.out.println("PRINT DATABASE SORTED BY BASE PRICE");
            Vehicles sortedByBasePrice = vehiclesDatabase;
            sortedByBasePrice.sortByBasePrice();
            System.out.println(sortedByBasePrice);
            System.out.println();

            System.out.println("PRINT DATABASE SORTED BY HORSEPOWER");
            Vehicles sortedByHP = vehiclesDatabase;
            sortedByHP.sortByHorsepower();
            System.out.println(sortedByHP);
            System.out.println();

            System.out.println("PRINT VEHICLES WITH ACC");
            List<Vehicle> allWithACC = vehiclesDatabase.getAllWithACC();
            for (Vehicle hasACC : allWithACC)
                System.out.println(hasACC);
            System.out.println();

        }
    }
}

