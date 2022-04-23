import React, {useEffect, useState} from 'react';
import coopercars1_logo from '../CooperCars-logos.jpeg';
import coopercars2_logo from '../CooperCars-logos_black.png';
import '../App.css';
import NavBar from './NavBar'
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import * as XLSX from 'xlsx';


function AddVehicle()
{
    const apiUrlPrefix = "http://localhost:8080";
    const [file, setFile] = useState(null);
    const [currentVIN, setCurrentVIN] = useState("");
    const [currentVehicleInfo, setCurrentVehicleInfo] = useState("");
    const [currentVehicleInfo1, setCurrentVehicleInfo1] = useState("");
    const [uploadMsg, setUploadMsg] = useState("");
    const [currentVehicleImg, setCurrentVehicleImg] = useState(null);
    const [currentVehicleFeatures1, setCurrentVehicleFeatures1] = useState("");
    const [currentVehicleFeatures2, setCurrentVehicleFeatures2] = useState("");
    const [currentVehicleFeatures3, setCurrentVehicleFeatures3] = useState("");
    const [currentVehicleFeatures4, setCurrentVehicleFeatures4] = useState("");
    const [currentVehicleFeatures5, setCurrentVehicleFeatures5] = useState("");
    const [vin, setVin] = useState("");
    const [salePrice, setSalePrice] = useState("");
    const [dealerPrice, setDealerPrice] = useState("");
    const [vinXlsx, setVinXlsx] = useState("");
    const [salePriceXlsx, setSalePriceXlsx] = useState("");
    const [dealerPriceXlsx, setDealerPriceXlsx] = useState("");

    AddVehicle.buttonClicked = () =>
    {
        console.log('Button was clicked!');
        AddVehicle.addVehicle();
    }

    AddVehicle.onFileChange = () => {
        console.log('File loaded');
    }
    AddVehicle.handleSubmit = () =>{
        setUploadMsg(file.name + " successfully uploaded!");
        console.log('Button was clicked!');
        console.log('File name: '+ file.name);
        const reader = new FileReader();
        reader.onload = (evt) => { // evt = on_file_select event
            /* Parse data */
            const bstr = evt.target.result;
            const wb = XLSX.read(bstr, {type: 'binary'});
            /* Get first worksheet */
            const wsname = wb.SheetNames[0];
            const ws = wb.Sheets[wsname];
            /* Convert array of arrays */
            const data = XLSX.utils.sheet_to_csv(ws, {header: 1});
            /* Update state */
            console.log("Data>>> \n" + data);
            var sheet = wb.Sheets[wb.SheetNames[0]];
            /* loop through every cell manually */
            var range = XLSX.utils.decode_range(sheet['!ref']); // get the range
            for(var R = range.s.r; R <= range.e.r; ++R) {
                var vi = null;
                var dealer = null;
                var sale = null;
                for (var C = range.s.c; C <= range.e.c; ++C) {
                    /* find the cell object */
                    console.log('Row : ' + R);
                    console.log('Column : ' + C);
                    var cellref = XLSX.utils.encode_cell({c: C, r: R}); // construct A1 reference for cell
                    if (!sheet[cellref]) continue; // if cell doesn't exist, move on
                    var cell = sheet[cellref];

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
                }

                console.log(vi + ", " + dealer + ", " + sale);
                //addVehicleXlsx(vi, dealer, sale);
                setVin(vi);
                setCurrentVIN(vi);
                setDealerPrice(dealer);
                setSalePrice(sale);
                AddVehicle.addVehicle();

            }
        }
        reader.readAsBinaryString(file);
    }


    AddVehicle.addVehicle = () =>
    {
        const requestOptions = {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
                vin,
                dealerPrice,
                salePrice,
            }),
        };
        fetch("http://localhost:8080/api/vehicle/addvehicle", requestOptions)
            .then((response) => console.log(response))
            .then((data) => console.log(data))
            .then(()=>AddVehicle.refreshInfo());
    }


    // function addVehicleXlsx()
    // {
    //     const requestOptionsXlsx = {
    //         method: "POST",
    //         headers: { "Content-Type": "application/json" },
    //         body: JSON.stringify({
    //             vinXlsx,
    //             dealerPriceXlsx,
    //             salePriceXlsx,
    //         }),
    //     };
    //     fetch("http://localhost:8080/api/vehicle/addvehicle", requestOptionsXlsx)
    //         .then((response) => console.log(response))
    //         .then((data) => console.log(data))
    // }

    AddVehicle.refreshInfo = () =>
    {
        console.log("Refreshing ... %s vehicle ...", currentVIN);
        var vehicleApiUrl = apiUrlPrefix.concat("/api/vehicle/getinfo/",vin);
        fetch(vehicleApiUrl)
            .then(response => response.json())
            .then(data => {
                setCurrentVehicleImg(data.imgURL);
                setCurrentVehicleInfo("VIN: " + data.vin)
                setCurrentVehicleInfo1(data.year + " " + data.make + " " + data.model + " " + data.trim + " " + data.series);
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

    return (
        <div className="App">
            <NavBar />
            <header className="App-header">
                <br></br>
                <div>
                    <h3>Upload Spreadsheet (VIN, Dealer Price, Sale Price)</h3>
                    <input type="file" onChange={(e) => setFile(e.target.files[0])}/>
                    <button variant="contained" className="button" onClick = {AddVehicle.handleSubmit}>Upload</button>
                </div>
                <br></br>
                {uploadMsg}
                <br></br><br></br>
                <p>
                    Or manually enter VIN, dealer price, sale price of vehicle to add to inventory:
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
                <Button variant="contained" className="button" onClick={AddVehicle.buttonClicked}>Submit</Button>

                <br></br>

                {/*<p>The vehicle for VIN {vin} is </p>*/}
                {currentVehicleInfo}<br></br>
                {currentVehicleInfo1}<br></br>
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