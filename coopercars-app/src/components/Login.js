import React, {useState} from "react";
import "./boostrap.min.css";
import "./Login.css";
import NavBar from './NavBar'
import {Link, useNavigate} from "react-router-dom";
import { login } from '../util/APIUtils';
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import CssBaseline from '@material-ui/core/CssBaseline';
import TextField from '@material-ui/core/TextField';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
import Grid from '@material-ui/core/Grid';
import Box from '@material-ui/core/Box';
import Typography from '@material-ui/core/Typography';
import Container from '@material-ui/core/Container';
import { GOOGLE_AUTH_URL, FACEBOOK_AUTH_URL, GITHUB_AUTH_URL, ACCESS_TOKEN } from '../constants';
import Alert from 'react-s-alert';
import fbLogo from "../img/fb-logo.png";
import githubLogo from "../img/github-logo.png";
import googleLogo from "../img/google-logo.png";


export default function Login(){
  const navigate = useNavigate();
  const [email, changeEmail] = useState("");
  const [password, changePassword] = useState("");
    const handlePassword = (event) => {
        event.preventDefault();
        changePassword(event.target.value);
        console.log(event.target.value);
    }
    const handleEmail = (event) =>{
        event.preventDefault();
        changeEmail(event.target.value);
        console.log(event.target.value);
    }

    const handleSubmit = () => {
        const loginRequest = Object.assign({}, {"email": email, "password": password});
        login(loginRequest).then(response => {
            localStorage.setItem(ACCESS_TOKEN, response.accessToken);
            console.log("ACCESS_TOKEN = " + response.accessToken);
            navigate("/");
            window.location.reload();

        }).catch(error =>{
            Alert.error((error && error.message) || 'Oops! Something went wrong. Please try again!');
        });

  }

    return(
        <div>
            <h3>Sign In</h3>
            <div className="form-group">
                <label>Email address</label>
                <input type="email" className="form-control" placeholder="Enter email" onChange={handleEmail} />
            </div>
            <div className="form-group">
                <label>Password</label>
                <input type="password" className="form-control" placeholder="Enter password" onChange={handlePassword} />
            </div>
            <div className="form-group">
                <div className="custom-control custom-checkbox">
                    <input type="checkbox" className="custom-control-input" id="customCheck1" />
                    <label className="custom-control-label" htmlFor="customCheck1">Remember me</label>
                </div>
            </div>
            <button className="btn btn-primary btn-block" to='/browse' onClick={handleSubmit}>Submit</button>
            <p className="forgot-password text-right">
                Forgot <a href="#">password?</a>
            </p>
            <p className="register text-right">
                <Link to='/register'>Register</Link>
            </p>

        </div>
    );
}



export function Register () {
  const [firstName, changeFirstName] = useState("");
  const [lastName, changeLastName] = useState("");
  const [email, changeEmail] = useState("");
  const [password, changePassword] = useState("");
    const handlePassword = (event) => {
        event.preventDefault();
        changePassword(event.target.value);
        console.log(event.target.value);
    }
    const handleEmail = (event) =>{
        event.preventDefault();
        changeEmail(event.target.value);
        console.log(event.target.value);
    }
    const handleFirstName = (event) =>{
        event.preventDefault();
        changeFirstName(event.target.value);
        console.log(event.target.value);
    }


    const handleSubmit = () => {
        const requestOptions = {
              method: "POST",
              headers: { "Content-Type": "application/json" },
              body: JSON.stringify({
                firstName,
                email,
                password,
              }),
        };
        fetch("http://localhost:8080/auth/signup", requestOptions).then((response) => console.log(response)).then((data) => console.log(data)); //response.json()

        const loginRequest = Object.assign({}, {"email": email, "password": password});
        login(loginRequest).then(response => {
            localStorage.setItem(ACCESS_TOKEN, response.accessToken);
            console.log("ACCESS_TOKEN = " + response.accessToken);
            Alert.success("You're successfully logged in!");
            window.location.reload();
        }).catch(error =>{
            Alert.error((error && error.message) || 'Oops! Something went wrong. Please try again!');
        });
  }

    return(
        <div>
            <h3>Sign Up</h3>
            <div className="form-group">
                <label>First Name</label>
                <input type="first-name" className="form-control" placeholder="Steven" onChange={handleFirstName} />
            </div>
            <div className="form-group">
                <label>Email address</label>
                <input type="email" className="form-control" placeholder="Enter email" onChange={handleEmail} />
            </div>
            <div className="form-group">
                <label>Password</label>
                <input type="password" className="form-control" placeholder="Enter password" onChange={handlePassword} />
            </div>
            <button className="btn btn-primary btn-block" onClick={handleSubmit}>Submit</button>
            <p className="login text-right">
                <Link to='/login'>Login</Link>
            </p>

        </div>
    );

}