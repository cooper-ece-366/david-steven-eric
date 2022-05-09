import React, { useState } from 'react';
//import useInterval from './useInterval';
import coopercars1_logo from '../CooperCars-logos.jpeg';
import coopercars2_logo from '../CooperCars-logos_black.png';
import '../App.css';
import NavBar from './NavBar'
import logo from "../CooperCars-logos_white.png";
import TextField from "@material-ui/core/TextField";
import Popup from 'react-animated-popup';
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

function HomePage() {
  const apiUrlPrefix = "http://localhost:8080";
  //const vins = ['1FMCU9GD1HUA30879', '3FA6P0LU1KR242602', '3HGGK5H88KM742051', '5YJ3E1EA5JF098290', '1FTEX1E51KKC66386', '1C4RJFLG1HC603078', '3FA6P0LU1KR101755', 'JTMRWRFV7LJ048851', '1G1RE6E42EU111830', 'SADCJ2BN5HA086947', 'KNMAT2MV3JP608780', '5NPD84LF6KH490922', '5npe34af3jh646547', '2hgfc2f78jh564740', '5YFEPRAE7LP054292', '55SWF4KB5GU142000'];

  const [visible, setVisible] = useState(false);

  const [currentVIN, setCurrentVIN] = useState('-');
  const [currentVehicleInfo, setCurrentVehicleInfo] = useState('-');
  const [currentVehicleFeatures1, setCurrentVehicleFeatures1] = useState('-');
  const [currentVehicleFeatures2, setCurrentVehicleFeatures2] = useState('-');
  const [currentVehicleFeatures3, setCurrentVehicleFeatures3] = useState('-');
  const [currentVehicleFeatures4, setCurrentVehicleFeatures4] = useState('-');
  const [currentVehicleFeatures5, setCurrentVehicleFeatures5] = useState('-');

  //const [data,setData] = useState(null);
  //const [print,setPrint] = useState(false);
  //const vinDelay = 30000; // in milliseconds
  const [vin, setVin] = useState("");


  HomePage.refreshVehicleInfo = (vin) => {
    console.log("Refreshing ... %s vehicle ...", currentVIN);
    // var vin = vins[Math.floor(Math.random() * vins.length)];
    setCurrentVIN(vin);
    setCurrentVehicleInfo(vin);
    setCurrentVehicleFeatures1(vin);
    setCurrentVehicleFeatures2(vin);
    setCurrentVehicleFeatures3(vin);
    setCurrentVehicleFeatures4(vin);
    setCurrentVehicleFeatures5(vin);

    var vehicleApiUrl = apiUrlPrefix.concat("/api/vehicle/",vin);
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
  // useInterval(() => {
  //   HomePage.refreshVehicleInfo();
  // }, vinDelay);


  HomePage.buttonClicked = () => {
    console.log('Button was clicked!');
    HomePage.refreshVehicleInfo(vin);
  }

  // HomePage.getData = (val) => {
  //     setData(val.target.value)
  //     console.warn(val.target.value)
  // }
const containerStyle = {
  display: 'flex',
  alignItems: 'center',
  justifyContent: 'center',
  minHeight: '100vh'
}

const buttonStyle = {
  backgroundColor: 'cadetblue',
  color: '#fff',
  padding: 10,
  cursor: 'pointer'
}

const pStyle = {
  textAlign: 'center'
}


  return (
    <div className="App">
      <header className="App-header">
      <div onMouseEnter={() => setVisible(true)} onMouseLeave={() => setVisible(false)}><img src={logo}   className="App-logo" alt="cooper-logo" height = "400" width = "200"/></div>

          {visible ? <p>Welcome to CooperCars! A website for car dealerships to manage their inventory. Sign in to add/remove vehicles to inventory or browse through the inventory.</p> : <p></p>}



      </header>
    </div>
  );
}

export default HomePage;
