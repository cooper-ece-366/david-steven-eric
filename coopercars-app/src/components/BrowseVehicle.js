import { useState, useEffect } from "react";
import React, {Component} from "react";
import ReactDOM from 'react-dom';

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


function BrowseVehicle()
{
    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false);
    const [items, setItems] = useState([]);
    const [q, setQ] = useState("");
    //     set search parameters
    //     we only what to search countries by capital and name
    //     this list can be longer if you want
    //     you can search countries even by their population
    // just add it to this array
    const [searchParam] = useState(["make", "model"]);
    const [filterParam, setFilterParam] = useState(["All"]);
    const [sortParam, setSortParam] = useState("");
    const fetchURLSort = "http://localhost:8080/api/vehicles"

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

    function search(items) {
        return items.filter((item) => {

            if (item.year==filterParam || item.make == filterParam) {
                return searchParam.some((newItem) => {
                    return (
                        item[newItem]
                            .toString()
                            .toLowerCase()
                            .indexOf(q.toLowerCase()) > -1
                    );
                });
            } else if (filterParam == "All") {
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
                                /*
                                // set the value of our useState q
                                //  anytime the user types in the search box
                                */
                                onChange={(e) => setQ(e.target.value)}
                            />
                            <span className="sr-only">Search for vehicle here</span>
                        </label>
                        <div className="select">
                            <select
                                /*
    //                         here we create a basic select input
    //                     we set the value to the selected value
    //                     and update the setC() state every time onChange is called
                        */
                                onChange={(e) => {
                                    setFilterParam(e.target.value);
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
                                /*
    //                         here we create a basic select input
    //                     we set the value to the selected value
    //                     and update the setC() state every time onChange is called
                        */
                                onChange={(e) => {
                                    setFilterParam(e.target.value);
                                }}
                                className="custom-select"
                                aria-label="Filter Vehicles by Manufacturer"
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
                                <MenuItem value={"/sort/enginepower-asc"}>Engine Power (kW): Low to High</MenuItem>
                                <MenuItem value={"/sort/enginepower-desc"}>Engine Power (kW): High to low</MenuItem>
                                <MenuItem value={"/sort/horsepower-asc"}>Horsepower: Low to High</MenuItem>
                                <MenuItem value={"/sort/horsepower-desc"}>Horsepower: High to low</MenuItem>

                            </Select>
                        </FormControl>
                        {/*<Button variant="contained" className="button" onClick={BrowseVehicle.handleSort}>Sort</Button>*/}


                    </div>
                    <ul className="card-grid">

                        {search(items).map((item) => {
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
                                                Make:{" "}
                                                <span>{item.make}</span>
                                            </li>
                                            <li>
                                                Model: <span>{item.model}</span>
                                            </li>
                                            <li>
                                                Year: <span>{item.year}</span>
                                            </li>
                                            <li>
                                                Dealer Price: $<span>{item.dealerPrice}</span>
                                            </li>
                                            <li>
                                                Sale Price: $<span>{item.salePrice}</span>
                                            </li>
                                            <li>
                                                Profit: $<span>{item.profit}</span>
                                            </li>
                                            <li>
                                                Date Entered: <span>{item.enteredDate}</span>
                                            </li>
                                            <li>
                                                Status: <span>{item.status}</span>
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