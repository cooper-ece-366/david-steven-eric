import React, { useState } from 'react';
import useInterval from './useInterval';
import react_logo from './react-logo.svg';
import spring_java_logo from './spring-boot-java.jpg';
import './App.css';

function getRandomColor() {
  let colorValues = ["red", "blue", "green"];
  return colorValues[Math.floor(Math.random() * colorValues.length)];
}

function App() {
    const apiUrlPrefix = "http://localhost:8080";
  // const tickers = ['AAPL','AMZN','GOOG','NVDA','INTC','FB','ORCL','NFLX'];
  const vins = ['1FMCU9GD1HUA30879', '3FA6P0LU1KR242602', '3HGGK5H88KM742051', '5YJ3E1EA5JF098290', '1FTEX1E51KKC66386', '1C4RJFLG1HC603078', '3FA6P0LU1KR101755', 'JTMRWRFV7LJ048851', '1G1RE6E42EU111830', 'SADCJ2BN5HA086947', 'KNMAT2MV3JP608780', '5NPD84LF6KH490922', '5npe34af3jh646547', '2hgfc2f78jh564740', '5YFEPRAE7LP054292', '55SWF4KB5GU142000'];

  const [currentVIN, setCurrentVIN] = useState('-');
  const [currentVehicleInfo, setCurrentVehicleInfo] = useState('-');


  const vinDelay = 60000; // in milliseconds


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
      <header className="App-header">
      <img src={react_logo} className="App-logo" alt="react-logo" />
        <img src={spring_java_logo} className="Platform-logo" alt="spring_java_logo" />
        <a
          className="App-link"
          href="https://github.com/cooper-ece-366/exempli-gratia"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn how to spin React with Java & Spring Boot with API endpoints
        </a>
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
