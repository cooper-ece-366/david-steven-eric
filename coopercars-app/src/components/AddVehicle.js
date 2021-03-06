import React, { useState } from 'react';
import '../App.css';
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import * as XLSX from 'xlsx';
import { FormControl } from '@mui/material';
import { InputLabel } from '@mui/material';
import { Select } from '@mui/material';
import { MenuItem } from '@mui/material';
import Alert from 'react-s-alert';
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

function AddVehicle()
{
    const apiUrlPrefix = "http://localhost:8080";
    const [file, setFile] = useState(null);
    const [currentVIN, setCurrentVIN] = useState("");
    const [currentVehicleInfo, setCurrentVehicleInfo] = useState("");
    const [currentVehicleImg, setCurrentVehicleImg] = useState(null);
    const [currentVehicleFeatures1, setCurrentVehicleFeatures1] = useState("");
    const [currentVehicleFeatures2, setCurrentVehicleFeatures2] = useState("");
    const [currentVehicleFeatures3, setCurrentVehicleFeatures3] = useState("");
    const [currentVehicleFeatures4, setCurrentVehicleFeatures4] = useState("");
    const [currentVehicleFeatures5, setCurrentVehicleFeatures5] = useState("");
    const [vin, setVin] = useState("");
    const [salePrice, setSalePrice] = useState("");
    const [dealerPrice, setDealerPrice] = useState("");
    const [mileage, setMileage] = useState("");
    const [status, setStatus] = useState("");

    AddVehicle.buttonClicked = () =>
    {
        console.log('Button was clicked!');
        AddVehicle.addVehicle();

    }

    AddVehicle.onFileChange = () => {
        console.log('File loaded');
    }

    //Excel parsing by David
    //Use XLSX to parse spreadsheet row by row and get parameters from each column for constructing a vehicle object
    AddVehicle.handleSubmit = () => {
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
                var mile = null;
                var stat = null;
                for (var C = range.s.c; C <= range.e.c; ++C) {
                    console.log('Row : ' + R);
                    console.log('Column : ' + C);
                    var cellref = XLSX.utils.encode_cell({c: C, r: R});
                    if (!sheet[cellref]) continue; // if cell doesn't exist, move on
                    var cell = sheet[cellref];
                    //Determine parameter type based on current column
                    if(C==0){
                        vi = cell.v;
                        console.log("VIN: " + vi);
                    }
                    else if(C==1){
                        dealer = cell.v;
                        console.log("Dealer Price: " + dealer);
                    }
                    else if(C==2){
                        sale = cell.v;
                        console.log("Sale Price: " + sale);
                    }
                    else if(C==3){
                        mile = cell.v;
                        console.log("Mileage: " + mile);
                    }
                    else if(C==4){
                        stat = cell.v;
                        console.log("Status: " + stat);
                    }
                }
                console.log(vi + ", " + dealer + ", " + sale + "," + stat + "," + mile);
                //addVehicleXlsx(vi, dealer, sale);
                setVin(vi);
                setCurrentVIN(vi);
                setDealerPrice(dealer);
                setSalePrice(sale);
                setMileage(mile);
                setStatus(stat);
                AddVehicle.addVehicle();

            }
        }
        reader.readAsBinaryString(file);
        alert("Vehicles are being added to inventory... this will take a moment. Another popup will appear when task is completed.");
        wait(size+5000);
        alert("Vehicles added successfully!");

    }

    // API calls by Eric
    // Securing API calls by Steven
    AddVehicle.addVehicle = () =>
    {
        const authorization = "Bearer " + localStorage.getItem(ACCESS_TOKEN)
        const requestOptions = {
            method: "POST",
            headers: { "Content-Type": "application/json", "Authorization" : authorization },
            body: JSON.stringify({
                vin,
                dealerPrice,
                salePrice,
                mileage,
                status,
            }),
        };
        fetch("http://localhost:8080/api/vehicle/addvehicle", requestOptions)
            .then((response) => console.log(response))
            .then((data) => console.log(data))
            .then(()=>AddVehicle.refreshInfo());
    }

    function addVehicleXlsx(myVin,myDealerPrice,mySalePrice)
    {
        const authorization = "Bearer " + localStorage.getItem(ACCESS_TOKEN)

        const requestOptions = {
            method: "POST",
            headers: { "Content-Type": "application/json", "Authorization" : authorization },
            body: JSON.stringify({
                myVin,
                myDealerPrice,
                mySalePrice,
            }),
        };
        fetch("http://localhost:8080/api/vehicle/addvehicle", requestOptions)
            .then((response) => console.log(response))
            .then((data) => console.log(data))
            .then(()=>AddVehicle.refreshInfo());
    }

    // Eric, David
    AddVehicle.refreshInfo = () =>
    {
        console.log("Refreshing ... %s vehicle ...", currentVIN);
        var vehicleApiUrl = apiUrlPrefix.concat("/api/vehicle/getinfo/",vin);
        const token = localStorage.getItem(ACCESS_TOKEN)
        const authorization = "Bearer " + token
        const requestOptions = {
          method: "GET",
          headers: { "Authorization": authorization},
        };
        fetch(vehicleApiUrl, requestOptions)
            .then(response => response.json())
            .then(data => {
                setCurrentVehicleImg(data.imgURL);
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


    // David, Eric
    return (
        <div className="App">
            <header className="App-header">
                <br></br>
                <div>
                    <h1>Upload Spreadsheet (VIN, Dealer Price, Sale Price, Mileage, Status)</h1>
                    <input type="file" onChange={(e) => setFile(e.target.files[0])}/>
                    <button variant="contained" className="button" onClick = {AddVehicle.handleSubmit}>Upload</button>
                </div>
                <br></br>
                <p>
                    Or, manually enter details of the vehicle to add to inventory:
                </p>
                <TextField
                    id="filled-basic"
                    label="Enter VIN"
                    variant="filled"
                    style={{background: "rgb(232, 241, 250)"}}
                    onChange={(e) => setVin(e.target.value)}
                    value={vin}
                />
                <TextField
                    id="filled-basic"
                    label="Enter dealer price"
                    variant="filled"
                    style={{background: "rgb(232, 241, 250)"}}
                    onChange={(e) => setDealerPrice(e.target.value)}
                    value={dealerPrice}

                />
                <TextField
                    id="filled-basic"
                    label="Enter sale price"
                    variant="filled"
                    style={{background: "rgb(232, 241, 250)"}}
                    onChange={(e) => setSalePrice(e.target.value)}
                    value={salePrice}
                />

                <TextField
                    id="filled-basic"
                    label="Enter mileage"
                    variant="filled"
                    style={{background: "rgb(232, 241, 250)"}}
                    onChange={(e) => setMileage(e.target.value)}
                    value={mileage}
                />

                <FormControl variant="filled" sx={{ m: 1, minWidth: 218 }}>
                    <InputLabel id="demo-simple-select-filled-label">Status</InputLabel>
                    <Select
                        style={{background: "rgb(232, 241, 250)"}}
                        labelId="demo-simple-select-filled-label"
                        id="demo-simple-select-filled"
                        value={status}
                        label="Status"
                        onChange={(e) => setStatus(e.target.value)}
                    >
                        <MenuItem value={"For sale"}>For sale</MenuItem>
                        <MenuItem value={"In-transit"}>In-transit</MenuItem>
                        <MenuItem value={"Sold"}>Sold</MenuItem>
                    </Select>
                </FormControl>
                <Button variant="contained" className="button" onClick={AddVehicle.buttonClicked}>Submit</Button>

                <br></br>

                {currentVehicleInfo}<br></br>
                <div className="car-image">
                    <img src={currentVehicleImg} height="100"/>
                </div>
                {currentVehicleFeatures1}<br></br>
                {currentVehicleFeatures2}<br></br>
                {currentVehicleFeatures3}<br></br>
                {currentVehicleFeatures4}<br></br>
                {currentVehicleFeatures5}<br></br>
            </header>
        </div>
    );
}

export default AddVehicle;