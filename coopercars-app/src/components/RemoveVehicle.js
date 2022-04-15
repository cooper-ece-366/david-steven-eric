import React, { useState } from 'react';
import coopercars1_logo from '../CooperCars-logos.jpeg';
import coopercars2_logo from '../CooperCars-logos_black.png';
import '../App.css';
import NavBar from './NavBar'
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";

function RemoveVehicle()
{
    const apiUrlPrefix = "http://localhost:8080";

    const [vin, setVin] = useState("");


    RemoveVehicle.refreshVehicleInfo = (vin) =>
    {

        var vehicleApiUrl = apiUrlPrefix.concat("/api/vehicle/remove/",vin);
        fetch(vehicleApiUrl)
            .then(response => response.json())
            .catch(err => {
                console.log("Vehicle no longer exists: %s", vehicleApiUrl);
            });
    }


    RemoveVehicle.buttonClicked = () =>
    {
        console.log('Button was clicked!');
        RemoveVehicle.refreshVehicleInfo(vin);
    }

    return (
        <div className="App">
            <NavBar />
            <header className="App-header">
                <p>
                    Enter VIN to remove from Inventory:
                </p>
                <TextField
                    id="filled-basic"
                    label="Enter VIN"
                    variant="filled"
                    style={{background: "rgb(232, 241, 250)"}}
                    onChange={(e) => setVin(e.target.value)}
                    value={vin}
                />
                <Button variant="contained" className="button" onClick={RemoveVehicle.buttonClicked}>Submit</Button>

                </header>
        </div>
    );
}

export default RemoveVehicle;