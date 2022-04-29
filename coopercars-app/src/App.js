import React, { useState, useEffect } from 'react';
//import useInterval from './useInterval';
import coopercars1_logo from './CooperCars-logos.jpeg';
import coopercars2_logo from './CooperCars-logos_black.png';
import './App.css';
import NavBar from './components/NavBar'
import TextField from "@material-ui/core/TextField";
import {
  BrowserRouter as Router,
  Route,
  Link,
  Navigate,
  Routes,
} from "react-router-dom";
import HomePage from "./components/HomePage";
import BrowseVehicle from "./components/BrowseVehicle";
import AddVehicle from "./components/AddVehicle";
import RemoveVehicle from "./components/RemoveVehicle";
import VehicleDetails from "./components/VehicleDetails";
import Login, {Register} from "./components/Login";
import { getCurrentUser } from './util/APIUtils';
import Alert from "react-s-alert";
import {ACCESS_TOKEN} from "./constants/";

function getRandomColor() {
  let colorValues = ["red", "blue", "green"];
  return colorValues[Math.floor(Math.random() * colorValues.length)];
}

function App() {

    const [authenticated, setAuthenticated] = useState(false);
    useEffect(() => {
        getCurrentUser().then(res => {
        console.log(res);
        setAuthenticated(true);
        }).catch(error => console.log(error));
    }, []);

    function handleLogout() {
        localStorage.removeItem(ACCESS_TOKEN);
        this.setState({
          authenticated: false,
          currentUser: null
        });
        Alert.success("You're safely logged out!");
      }

  return (

    <div className="App">
        <div className="app-top-box">
        </div>
        <Router>
          <NavBar authenticated={authenticated} onLogout={handleLogout} />

            <Routes>
                <Route path='/' element = { <HomePage/>}/>
                <Route path='/browse' element = { <BrowseVehicle/>}/>
                <Route path='/browse/:VIN' element = { <VehicleDetails/>}/>
                <Route path='/addVehicle' element = { <AddVehicle/>}/>
                <Route path='/removeVehicle' element = { <RemoveVehicle/>}/>
                <Route path='/login' element= {<Login/>}/>
                <Route path='/register' element= {<Register/>}/>
            </Routes>
        </Router>

    </div>
  );
}

export default App;
