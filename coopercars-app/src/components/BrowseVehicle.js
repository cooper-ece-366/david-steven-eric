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
    { value: "backupCam", label: "Backup Cam" },
    { value: "ACC", label: "Adaptive Cruise Control" },
    { value: "LKA", label: "Lane Keep Assist" },
    { value: "crashBrake", label: "Crash Imminent Braking" },
    { value: "parkingAssist", label: "Parking Assist" },
];

function BrowseVehicle()
{
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [items, setItems] = useState([]);
    const [q, setQ] = useState("");

    const [searchParam] = useState(["make", "year", "type"]);
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
    const[filterBackupCam, setFilterBackupCam] = useState("");
    const[filterAdaptiveCruiseControl, setFilterAdaptiveCruiseControl] = useState("");
    const[filterLKA, setFilterLKA] = useState("");
    const[filterCrashBrake, setFilterCrashBrake] = useState("");
    const[filterParkAssist, setFilterParkAssist] = useState("");
    const fetchURLSort = "http://localhost:8080/api/vehicles"
    //Source: https://medium.com/geekculture/creating-multi-select-dropdown-with-checkbox-in-react-792ff2464ef3

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
                            case "backupCam":
                                console.log("Option 1");
                                if(!props.isSelected){
                                    console.log("Filter 1 applied");
                                    setFilterBackupCam("Standard");
                                }
                                else{
                                    console.log("Filter 1 deapplied");
                                    setFilterBackupCam("");
                                }
                                break;
                            case "ACC":
                                console.log("Option 2");
                                if(!props.isSelected){
                                    console.log("Filter 2 applied");
                                    setFilterAdaptiveCruiseControl("Standard");
                                }
                                else{
                                    console.log("Filter 2 deapplied");
                                    setFilterAdaptiveCruiseControl("");
                                }
                                break;
                            case "LKA":
                                console.log("Option 3");
                                if(!props.isSelected){
                                    console.log("Filter 3 applied");
                                    setFilterLKA("Standard");
                                }
                                else{
                                    console.log("Filter 3 deapplied");
                                    setFilterLKA("");
                                }
                                break;
                            case "crashBrake":
                                console.log("Option 4");
                                if(!props.isSelected){
                                    console.log("Filter 4 applied");
                                    setFilterCrashBrake("Standard");
                                }
                                else{
                                    console.log("Filter 4 deapplied");
                                    setFilterCrashBrake("");
                                }
                                break;
                            case "parkingAssist":
                                console.log("Option 5");
                                if(!props.isSelected){
                                    console.log("Filter 5 applied");
                                    setFilterParkAssist("Standard");
                                }
                                else{
                                    console.log("Filter 5 deapplied");
                                    setFilterParkAssist("");
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

    function parkAssistFilter(items){
        if(filterParkAssist==""){
            return items;
        }
        return items.filter((item) => {
            if(item.parkingAssist==filterParkAssist){
                return item;
            }
        });
    }
    function crashBrakeFilter(items){
        if(filterCrashBrake==""){
            return parkAssistFilter(items);
        }
        return parkAssistFilter(items.filter((item) => {
            if(item.crashImmBraking==filterCrashBrake){
                return item;
            }
        }));
    }
    function laneKeepAssistFilter(items){
        if(filterLKA==""){
            return crashBrakeFilter(items);
        }
        return crashBrakeFilter(items.filter((item) => {
            if(item.laneKeepAssist==filterLKA){
                return item;
            }
        }));
    }
    function adaptiveCruiseControlFilter(items){
        if(filterAdaptiveCruiseControl==""){
            return laneKeepAssistFilter(items);
        }
        return laneKeepAssistFilter(items.filter((item) => {
            if(item.adaptiveCruiseControl==filterAdaptiveCruiseControl){
                return item;
            }
        }));
    }
    function backupCamFilter(items){
        if(filterBackupCam==""){
            return adaptiveCruiseControlFilter(items);
        }
        return adaptiveCruiseControlFilter(items.filter((item) => {
            if(item.backupCam==filterBackupCam){
                return item;
                {/*
                return searchParam.some((newItem) => {
                    return (
                        item[newItem]
                            .toString()
                            .toLowerCase()
                            .indexOf(q.toLowerCase()) > -1
                    );
                });*/}
            }
        }));
    }
    function search(items) {
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

                        {/*
                        <div className="filter-query">
                            <input
                                type="checkbox"
                                id="query1"
                                checked={isChecked2}
                                onChange={(e) => {
                                    setIsChecked2(!isChecked2);
                                    if(!isChecked2){
                                        console.log("2 Checked");
                                        setFilterAdaptiveCruiseControl("Standard");
                                    }
                                    else{
                                        console.log("2 Unchecked");
                                        setFilterAdaptiveCruiseControl("");
                                    }
                                }}
                            />
                            <label>
                                Adaptive Cruise Control Standard
                            </label>
                        </div>
                        <div className="filter-query">
                            <input
                                type="checkbox"
                                id="query2"
                                checked={isChecked1}
                                onChange={(e) => {
                                    setIsChecked1(!isChecked1);
                                    if(!isChecked1){
                                        console.log("1 Checked");
                                        setFilterBackupCam("Standard");
                                    }
                                    else{
                                        console.log("1 Unchecked");
                                        setFilterBackupCam("");
                                    }
                                }}
                            />
                            <label>
                                Backup Cam Standard
                            </label>
                        </div>
                        <div className="filter-query">
                            <input
                                type="checkbox"
                                id="query3"
                                checked={isChecked3}
                                onChange={(e) => {
                                    setIsChecked3(!isChecked3);
                                    if(!isChecked3){
                                        console.log("3 Checked");
                                        setFilterLKA("Standard");
                                    }
                                    else{
                                        console.log("3 Unchecked");
                                        setFilterLKA("");
                                    }
                                }}
                            />
                            <label>
                                Lane Keep Assist Standard
                            </label>
                        </div>
                        <div className="filter-query">
                            <input
                                type="checkbox"
                                id="query4"
                                checked={isChecked4}
                                onChange={(e) => {
                                    setIsChecked4(!isChecked4);
                                    if(!isChecked4){
                                        console.log("4 Checked");
                                        setFilterCrashBrake("Standard");
                                    }
                                    else{
                                        console.log("4 Unchecked");
                                        setFilterCrashBrake("");
                                    }
                                }}
                            />
                            <label>
                                Crash Imminent Braking Standard
                            </label>
                        </div>
                        <div className="filter-query">
                            <input
                                type="checkbox"
                                id="query5"
                                checked={isChecked5}
                                onChange={(e) => {
                                    setIsChecked5(!isChecked5);
                                    if(!isChecked5){
                                        console.log("5 Checked");
                                        setFilterParkAssist("Standard");
                                    }
                                    else{
                                        console.log("5 Unchecked");
                                        setFilterParkAssist("");
                                    }
                                }}
                            />
                            <label>
                                Parking Assist Standard
                            </label>
                        </div>
                        */}
                        {/*
                        <div className="select">
                            <select
                                onChange={(e) => {
                                    setFilterAdaptiveCruiseControl(e.target.value);
                                }}
                                className="custom-select"
                                aria-label="Filter Vehicles by Manufacturer"
                            >
                                <option value="">Filter by Adaptive Cruise Control</option>
                                <option value="Standard">Standard</option>
                                <option value="Optional">Optional</option>

                            </select>
                            <span className="focus"></span>
                        </div>*/}
                        <div className="select">
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
                        <FormControl variant="filled" sx={{ m: 1, minWidth: 500 }}>
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
                                <MenuItem value={"/sort/displacementcc-asc"}>Displacement CC: Low to High</MenuItem>
                                <MenuItem value={"/sort/displacementcc-desc"}>Displacement CC: High to low</MenuItem>
                                <MenuItem value={"/sort/enginepower-asc"}>Engine Power (kW): Low to High</MenuItem>
                                <MenuItem value={"/sort/enginepower-desc"}>Engine Power (kW): High to low</MenuItem>
                                <MenuItem value={"/sort/horsepower-asc"}>Horsepower: Low to High</MenuItem>
                                <MenuItem value={"/sort/horsepower-desc"}>Horsepower: High to low</MenuItem>
                                <MenuItem value={"/sort/hasBackupCam"}>Has Backup Cam</MenuItem>
                                <MenuItem value={"/sort/hasAdaptiveCruiseControl"}>Has Adaptive Cruise Control</MenuItem>
                                <MenuItem value={"/sort/hasAdaptDrivingBeam"}>Has Adaptive Driving Beam</MenuItem>
                                <MenuItem value={"/sort/hasRearAutoEmergBraking"}>Has Rear Auto Emergency Braking</MenuItem>
                            </Select>
                        </FormControl>


                    </div>
                    <ul className="card-grid">
                        {search(backupCamFilter(items)).map((item) => {
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