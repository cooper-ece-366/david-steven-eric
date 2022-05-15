import React, { useState } from 'react';
import 'animate.css';
import '../App.css';
import logo from "../CooperCars-logos_white.png";
import car from "../city-car.svg";

//File edited by: David, Steven

function HomePage() {
  const apiUrlPrefix = "http://localhost:8080";

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

      <h1 className="animate__animated animate__fadeOutRight animate__delay-1s">
        <img src={car} className="App-logo" alt="cooper-logo" height = "800" width = "400"/>
      </h1>
      <h1 className="animate__animated animate__fadeInLeft animate__delay-2s">
        <img src={logo} className="App-logo" alt="cooper-logo" height = "800" width = "400"/>
      </h1>
        <p className="animate__animated animate__fadeInLeft animate__delay-2s">
          Welcome to CooperCars!
        </p>
        <p className="animate__animated animate__fadeInLeft animate__delay-2s">
          A vehicle inventory management solution for your small car dealership! Sign in to get started.
        </p>

      </header>
    </div>
  );
}

export default HomePage;
