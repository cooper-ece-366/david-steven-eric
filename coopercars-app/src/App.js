import React, { useState } from 'react';
//import useInterval from './useInterval';
import coopercars1_logo from './CooperCars-logos.jpeg';
import coopercars2_logo from './CooperCars-logos_black.png';
import './App.css';
import NavBar from './components/NavBar'
import TextField from "@material-ui/core/TextField";
import {
  BrowserRouter as Router,
  Route,
  Link,
  Navigate,
  Routes,
} from "react-router-dom";
import HomePage from "./components/HomePage";
import BrowseVehicle from "./components/BrowseVehicle";
import AddVehicle from "./components/AddVehicle";
import RemoveVehicle from "./components/RemoveVehicle";
import VehicleDetails from "./components/VehicleDetails";
import Login, {Register} from "./components/Login";

function getRandomColor() {
  let colorValues = ["red", "blue", "green"];
  return colorValues[Math.floor(Math.random() * colorValues.length)];
}

function App() {


  return (

    <div className="App">
        <Router>
            <Routes>
                <Route path='/' element = { <HomePage/>}/>
                <Route path='/browse' element = { <BrowseVehicle/>}/>
                <Route path='/browse/:VIN' element = { <VehicleDetails/>}/>
                <Route path='/addVehicle' element = { <AddVehicle/>}/>
                <Route path='/removeVehicle' element = { <RemoveVehicle/>}/>
                <Route path='/login' element= {<Login/>}/>
                <Route path='/register' element= {<Register/>}/>
            </Routes>
        </Router>

    </div>
  );
}

export default App;
