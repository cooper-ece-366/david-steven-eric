import {useEffect, useState} from 'react';
import {Outlet, useParams} from 'react-router-dom'
import coopercars1_logo from '../CooperCars-logos.jpeg';
import coopercars2_logo from '../CooperCars-logos_black.png';
import '../App.css';
import NavBar from './NavBar'
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import * as React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';


function VehicleDetails()
{
    const {VIN} = useParams();
    const apiUrlPrefix = "http://localhost:8080";
    const [currentVehicleInfo, setCurrentVehicleInfo] = useState("");
    const [vehicleMake, setVehicleMake] = useState("");
    const [vehicleModel, setVehicleModel] = useState("");
    const [vehicleYear, setVehicleYear] = useState("");
    const [vehicleSeries, setVehicleSeries] = useState("");
    const [vehicleTrim, setVehicleTrim] = useState("");
    const [dealerPrice, setDealerPrice] = useState("");
    const [profit, setProfit] = useState("");
    const [salePrice, setSalePrice] = useState("");
    const [enterDate, setEnterDate] = useState("");

    const [currentVehicleImg, setCurrentVehicleImg] = useState("");
    const [vehicleType, setVehicleType] = useState("");
    const [placeOfManufacture, setPlaceOfManufacture] = useState("");
    const [bodyClass, setBodyClass] = useState("");
    const [numOfSeats, setNumOfSeats] = useState("");
    const [numOfSeatRows, setNumOfSeatRows] = useState("");
    const [wheelSizeFrontIn, setWheelSizeFrontIn] = useState("");
    const [wheelSizeRearIn, setWheelSizeRearIn] = useState("");
    const [driveType, setDriveType] = useState("");
    const [axles, setAxles] = useState("");
    const [transmission,setTransmission] = useState("");
    const [wheelBaseType,setWheelBaseType] = useState("");
    const [wheelBase,setWheelBase] = useState("");
    const [grossWeight, setGrossWeight] = useState("");
    const [curbWeight, setCurbWeight] = useState("");
    const [truckBed,setTruckBed] = useState("");
    const [truckCab,setTruckCab] = useState("");
    const [bedLength, setBedLength] = useState("");

    const [antiLockBraking, setAntiLock] = useState("");
    const [electronicStability, setElecStab] = useState("");
    const [tractionControl, setTraction] = useState("");
    const [keylessIgnition, setKeyless] = useState("");
    const [autoCrashNotif, setAutoCrash] = useState("");
    const [backupCam, setBackup] = useState("");
    const [parkingAssist, setParking] = useState("");
    const [rearCrossTrafficAlert, setRearCross] = useState("");
    const [rearAutoEmergBraking, setRearAutoBrake] = useState("");
    const [crashImmBraking, setCrashImm] = useState("");
    const [forwColliWarn, setForwColli] = useState("");
    const [dynamicBrakeSupp, setDynamicBrake] = useState("");
    const [pedestrianAutoEmergBrak, setPedBrake] = useState("");
    const [blindSpotWarn, setBlindSpotWarn] = useState("");
    const [laneDepartWarn, setLaneDepart] = useState("");
    const [laneKeepAssist, setLaneKeep] = useState("");
    const [blindSpotIntervention, setBlindSpotIntervene] = useState("");
    const [laneCenterAssist, setLaneCenter] = useState("");
    const [daytimeRunLights, setDRL] = useState("");
    const [headlampLightSrc, setHeadlampSrc] = useState("");
    const [headlampBeamSwitch, setHeadlampBeam] = useState("");
    const [adaptDrivingBeam, setAdaptDrivingBeam] = useState("");
    const [adaptiveCruiseControl, setACC] = useState("");

    const [numOfCylinders, setNumCylind] = useState("");
    const [displacementCC, setDisCC] = useState("");
    const [displacementCI, setDisCI] = useState("");
    const [displacementL, setdisL] = useState("");
    const [enginePowerkW, setEnginePower] = useState("");
    const [fuelTypePrim, setFuelPrim] = useState("");
    const [fuelTypeSec, setFuelSec] = useState("");
    const [fuelInjectionType, setFuelInject] = useState("");
    const [engineConfig, setEngineConfig] = useState("");
    const [horsepower, setHP] = useState("");
    const [electricificationLevel, setElectrification] = useState("");
    const [otherEngineInfo, setOtherEngine] = useState("");
    const [turbo, setTurbo] = useState("");
    const [topSpeed, setTopSpeed] = useState("");
    const [engineManufact, setEngineManufact] = useState("");


    useEffect(() => {
        window.scrollTo(0, 0);
        console.log("Refreshing ... %s vehicle ...", VIN);
        var vehicleApiUrl = apiUrlPrefix.concat("/api/vehicle/getinfo/",VIN);
        fetch(vehicleApiUrl)
            .then(response => response.json())
            .then(data => {
                setCurrentVehicleImg(data.imgURL);
                setCurrentVehicleInfo(data.year + " " + data.make + " " + data.model + " " + data.trim + " " + data.series);
                setVehicleMake(data.make);
                setVehicleModel(data.model);
                setVehicleYear(data.year);
                setVehicleSeries(data.series);
                setVehicleTrim(data.trim);
                setDealerPrice(data.dealerPrice);
                setSalePrice(data.salePrice);
                setProfit(data.salePrice - data.dealerPrice);
                setEnterDate(data.enteredDate);
                setVehicleType(data.vehicleType);
                setPlaceOfManufacture(data.plantCountry);
                setBodyClass(data.bodyClass);
                setNumOfSeats(returnVal(data.numOfSeats));
                setNumOfSeatRows(returnVal(data.numOfSeatRows));
                setWheelSizeFrontIn(returnVal(data.wheelSizeFrontIn));
                setWheelSizeRearIn(returnVal(data.wheelSizeRearIn));
                setDriveType(data.driveType);
                setAxles(returnVal(data.axles));
                setTransmission(data.transmissionStyle);
                setWheelBaseType(data.wheelBaseType);
                setWheelBase(returnVal(data.wheelBase));
                setGrossWeight(returnVal(data.grossCombWeight));
                setCurbWeight(returnVal(data.curbWeight));
                setTruckBed(data.truckBedType);
                setTruckCab(data.truckCabType);
                setBedLength(returnVal(data.bedLength));

                setAntiLock(data.antiLockBraking);
                setElecStab(data.electronicStability);
                setTraction(data.tractionControl);
                setKeyless(data.keylessIgnition);
                setAutoCrash(data.autoCrashNotif);
                setBackup(data.backupCam);
                setParking(data.parkingAssist);
                setRearCross(data.rearCrossTrafficAlert);
                setRearAutoBrake(data.rearAutoEmergBraking);
                setCrashImm(data.crashImmBraking);
                setForwColli(data.forwColliWarn);
                setDynamicBrake(data.dynamicBrakeSupp);
                setPedBrake(data.pedestrianAutoEmergBrak);
                setBlindSpotWarn(data.blindSpotWarn);
                setLaneDepart(data.laneDepartWarn);
                setLaneKeep(data.laneKeepAssist);
                setBlindSpotIntervene(data.blindSpotIntervention);
                setLaneCenter(data.laneCenterAssist);
                setDRL(data.daytimeRunLights);
                setHeadlampSrc(data.headlampLightSrc);
                setHeadlampBeam(data.headlampBeamSwitch);
                setAdaptDrivingBeam(data.adaptDrivingBeam);
                setACC(data.adaptiveCruiseControl);

                setNumCylind(returnVal(data.numOfCylinders));
                setDisCC(returnVal(data.displacementCC));
                setDisCI(returnVal(data.displacementCI));
                setdisL(returnVal(data.displacementL));
                setEnginePower(returnVal(data.enginePowerkW));
                setFuelPrim(data.fuelTypePrim);
                setFuelSec(data.fuelTypeSec);
                setFuelInject(data.fuelInjectionType);
                setEngineConfig(data.engineConfig);
                setHP(returnVal(data.horsepower));
                setElectrification(data.electricificationLevel);
                setOtherEngine(data.otherEngineInfo);
                setTurbo(data.turbo);
                setTopSpeed(returnVal(data.topSpeed));
                setEngineManufact(data.engineManufact);

                console.log(data);
            })
            .catch(err => {
                console.log("Cannot connect to API endpoint: %s", vehicleApiUrl);
            });
        console.log("Refreshed %s VIN.", VIN);
    }, []);


    function createData(
        name: string,
        value: string
    ) {
        return { name, value};
    }

    function returnVal(value: number)
    {
        var theReturn = "";
        if(value == 0)
        {
            theReturn = ""
        }
        else{
            theReturn = value
        }
        return theReturn;
    }

    const rows0 = [
        createData('Vehicle Make', vehicleMake),
        createData('Vehicle Model', vehicleModel),
        createData('Vehicle Year', vehicleYear),
        createData('Vehicle Series', vehicleSeries),
        createData('Vehicle Trim', vehicleTrim),
        createData('Dealer Price', "$"+dealerPrice),
        createData('Sale Price', "$"+salePrice),
        createData('Profit', "$"+profit),
        createData('Entered Date', enterDate),
    ];

    const rows1 =[
        createData('Vehicle Type', vehicleType),
        createData('Country of Manufacture', placeOfManufacture),
        createData('Body Class', bodyClass),
        createData('Number of Seats', numOfSeats),
        createData('Number of Seat Rows', numOfSeatRows),
        createData('Wheel Size Front (in)', wheelSizeFrontIn),
        createData('Wheel Size Rear (in)', wheelSizeRearIn),
        createData('Drive Type', driveType),
        createData('Axles', axles),
        createData('Transmission Style', transmission),
        createData('Wheel Base Type', wheelBaseType),
        createData('Wheel Base', wheelBase),
        createData('Gross Combined Weight Rating', grossWeight),
        createData('Curb Weight', curbWeight),
        createData('Truck Bed Type', truckBed),
        createData('Truck Cab Type', truckCab),
        createData('Bed Length', bedLength),
    ];

    const rows3 = [
        createData('Anti-lock Braking',antiLockBraking),
        createData('Electronic Stability Control',electronicStability),
        createData('Traction Control',tractionControl),
        createData('Keyless Ignition',keylessIgnition),
        createData('Automatic Crash Notification',autoCrashNotif),
        createData('Backup Camera',backupCam),
        createData('Parking Assist',parkingAssist),
        createData('Rear-Cross Traffic Alert',rearCrossTrafficAlert),
        createData('Rear Automatic Emergency Braking',rearAutoEmergBraking),
        createData('Crash Imminent Braking',crashImmBraking),
        createData('Forward Collision Warning',forwColliWarn),
        createData('Dynamic Brake Support',dynamicBrakeSupp),
        createData('Pedestrian Auto-Emergency Braking',pedestrianAutoEmergBrak),
        createData('Blind Sport Warning',blindSpotWarn),
        createData('Lane Departure Warning',laneDepartWarn),
        createData('Lane Keep Assist (LKA)',laneKeepAssist),
        createData('Blind Spot Intervention',blindSpotIntervention),
        createData('Lane Center Assist (LCA)',laneCenterAssist),
        createData('Daytime Running Lights (DRL)',daytimeRunLights),
        createData('Headlamp Light Source',headlampLightSrc),
        createData('Headlamp Beam Switch',headlampBeamSwitch),
        createData('Adaptive Driving Beam',adaptDrivingBeam),
        createData('Adaptive Cruise Control (ACC)',adaptiveCruiseControl),
    ];

    const rows4 = [
        createData('Number of Cylinders',numOfCylinders),
        createData('Displacement (CC)',displacementCC),
        createData('Displacement (CI)',displacementCI),
        createData('Displacement (L)',displacementL),
        createData('Engine Power (kW)',enginePowerkW),
        createData('Primary Fuel Type',fuelTypePrim),
        createData('Secondary Fuel Type',fuelTypeSec),
        createData('Fuel Injection Type',fuelInjectionType),
        createData('Engine Configuration',engineConfig),
        createData('Horsepower',horsepower),
        createData('Electrification Level',electricificationLevel),
        createData('Turbo',turbo),
        createData('Top Speed (MPH)',topSpeed),
        createData('Engine Manufacturer',engineManufact),
        createData('Other Engine Info',otherEngineInfo),

    ];

    return (
        <div className="App">
            <NavBar />
            <header className="App-header">
                <br></br>
            <p>VIN {VIN} </p>
            {currentVehicleInfo}<br></br>
            <div className="car-image">
                <img src={currentVehicleImg} height="200"/>
            </div>
                <br></br>
                <TableContainer component={Paper} style={{ maxHeight: 400 , maxWidth: 1400 }}>
                    <Table stickyHeader sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
                        <TableHead>
                            <TableRow>
                                <TableCell align="center" colSpan={2}>
                                    <h1>Inventory Information</h1>
                                </TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {rows0.map((row) => (
                                <TableRow
                                    key={row.name}
                                    sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                >
                                    <TableCell component="th" scope="row">
                                        {row.name}
                                    </TableCell>
                                    <TableCell align="right">{row.value}</TableCell>
                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                </TableContainer>
                <br></br>
                <TableContainer component={Paper} style={{ maxHeight: 400 , maxWidth: 1400 }  } >
                    <Table stickyHeader sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
                        <TableHead>
                            <TableRow>
                                <TableCell align="center" colSpan={2}>
                                    <h1>Basic Vehicle Specifications</h1>
                                </TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {rows1.map((row) => (
                                <TableRow
                                    key={row.name}
                                    sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                >
                                    <TableCell component="th" scope="row">
                                        {row.name}
                                    </TableCell>
                                    <TableCell align="right">{row.value}</TableCell>
                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                </TableContainer>
                <br></br>
                <TableContainer component={Paper} style={{ maxHeight: 400 , maxWidth: 1400 }}>
                    <Table stickyHeader sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
                        <TableHead>
                            <TableRow>
                                <TableCell align="center" colSpan={2}>
                                    <h1>Advanced Safety/Convenience Features</h1>
                                </TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {rows3.map((row) => (
                                <TableRow
                                    key={row.name}
                                    sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                >
                                    <TableCell component="th" scope="row">
                                        {row.name}
                                    </TableCell>
                                    <TableCell align="right">{row.value}</TableCell>
                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                </TableContainer>

                <br></br>
                <TableContainer component={Paper} style={{ maxHeight: 400 , maxWidth: 1400 }}>
                    <Table stickyHeader sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
                        <TableHead>
                            <TableRow>
                                <TableCell align="center" colSpan={2}>
                                    <h1>Engine Specifications</h1>
                                </TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {rows4.map((row) => (
                                <TableRow
                                    key={row.name}
                                    sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                >
                                    <TableCell component="th" scope="row">
                                        {row.name}
                                    </TableCell>
                                    <TableCell align="right">{row.value}</TableCell>
                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                </TableContainer>

            </header>

        </div>
    );
}

export default VehicleDetails;