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


function BrowseVehicle() {
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

    useEffect(() => {
        window.scrollTo(0, 0);
        fetch("http://localhost:8080/api/vehicles")
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
            );
    }, []);

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
            <div className="browse"><NavBar />
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
                                <option value="FORD">Ford</option>
                                <option value="HONDA">Honda</option>
                                <option value="HYUNDAI">Hyundai</option>
                                <option value="LINCOLN">Lincoln</option>
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
                                <option value="2017">2017</option>
                                <option value="2018">2018</option>
                                <option value="2019">2019</option>
                                <option value="2020">2020</option>
                                <option value="2021">2021</option>
                            </select>
                            <span className="focus"></span>
                        </div>
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
                                                Date Entered: <span>{item.enteredDate}</span>
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