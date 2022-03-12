import logo from './logo.svg';
import './App.css';
import React, { useState } from "react";
import TextField from "@material-ui/core/TextField";


function App() {
    const [data,setData]=useState(null);
    const [print,setPrint]=useState(false);
    function getData(val)
    {
        setData(val.target.value)
        console.warn(val.target.value)
    }
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
          <p>
              Enter VIN of vehicle to add to inventory:
          </p>
          <input type="text" onChange={getData}/>
          <button onClick={()=>setPrint(true)}>Submit</button>

          {
              print?
                  <h1>{data}</h1>
                  :null
          }

      </header>

    </div>

  );
}

export default App;
