import java.io.File;
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

            String VIN, make, model, series, trim, vehicleType, plantCountry, entertainSys, antiLockBraking, electronicStability,
                    tractionControl, keylessIgnition, autoCrashNotif, backupCam, parkingAssist, rearCrossTrafficAlert, rearAutoEmergBraking,
                    crashImmBraking, forwColliWarn, dynamicBrakeSupp, pedestrianAutoEmergBrak, blindSpotWarn, laneDepartWarn,
                    laneKeepAssist, blindSpotIntervention, laneCenterAssist, daytimeRunLights, headlampLightSrc, headlampBeamSwitch,
                    adaptDrivingBeam, adaptiveCruiseControl, fuelTypePrim, fuelTypeSec, fuelInjectionType, engineConfig, electricificationLevel,
                    otherEngineInfo, turbo, engineManufact, bodyClass, wheelBaseType, truckBedType, truckCabType, driveType, transmissionStyle;
            int year, basePrice, numOfSeats, numOfSeatRows, numOfCylinders, horsepower, topSpeed, numOfDoors, numOfWindows,
                    numOfWheels, wheelSizeFrontIn, wheelSizeRearIn, axles;
            double displacementCC, displacementCI, displacementL, enginePowerkW, bedLength, curbWeight, wheelBase, grossCombWeight;

            while(input.hasNextLine())
            {
                currentLine = input.nextLine();
                vehicleData = currentLine.split(",");

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
                numOfCylinders = Integer.parseInt(vehicleData[24]);
                displacementCC = Integer.parseInt(vehicleData[25]);
                displacementCI = Double.parseDouble(vehicleData[26]);
                displacementL = Double.parseDouble(vehicleData[27]);
                enginePowerkW = Double.parseDouble(vehicleData[28]);
                fuelTypePrim = vehicleData[29];
                engineConfig = vehicleData[30];
                fuelTypeSec = vehicleData[31];
                fuelInjectionType = vehicleData[32];
                horsepower = Integer.parseInt(vehicleData[33]);
                electricificationLevel = vehicleData[34];
                otherEngineInfo = vehicleData[35];
                turbo = vehicleData[36];
                topSpeed = Integer.parseInt(vehicleData[37]);
                engineManufact = vehicleData[38];
                bodyClass = vehicleData[39];
                numOfDoors = Integer.parseInt(vehicleData[40]);
                numOfWindows = Integer.parseInt(vehicleData[41]);
                wheelBaseType = vehicleData[42];
                bedLength = Double.parseDouble(vehicleData[43]);
                curbWeight = Double.parseDouble(vehicleData[44]);
                wheelBase = Double.parseDouble(vehicleData[45]);
                grossCombWeight = Double.parseDouble(vehicleData[46]);
                truckBedType = vehicleData[47];
                truckCabType = vehicleData[48];
                numOfWheels = Integer.parseInt(vehicleData[49]);
                wheelSizeFrontIn = Integer.parseInt(vehicleData[50]);
                wheelSizeRearIn = Integer.parseInt(vehicleData[51]);
                make = vehicleData[52];
                model = vehicleData[53];
                year = Integer.parseInt(vehicleData[54]);
                series = vehicleData[55];
                trim = vehicleData[56];
                vehicleType = vehicleData[57];
                plantCountry = vehicleData[58];
                basePrice = Integer.parseInt(vehicleData[59]);
                entertainSys = vehicleData[60];
                numOfSeats = Integer.parseInt(vehicleData[61]);
                numOfSeatRows = Integer.parseInt(vehicleData[62]);
                driveType = vehicleData[63];
                axles = Integer.parseInt(vehicleData[64]);
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
        }
    }
}

