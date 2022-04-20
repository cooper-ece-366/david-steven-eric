import React, { useState } from 'react';
import {Outlet, useParams} from 'react-router-dom'
import coopercars1_logo from '../CooperCars-logos.jpeg';
import coopercars2_logo from '../CooperCars-logos_black.png';
import '../App.css';
import NavBar from './NavBar'
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";


function VehicleDetails()
{
    const {VIN} = useParams();
    const apiUrlPrefix = "http://localhost:8080";
    const [currentVehicleInfo, setCurrentVehicleInfo] = useState("");
    const [currentVehicleImg, setCurrentVehicleImg] = useState("");
    const [currentVehicleFeatures1, setCurrentVehicleFeatures1] = useState("");
    const [currentVehicleFeatures2, setCurrentVehicleFeatures2] = useState("");
    const [currentVehicleFeatures3, setCurrentVehicleFeatures3] = useState("");
    const [currentVehicleFeatures4, setCurrentVehicleFeatures4] = useState("");
    const [currentVehicleFeatures5, setCurrentVehicleFeatures5] = useState("");

    // TODO: makes infinite API calls, check this
    console.log("Refreshing ... %s vehicle ...", VIN);
    var vehicleApiUrl = apiUrlPrefix.concat("/api/vehicle/getinfo/",VIN);
    fetch(vehicleApiUrl)
        .then(response => response.json())
        .then(data => {
            setCurrentVehicleImg(data.imgURL);
            setCurrentVehicleInfo(data.year + " " + data.make + " " + data.model + " " + data.trim + " " + data.series);
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
        })
        .catch(err => {
            console.log("Cannot connect to API endpoint: %s", vehicleApiUrl);
        });
    console.log("Refreshed %s VIN.", VIN);


    return (
        <div className="App">
            <NavBar />
            <header className="App-header">

                <p>The vehicle for VIN {VIN} is </p>
                {currentVehicleInfo}<br></br>
                <div className="car-image">
                    <img src={currentVehicleImg} height="100"/>
                </div>
                {currentVehicleFeatures1}<br></br>
                {currentVehicleFeatures2}<br></br>
                {currentVehicleFeatures3}<br></br>
                {currentVehicleFeatures4}<br></br>
                {currentVehicleFeatures5}<br></br>
            </header>
        </div>
    );
}

export default VehicleDetails;