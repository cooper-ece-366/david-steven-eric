import React, {useState} from "react";
import "./boostrap.min.css";
import NavBar from './NavBar'
import { login } from '../util/APIUtils';


function Login(){
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
        console.log("HI")
        const requestOptions = {
              method: "POST",
              headers: { "Content-Type": "application/json" },
              body: JSON.stringify({
                email,
                password,
              }),
            };
        console.log(requestOptions);
        fetch("http://localhost:8080/auth/login", requestOptions).then((response) => console.log(response)); //response.json()

  }

    return(
        <div>
        <NavBar/>
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
            <button className="btn btn-primary btn-block" onClick={handleSubmit}>Submit</button>
            <p className="forgot-password text-right">
                Forgot <a href="#">password?</a>
            </p>

        </div>
    );
}

export default Login;