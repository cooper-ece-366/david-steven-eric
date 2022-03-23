import React, { useState } from 'react';
import useInterval from './useInterval';
import cooper_logo from './logo2.svg';
import coopercars_logo from './logo.svg';
import './App.css';
import NavBar from './components/NavBar'
import TextField from "@material-ui/core/TextField";

function getRandomColor() {
  let colorValues = ["red", "blue", "green"];
  return colorValues[Math.floor(Math.random() * colorValues.length)];
}

function App() {
  function getData(val)
  {
    setData(val.target.value)
    console.warn(val.target.value)
  }
  const apiUrlPrefix = "http://localhost:8080";
  const vins = ['1FMCU9GD1HUA30879', '3FA6P0LU1KR242602', '3HGGK5H88KM742051', '5YJ3E1EA5JF098290', '1FTEX1E51KKC66386', '1C4RJFLG1HC603078', '3FA6P0LU1KR101755', 'JTMRWRFV7LJ048851', '1G1RE6E42EU111830', 'SADCJ2BN5HA086947', 'KNMAT2MV3JP608780', '5NPD84LF6KH490922', '5npe34af3jh646547', '2hgfc2f78jh564740', '5YFEPRAE7LP054292', '55SWF4KB5GU142000'];

  const [currentVIN, setCurrentVIN] = useState('-');
  const [currentVehicleInfo, setCurrentVehicleInfo] = useState('-');
  const [setData, setPrint] = useState(0);
  const vinDelay = 30000; // in milliseconds


  App.refreshVehicleInfo = () => {
    console.log("Refreshing ... %s vehicle ...", currentVIN);
    var vin = vins[Math.floor(Math.random() * vins.length)];
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
  useInterval(() => {
    App.refreshVehicleInfo();
  }, vinDelay);


  App.buttonClicked = () => {
    console.log('Button was clicked!');
    App.refreshVehicleInfo();
  }

  return (
    <div className="App">
      <NavBar />
      <header className="App-header">
      <img src={cooper_logo} className="App-logo" alt="cooper-logo" />

        <p>
          Enter VIN of vehicle to add to inventory:
        </p>
        <input type="text" onChange={getData}/>
        <button onClick={()=>setPrint(true)}>Submit</button>

        <br></br>
        <button className="button" onClick={App.buttonClicked}>Click to Refresh</button>

        <p>The vehicle for VIN {currentVIN} is</p>
        <div style={{background: `${getRandomColor()}`}}>

        </div>
        {currentVehicleInfo}
        <p></p>
      </header>
    </div>
  );
}

export default App;
