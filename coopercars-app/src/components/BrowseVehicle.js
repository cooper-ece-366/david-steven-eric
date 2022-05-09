import { useState, useEffect } from "react";
import React, {Component} from "react";
import ReactDOM from 'react-dom';
import { default as ReactSelect } from "react-select";
import { components } from "react-select";
//import useInterval from './useInterval';
import coopercars1_logo from '../CooperCars-logos.jpeg';
import coopercars2_logo from '../CooperCars-logos_black.png';
import '../App.css';
import './BrowseVehicle.css'
import NavBar from './NavBar'
import TextField from "@material-ui/core/TextField";
import {
    BrowserRouter as Router,
    Route,
    Link,
    Navigate,
    Routes,
} from "react-router-dom";
import AddVehicle from "./AddVehicle";
import {FormControl, InputLabel, MenuItem, Select} from "@mui/material";
import Button from "@material-ui/core/Button";
export const featureOptions = [
    { value: "ACC", label: "Adaptive Cruise Control" },
    { value: "backupCam", label: "Backup Cam" },
    { value: "LKA", label: "Lane Keep Assist" },
    { value: "crashBrake", label: "Crash Imminent Braking" },
    { value: "parkingAssist", label: "Parking Assist" },
    { value: "anti-lockBraking", label: "Anti-lock Braking" },
    { value: "electronicStabilityControl", label: "Electronic Stability Control" },
    { value: "tractionControl", label: "Traction Control" },
    { value: "autoCrashNotif", label: "Auto Crash Notification" },
    { value: "rearCrossTrafficAlert", label: "Rear Cross Traffic Alert" },
    { value: "rearAutoEmergBraking", label: "Rear Auto Emergency Braking" },
    { value: "forwardCollisionWarning", label: "Forward Collision Warning" },
    { value: "dynamicBrakeSupport", label: "Dynamic Brake Support" },
    { value: "pedestrian", label: "Pedestrian Auto Emergency Braking" },
    { value: "blindSpotWarning", label: "Dynamic Brake Support" },
    { value: "laneDepart", label: "Lane Departure Warning" },
    { value: "blindSpotInter", label: "Blind Spot Intervene" },
    { value: "LCA", label: "Lane Center Assist" },
    { value: "adaptiveDriveBeam", label: "Adaptive Drive Beam" }
];

