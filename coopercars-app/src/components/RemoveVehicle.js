import React, {useEffect, useState} from 'react';
import coopercars1_logo from '../CooperCars-logos.jpeg';
import coopercars2_logo from '../CooperCars-logos_black.png';
import '../App.css';
import NavBar from './NavBar'
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import * as XLSX from "xlsx";
import {FormControl, InputLabel, MenuItem, Select} from "@mui/material";
import { ACCESS_TOKEN } from '../constants';

//File edited by: Steven, David, Eric
// Initial API call setup by Eric
// Securing API calls by Steven
// Excel parsing by David

function wait(ms){
    var start = new Date().getTime();
    var end = start;
    while(end < start + ms) {
        end = new Date().getTime();
    }
}
function RemoveVehicle()
{
    const apiUrlPrefix = "http://localhost:8080";

    const [file, setFile] = useState(null);
    const [vin, setVin] = useState("");
    const [status,setStatus] = useState("");
    const [info, setInfo] = useState("");

    useEffect(() => {
    }, []);


    // Excel parsing by David
    //Use XLSX to parse spreadsheet row by row and get parameters from each column for constructing a vehicle object
    RemoveVehicle.handleSubmit = () =>{
        console.log('Button was clicked!');
        console.log('File name: '+ file.name);
        var size = file.size;
        console.log('File size:' + file.size);
        const reader = new FileReader();
        reader.onload = (evt) => {
            const bstr = evt.target.result;
            const wb = XLSX.read(bstr, {type: 'binary'});
            const wsname = wb.SheetNames[0];
            const ws = wb.Sheets[wsname];
            const data = XLSX.utils.sheet_to_csv(ws, {header: 1});
            console.log("Data>>> \n" + data);
            var sheet = wb.Sheets[wb.SheetNames[0]];
            var range = XLSX.utils.decode_range(sheet['!ref']);
            for(var R = range.s.r; R <= range.e.r; ++R) {
                var vi = null;
                var dealer = null;
                var sale = null;
                for (var C = range.s.c; C <= range.e.c; ++C) {
                    console.log('Row : ' + R);
                    console.log('Column : ' + C);
                    var cellref = XLSX.utils.encode_cell({c: C, r: R});
                    if (!sheet[cellref]) continue;
                    var cell = sheet[cellref];
                    //Determine parameter type based on current column
                    if(C==0){
                        vi = cell.v;
                        console.log("VIN: " + vi);
                    }
                }
                console.log(vi);

                setVin(vi);
                RemoveVehicle.removeVehicle();

            }
        }
        reader.readAsBinaryString(file);
        alert("Vehicles are being removed from inventory... this will take a moment. Another popup will appear when task is completed.");
        wait(size+1000);
        alert("Vehicles removed successfully!");
    }

    // API calls by Eric
    // Securing API calls by Steven
    RemoveVehicle.removeVehicle = () =>
    {
        const authorization = "Bearer " + localStorage.getItem(ACCESS_TOKEN)

        const requestOptions = {
            method: "DELETE",
            headers: { "Authorization": authorization}
        };
        var vehicleApiUrl = apiUrlPrefix.concat("/api/vehicle/remove/",vin);
        fetch(vehicleApiUrl,requestOptions)
                .then((response) =>
                {

                    alert("Successfully deleted VIN " + vin);
                    setInfo("Vehicle "+vin+" removed.")
                })
    }


    RemoveVehicle.removeVehicleStatus = () =>
    {
        const authorization = "Bearer " + localStorage.getItem(ACCESS_TOKEN)

        const requestOptions = {
            method: "DELETE",
            headers: { "Authorization": authorization}
        };
        var vehicleApiUrl = apiUrlPrefix.concat("/api/vehicle/remove/status/", status);
        fetch(vehicleApiUrl,requestOptions)
            .then((response) =>
            {
                alert("Succesfully deleted " + (status));
                setInfo("Vehicles marked as sold removed.")
            })
        // .catch(err => {
        //     setStatus("Vehicle does not exist.")
        // });
    }

    RemoveVehicle.buttonClicked = () =>
    {
        console.log('Button was clicked!');
        RemoveVehicle.removeVehicle(vin);
    }

    // David, Eric
    return (
        <div className="App">
            <header className="App-header">
                <br></br>
                <div>
                    <h1>Upload Spreadsheet to remove from inventory (VIN)</h1>
                    <input type="file" onChange={(e) => setFile(e.target.files[0])}/>
                    <button variant="contained" className="button" onClick = {RemoveVehicle.handleSubmit}>Upload</button>
                </div>
                <br></br>
                <p>
                    Or, enter VIN to remove from Inventory:
                </p>
                <TextField
                    id="filled-basic"
                    label="Enter VIN"
                    variant="filled"
                    style={{background: "rgb(232, 241, 250)"}}
                    onChange={(e) => setVin(e.target.value)}
                    value={vin}
                />
                <Button variant="contained" className="button" onClick={RemoveVehicle.buttonClicked}>Delete Vehicle</Button>
                {/*{info}*/}
                <br></br>

                <p>
                    Or, remove from inventory by status (default is sold):
                </p>
                <FormControl variant="filled" sx={{ m: 1, minWidth: 210 }}>
                    <InputLabel id="demo-simple-select-filled-label">Status</InputLabel>
                    <Select
                        style={{background: "rgb(232, 241, 250)"}}
                        displayEmpty
                        labelId="demo-simple-select-filled-label"
                        id="demo-simple-select-filled"
                        value={status}
                        label="Status"
                        onChange={(e) => setStatus(e.target.value)}
                    >
                        <MenuItem value={"Sold"}>Sold</MenuItem>
                        <MenuItem value={"For sale"}>For sale</MenuItem>
                        <MenuItem value={"In-transit"}>In-transit</MenuItem>
                    </Select>
                </FormControl>
                <div>
                    <Button variant="contained" className="button" onClick={RemoveVehicle.removeVehicleStatus}>Remove Vehicle by Status</Button>
                </div>
                <br></br>
                <br></br>
                <br></br>
                <br></br>
            </header>
        </div>
    );
}

export default RemoveVehicle;