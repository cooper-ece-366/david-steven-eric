import { useState } from 'react';
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
    const [currentVehicleImg, setCurrentVehicleImg] = useState("");
    const [vehicleType, setVehicleType] = useState("");
    const [placeOfManufacture, setPlaceOfManufacture] = useState("");
    const [bodyClass, setBodyClass] = useState("");
    const [numOfSeats, setNumOfSeats] = useState("");
    const [numOfSeatRows, setNumOfSeatRows] = useState("");
    const [wheelSizeFrontIn, setWheelSizeFrontIn] = useState("");
    const [currentVehicleFeatures1, setCurrentVehicleFeatures1] = useState("");
    const [currentVehicleFeatures2, setCurrentVehicleFeatures2] = useState("");
    const [currentVehicleFeatures3, setCurrentVehicleFeatures3] = useState("");
    const [currentVehicleFeatures4, setCurrentVehicleFeatures4] = useState("");
    const [currentVehicleFeatures5, setCurrentVehicleFeatures5] = useState("");
    // let rows = [];

    // TODO: makes infinite API calls, check this
    console.log("Refreshing ... %s vehicle ...", VIN);
    var vehicleApiUrl = apiUrlPrefix.concat("/api/vehicle/getinfo/",VIN);
    fetch(vehicleApiUrl)
        .then(response => response.json())
        .then(data => {
            setCurrentVehicleImg(data.imgURL);
            setCurrentVehicleInfo(data.year + " " + data.make + " " + data.model + " " + data.trim + " " + data.series);
            setVehicleType(data.vehicleType);
            setPlaceOfManufacture(data.plantCountry);
            setBodyClass(data.bodyClass);
            var numSeats = "";
            if(data.numOfSeats === 0)
            {
                numSeats = "Not available"
            }
            else{
                numSeats = data.numOfSeats
            }
            setNumOfSeats(numSeats)
            var numSeatsRows = "";
            if(data.numOfSeats === 0)
            {
                numSeatsRows = "Not available"
            }
            else{
                numSeatsRows = data.numOfSeatRows
            }
            setNumOfSeatRows(numSeatsRows)

            var wheelSizeFront = "";
            if(data.wheelSizeFrontIn == 0)
            {
                wheelSizeFront = "Not available"
            }
            else{
                wheelSizeFront = data.wheelSizeFrontIn
            }
            setWheelSizeFrontIn(wheelSizeFront)

            if(data.numOfSeatRows == 0)
            {
                numSeatsRows = "Not available"
            }
            else{
                numSeatsRows = data.numOfSeatRows
            }
            setNumOfSeatRows(numSeatsRows)


            var hasFCW = "";
            var hasBSW = "";
            var hasACC = "";
            var hasBackup = "";

            if (data.forwColliWarn === "Standard"){
                hasFCW = "- Is equipped "
            }
            else{
                hasFCW = "- Is not equipped "
            }
            if (data.blindSpotWarn == "Standard"){
                hasBSW = "- Is equipped "
            }
            else{
                hasBSW = "- Is not equipped "
            }
            if (data.adaptiveCruiseControl == "Standard"){
                hasACC = "- Is equipped "
            }
            else{
                hasACC = "- Is not equipped "
            }
            if (data.backupCam == "Standard"){
                hasBackup = "- Is equipped "
            }
            else{
                hasBackup = "- Is not equipped "
            }

            setCurrentVehicleFeatures1(hasFCW + "with forward collision warning. ");
            setCurrentVehicleFeatures2(hasBSW + "with blind spot warning. ");
            setCurrentVehicleFeatures3(hasACC + "with adaptive cruise control. ");
            setCurrentVehicleFeatures4(hasBackup + "with a backup camera. ");
            setCurrentVehicleFeatures5("Manufactured in: " + data.plantCountry);




            console.log(data);
            console.log(rows);
        })
        .catch(err => {
            console.log("Cannot connect to API endpoint: %s", vehicleApiUrl);
        });
    console.log("Refreshed %s VIN.", VIN);


    function createData(
        name: string,
        value: string
    ) {
        return { name, value};
    }

    const rows =[
        createData('Vehicle Type', vehicleType),
        createData('Country of Manufacture', placeOfManufacture),
        createData('Body Class', bodyClass),
        createData('Number of Seats', numOfSeats),
        createData('Number of Seat Rows', numOfSeatRows),
        createData('Wheel Size Front (in)', wheelSizeFrontIn),

    ];


    return (
        <div className="App">
            <NavBar />
            <header className="App-header">
            <p>VIN {VIN} </p>
            {currentVehicleInfo}<br></br>
            <div className="car-image">
                <img src={currentVehicleImg} height="100"/>
            </div>
                <TableContainer component={Paper}>
                    <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
                        <TableHead>
                            <TableRow>
                                <TableCell align="center" colSpan={2}>
                                    <h2>Basic Vehicle Details</h2>
                                </TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {rows.map((row) => (
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