function BrowseVehicle()
{
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [items, setItems] = useState([]);
    const [q, setQ] = useState("");

    const [searchParam] = useState(["make", "year", "model", "vehicleType"]);
    const [filterParam, setFilterParam] = useState(["All"]);
    const [sortParam, setSortParam] = useState("");
    const [filtParam, setFiltParam] = useState("");
    const [isChecked1, setIsChecked1] = useState(false);
    const [isChecked2, setIsChecked2] = useState(false);
    const [isChecked3, setIsChecked3] = useState(false);
    const [isChecked4, setIsChecked4] = useState(false);
    const [isChecked5, setIsChecked5] = useState(false);

    const[search_query, setSearchQuery] = useState("");
    const[filterType, setFilterType] = useState("All");
    const[filterMake, setFilterMake] = useState("All");
    const[filterYear, setFilterYear] = useState("All");
    const[filterAdaptiveCruiseControl, setFilterAdaptiveCruiseControl] = useState("");
    const[filterBackupCam, setFilterBackupCam] = useState("");
    const[filterLKA, setFilterLKA] = useState("");
    const[filterCrashBrake, setFilterCrashBrake] = useState("");
    const[filterParkAssist, setFilterParkAssist] = useState("");
    const[filterAntiLock, setFilterAntiLock] = useState("");
    const[filterElecStability, setFilterElecStability] = useState("");
    const[filterTracControl, setFilterTracControl] = useState("");
    const[filterAutoCrashNotif, setFilterAutoCrashNotif] = useState("");
    const[filterRearCross, setFilterRearCross] = useState("");
    const[filterRearAutoBrake, setFilterRearAutoBrake] = useState("");
    const[filterForwardCollisionWarning, setFilterForwardCollisionWarning] = useState("");
    const[filterDynamicBrake, setFilterDynamicBrake] = useState("");
    const[filterPedestrian, setFilterPedestrian] = useState("");
    const[filterBlindSpotWarning, setFilterBlindSpotWarning] = useState("");
    const[filterLaneDepart, setFilterLaneDepart] = useState("");
    const[filterBlindSpotInter, setFilterBlindSpotInter] = useState("");
    const[filterLCA, setFilterLCA] = useState("");
    const[filterAdaptiveDriveBeam, setFilterAdaptiveDriveBeam] = useState("");
    const fetchURLSort = "http://localhost:8080/api/vehicles"

    const Option = (props) => {
        return (
            <components.Option{...props}>
                <input
                    //onChange={(e) => {console.log("test");}}
                    type="checkbox"
                    id="query1"
                    checked={props.isSelected}
                    value={props.value}
                    onChange={(e) => {
                        console.log(e.target.value);
                        console.log(props.isSelected);
                        switch(props.value){
                            case "ACC":
                                if(!props.isSelected){
                                    setFilterAdaptiveCruiseControl("Standard");
                                }
                                else{
                                    setFilterAdaptiveCruiseControl("");
                                }
                                break;
                            case "backupCam":
                                if(!props.isSelected){
                                    setFilterBackupCam("Standard");
                                }
                                else{
                                    setFilterBackupCam("");
                                }
                                break;
                            case "LKA":
                                if(!props.isSelected){
                                    setFilterLKA("Standard");
                                }
                                else{
                                    setFilterLKA("");
                                }
                                break;
                            case "crashBrake":
                                if(!props.isSelected){
                                    setFilterCrashBrake("Standard");
                                }
                                else{
                                    setFilterCrashBrake("");
                                }
                                break;
                            case "parkingAssist":
                                if(!props.isSelected){
                                    setFilterParkAssist("Standard");
                                }
                                else{
                                    setFilterParkAssist("");
                                }
                                break;
                            case "anti-LockBraking":
                                if(!props.isSelected){
                                    setFilterAntiLock("Standard");
                                }
                                else{
                                    setFilterAntiLock("");
                                }
                                break;
                            case "electronicStabilityControl":
                                if(!props.isSelected){
                                    setFilterElecStability("Standard");
                                }
                                else{
                                    setFilterElecStability("");
                                }
                                break;
                            case "tractionControl":
                                if(!props.isSelected){
                                    setFilterTracControl("Standard");
                                }
                                else{
                                    setFilterTracControl("");
                                }
                                break;
                            case "autoCrashNotif":
                                if(!props.isSelected){
                                    setFilterAutoCrashNotif("Standard");
                                }
                                else{
                                    setFilterAutoCrashNotif("");
                                }
                                break;
                            case "rearCrossTrafficAlert":
                                if(!props.isSelected){
                                    setFilterRearCross("Standard");
                                }
                                else{
                                    setFilterRearCross("");
                                }
                                break;
                            case "rearAutoEmergBraking":
                                if(!props.isSelected){
                                    setFilterRearAutoBrake("Standard");
                                }
                                else{
                                    setFilterRearAutoBrake("");
                                }
                                break;
                            case "forwardCollisionWarning":
                                if(!props.isSelected){
                                    setFilterForwardCollisionWarning("Standard");
                                }
                                else{
                                    setFilterForwardCollisionWarning("");
                                }
                                break;
                            case "dynamicBrakeSupport":
                                if(!props.isSelected){
                                    setFilterDynamicBrake("Standard");
                                }
                                else{
                                    setFilterDynamicBrake("");
                                }
                                break;
                            case "pedestrian":
                                if(!props.isSelected){
                                    setFilterPedestrian("Standard");
                                }
                                else{
                                    setFilterPedestrian("");
                                }
                                break;
                            case "blindSpotWarning":
                                if(!props.isSelected){
                                    setFilterBlindSpotWarning("Standard");
                                }
                                else{
                                    setFilterBlindSpotWarning("");
                                }
                                break;
                            case "laneDepart":
                                if(!props.isSelected){
                                    setFilterLaneDepart("Standard");
                                }
                                else{
                                    setFilterLaneDepart("");
                                }
                                break;
                            case "blindSpotInter":
                                if(!props.isSelected){
                                    setFilterBlindSpotInter("Standard");
                                }
                                else{
                                    setFilterBlindSpotInter("");
                                }
                                break;
                            case "LCA":
                                if(!props.isSelected){
                                    setFilterLCA("Standard");
                                }
                                else{
                                    setFilterLCA("");
                                }
                                break;
                            case "adaptiveDriveBeam":
                                if(!props.isSelected){
                                    setFilterAdaptiveDriveBeam("Standard");
                                }
                                else{
                                    setFilterAdaptiveDriveBeam("");
                                }
                                break;
                        }
                    }}
                />{" "}
                <label>{props.label}</label>
            </components.Option>
        );
    };
    useEffect(() => {
        BrowseVehicle.handleSort("");
    }, []);

    BrowseVehicle.handleSort = (val) =>{
        var sortURL = fetchURLSort.concat(val);
        console.log(val);
        console.log(sortURL);
        fetch(sortURL)
            .then((res) => res.json())
            .then(
                (result) => {
                    setIsLoaded(true);
                    setItems(result);
                },
                // Note: it's important to handle errors here
                // instead of a catch() block so that we don't swallow
                // exceptions from actual bugs in components.
                (error) => {
                    setIsLoaded(true);
                    setError(error);
                }
            )
            .catch(err => {
                console.log("Cannot connect to API endpoint: %s", sortURL);
            });
                console.log("Refreshed");
    }

    function filterSafetyFeatures(items){
        return items.filter((item) => {
            if(!((filterAdaptiveCruiseControl=="") ||(filterAdaptiveCruiseControl==item.adaptiveCruiseControl))){
                return;
            }
            if(!((filterBackupCam=="") ||(filterBackupCam==item.backupCam))){
                return;
            }
            if(!((filterLKA=="") ||(filterLKA==item.laneKeepAssist))){
                return;
            }
            if(!((filterCrashBrake=="") ||(filterCrashBrake==item.crashImmBraking))){
                return;
            }
            if(!((filterParkAssist=="") ||(filterParkAssist==item.parkingAssist))){
                return;
            }
            if(!((filterAntiLock=="") ||(filterAntiLock==item.antiLockBraking))){
                return;
            }
            if(!((filterElecStability=="") ||(filterElecStability==item.electronicStability))){
                return;
            }
            if(!((filterTracControl=="") ||(filterTracControl==item.tractionControl))){
                return;
            }
            if(!((filterAutoCrashNotif=="") ||(filterAutoCrashNotif==item.autoCrashNotif))){
                return;
            }
            if(!((filterRearCross=="") ||(filterRearCross==item.rearCrossTrafficAlert))){
                return;
            }
            if(!((filterRearAutoBrake=="") ||(filterRearAutoBrake==item.rearAutoEmergBraking))){
                return;
            }
            if(!((filterForwardCollisionWarning=="") ||(filterForwardCollisionWarning==item.forwColliWarn))){
                return;
            }
            if(!((filterDynamicBrake=="") ||(filterDynamicBrake==item.dynamicBrakeSupp))){
                return;
            }
            if(!((filterPedestrian=="") ||(filterPedestrian==item.pedestrianAutoEmergBrak))){
                return;
            }
            if(!((filterBlindSpotWarning=="") ||(filterBlindSpotWarning==item.blindSpotWarn))){
                return;
            }
            if(!((filterLaneDepart=="") ||(filterLaneDepart==item.laneDepartWarn))){
                return;
            }
            if(!((filterBlindSpotInter=="") ||(filterBlindSpotInter==item.blindSpotIntervention))){
                return;
            }
            if(!((filterLCA=="") ||(filterLCA==item.laneCenterAssist))){
                return;
            }
            if(!((filterAdaptiveDriveBeam=="") ||(filterAdaptiveDriveBeam==item.adaptDrivingBeam))){
                return;
            }
            return item;
        });
    }
    function search(items) {
        console.log(items);
        return searchStage2(items.filter((item) => {

            if (item.year==filterYear) {
                return searchParam.some((newItem) => {
                    return (
                        item[newItem]
                            .toString()
                            .toLowerCase()
                            .indexOf(q.toLowerCase()) > -1
                    );
                });
            } else if (filterYear == "All") {
                return searchParam.some((newItem) => {
                    return (
                        item[newItem]
                            .toString()
                            .toLowerCase()
                            .indexOf(q.toLowerCase()) > -1
                    );
                });
            }
        }));
    }
    function searchStage2(items){
        return searchStage3(items.filter((item) => {

            if (item.make==filterMake) {
                return searchParam.some((newItem) => {
                    return (
                        item[newItem]
                            .toString()
                            .toLowerCase()
                            .indexOf(q.toLowerCase()) > -1
                    );
                });
            } else if (filterMake == "All") {
                return searchParam.some((newItem) => {
                    return (
                        item[newItem]
                            .toString()
                            .toLowerCase()
                            .indexOf(q.toLowerCase()) > -1
                    );
                });
            }
        }));
    }
    function searchStage3(items){
        return items.filter((item) => {

            if (item.vehicleType==filterType) {
                return searchParam.some((newItem) => {
                    return (
                        item[newItem]
                            .toString()
                            .toLowerCase()
                            .indexOf(q.toLowerCase()) > -1
                    );
                });
            } else if (filterType == "All") {
                return searchParam.some((newItem) => {
                    return (
                        item[newItem]
                            .toString()
                            .toLowerCase()
                            .indexOf(q.toLowerCase()) > -1
                    );
                });
            }
        });
    }
    if (error) {
        return <>{error.message}</>;
    } else if (!isLoaded) {
        return <>loading...</>;
    } else {
        return (
            /* here we map over the element and display each item as a card  */
            <div className="browse">
                <div className="wrapper">
                    <div>
                        <br></br>
                        <label htmlFor="search-form">
                            <input
                                type="search"
                                name="search-form"
                                id="search-form"
                                className="search-input"
                                placeholder="Search for..."
                                value={q}
                                onChange={(e) => setQ(e.target.value)}
                            />
                            <span className="sr-only">Search for vehicle here</span>
                        </label>
                        <br></br>
                        <FormControl variant="filled" sx={{ m: 1, minWidth: 800 }}>
                            <InputLabel id="demo-simple-select-filled-label">Sort by:</InputLabel>
                            <Select
                                labelId="demo-simple-select-filled-label"
                                id="demo-simple-select-filled"
                                value={sortParam}
                                label="Sort by:"
                                onChange={(e) => {setSortParam(e.target.value); BrowseVehicle.handleSort(e.target.value)}}
                            >
                                <MenuItem value={""}>None</MenuItem>
                                <MenuItem value={"/sort/dealer-asc"}>Dealer Price: Low to High</MenuItem>
                                <MenuItem value={"/sort/dealer-desc"}>Dealer Price: High to low</MenuItem>
                                <MenuItem value={"/sort/sale-asc"}>Sale Price: Low to High</MenuItem>
                                <MenuItem value={"/sort/sale-desc"}>Sale Price: High to low</MenuItem>
                                <MenuItem value={"/sort/profit-asc"}>Profit: Low to High</MenuItem>
                                <MenuItem value={"/sort/profit-desc"}>Profit: High to low</MenuItem>
                                <MenuItem value={"/sort/date-asc"}>Date Entered: Low to High</MenuItem>
                                <MenuItem value={"/sort/date-desc"}>Date Entered: High to low</MenuItem>
                                <MenuItem value={"/sort/mileage-asc"}>Mileage: Low to High</MenuItem>
                                <MenuItem value={"/sort/mileage-desc"}>Mileage: High to low</MenuItem>
                                <MenuItem value={"/sort/year-asc"}>Model Year: Low to High</MenuItem>
                                <MenuItem value={"/sort/year-desc"}>Model Year: High to low</MenuItem>
                                <MenuItem value={"/sort/make-asc"}>Make: A to Z</MenuItem>
                                <MenuItem value={"/sort/make-desc"}>Make: Z to A</MenuItem>
                                <MenuItem value={"/sort/model-asc"}>Model: A to Z</MenuItem>
                                <MenuItem value={"/sort/model-desc"}>Model: Z to A</MenuItem>
                            </Select>
                        </FormControl>
                        <div className="select" >
                            <select
                                onChange={(e) => {
                                    setFilterType(e.target.value);
                                }}
                                className="custom-select"
                                aria-label="Filter Vehicles by Type"
                            >
                                <option value="All">Filter By Type</option>
                                <option value="PASSENGER CAR">Passenger Car</option>
                                <option value="MULTIPURPOSE PASSENGER VEHICLE (MPV)">Multipurpose Passenger Vehicle</option>
                                <option value="TRUCK ">Truck</option>
                            </select>
                            <span className="focus"></span>
                        </div>
                        <div className="select">
                            <select
                                onChange={(e) => {
                                    setFilterMake(e.target.value);
                                }}
                                className="custom-select"
                                aria-label="Filter Vehicles by Manufacturer"
                            >
                                <option value="All">Filter By Make</option>
                                <option value="BUICK">Buick</option>
                                <option value="CHEVROLET">Chevrolet</option>
                                <option value="FORD">Ford</option>
                                <option value="HONDA">Honda</option>
                                <option value="HYUNDAI">Hyundai</option>
                                <option value="JAGUAR">Jaguar</option>
                                <option value="JEEP">Jeep</option>
                                <option value="LINCOLN">Lincoln</option>
                                <option value="MERCEDES-BENZ">Mercedes-Benz</option>
                                <option value="NISSAN">Nissan</option>
                                <option value="TESLA">Tesla</option>
                                <option value="TOYOTA">Toyota</option>
                            </select>
                            <span className="focus"></span>
                        </div>
                        <div className="select">
                            <select
                                onChange={(e) => {
                                    setFilterYear(e.target.value);
                                }}
                                className="custom-select"
                                aria-label="Filter Vehicles by Year"
                            >
                                <option value="All">Filter By Year</option>
                                <option value="2010">2010</option>
                                <option value="2011">2011</option>
                                <option value="2012">2012</option>
                                <option value="2013">2013</option>
                                <option value="2014">2014</option>
                                <option value="2015">2015</option>
                                <option value="2016">2016</option>
                                <option value="2017">2017</option>
                                <option value="2018">2018</option>
                                <option value="2019">2019</option>
                                <option value="2020">2020</option>
                                <option value="2021">2021</option>
                            </select>
                            <span className="focus"></span>
                        </div>
                        <ReactSelect
                            options={featureOptions}
                            isMulti
                            closeMenuOnSelect={false}
                            hideSelectedOptions={false}
                            components={{
                                Option
                            }}
                            //onChange={this.handleChange}
                            // allowSelectAll={true}
                            //value={this.state.optionSelected}

                        />

                    </div>
                    <ul className="card-grid">
                        {search(filterSafetyFeatures(items)).map((item) => {
                            var myLink = item.vin
                            return (
                                <li>
                                    <div className="card-content">
                                        <Link to={myLink}>
                                            <h4 className="card-name">{item.vin}</h4>
                                            <div className="car-image">
                                                <img src={item.imgURL} alt={item.vin}/>
                                            </div>
                                        </Link>
                                        <ol className="card-list">
                                            <li>
                                                <h6><span>{item.year + " " + item.make +  " " +item.model}</span></h6>
                                            </li>
                                            <li>
                                                <b>Dealer Price:</b> $<span>{item.dealerPrice}</span>
                                            </li>
                                            <li>
                                                <b>Sale Price:</b> $<span>{item.salePrice}</span>
                                            </li>
                                            <li>
                                                <b>Profit:</b> $<span>{item.profit}</span>
                                            </li>
                                            <li>
                                                <b>Mileage:</b> <span>{item.mileage}</span>
                                            </li>
                                            <li>
                                                <b>Date Entered:</b> <span>{item.enteredDate}</span>
                                            </li>
                                            <li>
                                                <b>Status:</b> <span>{item.status}</span>
                                            </li>
                                        </ol>
                                    </div>
                                </li>
                            );
                        })}
                    </ul>
                </div></div>
        );
    }
}

ReactDOM.render(<BrowseVehicle />, document.getElementById("root"));
export default BrowseVehicle;