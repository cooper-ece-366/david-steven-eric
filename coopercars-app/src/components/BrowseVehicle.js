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

    useEffect(() => {
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

    if (error) {
        return <>{error.message}</>;
    } else if (!isLoaded) {
        return <>loading...</>;
    } else {
        return (
            /* here we map over the element and display each item as a card  */
            <div className = "browse">
                <NavBar />
                <div className="wrapper">
                    <ul className="card-grid">
                        {items.map((item) => (
                            <li>
                                <article className="vehicle" key={item.vin}>

                                    <div className="card-content">
                                        <h4 className="card-name">{item.vin}</h4>
                                        <div className="car-image">
                                            <img src={item.imgURL} alt={item.vin}/>
                                        </div>
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
                                                Dealer Price: <span>{item.dealerPrice}</span>
                                            </li>
                                            <li>
                                                Sale Price: <span>{item.salePrice}</span>
                                            </li>
                                        </ol>
                                    </div>
                                </article>
                            </li>
                        ))}
                    </ul>
                </div>
            </div>

        );
    }
}

ReactDOM.render(<BrowseVehicle />, document.getElementById("root"));
export default BrowseVehicle;