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
    console.log(VIN);

    return (
        <div className="App">
            <NavBar />
            <header className="App-header">

                <p>Vehicle details for VIN {VIN} </p>
            </header>
        </div>
    );
}

export default VehicleDetails;