import React, { useState } from 'react';
//import useInterval from './useInterval';
import coopercars1_logo from '../CooperCars-logos.jpeg';
import coopercars2_logo from '../CooperCars-logos_black.png';
import '../App.css';
import NavBar from './NavBar'
import TextField from "@material-ui/core/TextField";
import {
    BrowserRouter as Router,
    Route,
    Link,
    Navigate,
    Routes,
} from "react-router-dom";

function getRandomColor() {
    let colorValues = ["red", "blue", "green"];
    return colorValues[Math.floor(Math.random() * colorValues.length)];
}

function AddVehicle() {
    const apiUrlPrefix = "http://localhost:8080";

    const [currentVIN, setCurrentVIN] = useState('-');
    const [currentVehicleInfo, setCurrentVehicleInfo] = useState('-');
    const [currentVehicleFeatures1, setCurrentVehicleFeatures1] = useState('-');
    const [currentVehicleFeatures2, setCurrentVehicleFeatures2] = useState('-');
    const [currentVehicleFeatures3, setCurrentVehicleFeatures3] = useState('-');
    const [currentVehicleFeatures4, setCurrentVehicleFeatures4] = useState('-');
    const [currentVehicleFeatures5, setCurrentVehicleFeatures5] = useState('-');

    const [vin, setVin] = useState("");
    const [salePrice, setSalePrice] = useState("");
    const [dealerPrice, setDealerPrice] = useState("");


    AddVehicle.refreshVehicleInfo = (vin, dealerPrice,salePrice) => {
        console.log("Refreshing ... %s vehicle ...", currentVIN);

        setCurrentVIN(vin);
        setCurrentVehicleInfo(vin);
        setCurrentVehicleFeatures1(vin);
        setCurrentVehicleFeatures2(vin);
        setCurrentVehicleFeatures3(vin);
        setCurrentVehicleFeatures4(vin);
        setCurrentVehicleFeatures5(vin);

        var vehicleApiUrl = apiUrlPrefix.concat("/api/vehicle/",vin+"/"+dealerPrice+"/"+salePrice);
        fetch(vehicleApiUrl)
            .then(response => response.json())
            .then(data => {

                // the following is an example for presentation purposes... we ultimately want to present this in a better way than just sentences
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
        console.log("Refreshed %s VIN.", currentVIN);
    }


    AddVehicle.buttonClicked = () => {
        console.log('Button was clicked!');
        AddVehicle.refreshVehicleInfo(vin,dealerPrice,salePrice);
    }


    return (
        <div className="App">
            <NavBar />
            <header className="App-header">
                <img src={coopercars1_logo} className="App-logo" alt="cooper-logo" />

                <p>
                    Enter VIN, dealer price, sale price of vehicle to add to inventory:
                </p>

                <TextField
                    style={{background: "rgb(232, 241, 250)"}}
                    onChange={(e) => setVin(e.target.value)}
                    value={vin}
                />
                <TextField
                    style={{background: "rgb(232, 241, 250)"}}
                    onChange={(e) => setDealerPrice(e.target.value)}
                    value={dealerPrice}

                />
                <TextField
                    style={{background: "rgb(232, 241, 250)"}}
                    onChange={(e) => setSalePrice(e.target.value)}
                    value={salePrice}

                />

                <button className="button" onClick={AddVehicle.buttonClicked}>Submit</button>

                <br></br>

                <p>The vehicle for VIN {vin} is </p>
                {currentVehicleInfo}<br></br>
                {currentVehicleFeatures1}<br></br>
                {currentVehicleFeatures2}<br></br>
                {currentVehicleFeatures3}<br></br>
                {currentVehicleFeatures4}<br></br>
                {currentVehicleFeatures5}<br></br>
            </header>
        </div>
    );
}

export default AddVehicle;