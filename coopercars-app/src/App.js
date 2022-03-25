import React, { useState } from 'react';
import useInterval from './useInterval';
import coopercars1_logo from './CooperCars-logos_transparent.png';
import coopercars2_logo from './CooperCars-logos_black.png';
import './App.css';
import NavBar from './components/NavBar'
import TextField from "@material-ui/core/TextField";

function getRandomColor() {
  let colorValues = ["red", "blue", "green"];
  return colorValues[Math.floor(Math.random() * colorValues.length)];
}

function App() {
  const apiUrlPrefix = "http://localhost:8080";
  //const vins = ['1FMCU9GD1HUA30879', '3FA6P0LU1KR242602', '3HGGK5H88KM742051', '5YJ3E1EA5JF098290', '1FTEX1E51KKC66386', '1C4RJFLG1HC603078', '3FA6P0LU1KR101755', 'JTMRWRFV7LJ048851', '1G1RE6E42EU111830', 'SADCJ2BN5HA086947', 'KNMAT2MV3JP608780', '5NPD84LF6KH490922', '5npe34af3jh646547', '2hgfc2f78jh564740', '5YFEPRAE7LP054292', '55SWF4KB5GU142000'];

  const [currentVIN, setCurrentVIN] = useState('-');
  const [currentVehicleInfo, setCurrentVehicleInfo] = useState('-');
  //const [data,setData] = useState(null);
  //const [print,setPrint] = useState(false);
  //const vinDelay = 30000; // in milliseconds
  const [vin, setVin] = useState("");


  App.refreshVehicleInfo = (vin) => {
    console.log("Refreshing ... %s vehicle ...", currentVIN);
    // var vin = vins[Math.floor(Math.random() * vins.length)];
    setCurrentVIN(vin);
    setCurrentVehicleInfo(vin);
    var vehicleApiUrl = apiUrlPrefix.concat("/api/vehicle/",vin);
      fetch(vehicleApiUrl)
      .then(response => response.json())
      .then(data => {

        setCurrentVehicleInfo(data.year + " " + data.make + " " + data.model + " " + data.trim + " " + data.series);
        console.log(data);
      })
      .catch(err => {
        console.log("Cannot connect to API endpoint: %s", vehicleApiUrl);
      });
    console.log("Refreshed %s VIN.", currentVIN);
  }
  // useInterval(() => {
  //   App.refreshVehicleInfo();
  // }, vinDelay);


  App.buttonClicked = () => {
    console.log('Button was clicked!');
    App.refreshVehicleInfo(vin);
  }

  // App.getData = (val) => {
  //     setData(val.target.value)
  //     console.warn(val.target.value)
  // }

  return (
    <div className="App">
      <NavBar />
      <header className="App-header">
      <img src={coopercars1_logo} className="App-logo" alt="cooper-logo" />

        <p>
          Enter VIN of vehicle to add to inventory:
        </p>

        <TextField
            style={{background: "rgb(232, 241, 250)"}}
            value={vin}
            onChange={(e) => {
              setVin(e.target.value);
            }}

        />

        <button className="button" onClick={App.buttonClicked}>Submit</button>


        {/*<input type="text" onChange={App.getData}/>*/}
        {/*<button onClick={App.getData}>Submit</button>*/}

        <br></br>
        {/*<button className="button" onClick={App.buttonClicked}>Click to Refresh</button>*/}

        <p>The vehicle for VIN {vin} is</p>
        {currentVehicleInfo}
        <p></p>
      </header>
    </div>
  );
}

export default App;
