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
import Login from "./components/Login";

function getRandomColor() {
  let colorValues = ["red", "blue", "green"];
  return colorValues[Math.floor(Math.random() * colorValues.length)];
}

function App() {


  //const vins = ['1FMCU9GD1HUA30879', '3FA6P0LU1KR242602', '3HGGK5H88KM742051', '5YJ3E1EA5JF098290', '1FTEX1E51KKC66386', '1C4RJFLG1HC603078', '3FA6P0LU1KR101755', 'JTMRWRFV7LJ048851', '1G1RE6E42EU111830', 'SADCJ2BN5HA086947', 'KNMAT2MV3JP608780', '5NPD84LF6KH490922', '5npe34af3jh646547', '2hgfc2f78jh564740', '5YFEPRAE7LP054292', '55SWF4KB5GU142000'];



  return (

    <div className="App">
        <Router>
            <Routes>
                <Route path='/' element = { <HomePage/>}/>
                <Route path='/browse' element = { <BrowseVehicle/>}/>
                <Route path='/addVehicle' element = { <AddVehicle/>}/>
                <Route path='/login' element = {<Login/>}/>
            </Routes>
        </Router>

    </div>
  );
}

export default App;
