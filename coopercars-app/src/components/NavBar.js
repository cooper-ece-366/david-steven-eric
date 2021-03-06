import React from 'react'
import AppBar from '@material-ui/core/AppBar'
import Toolbar from '@material-ui/core/Toolbar'
import Typography from '@material-ui/core/Typography'
import Button from '@material-ui/core/Button';
import {Container, Tooltip} from "@material-ui/core";
import logo from "../CooperCars-logos_white.png";
import {Link} from "react-router-dom";

// NavBar.js edited by David

const NavBar = (props) => {

    const authenticated = props.authenticated;
    return(
        <div>
            <AppBar position="static" >
                <Container maxWidth="xl">
                <Toolbar disableGutters sx={{ height: 100 }}>
                    <Typography
                        variant="h6"
                        noWrap
                        component="div"
                        sx={{ mr: 2, display: { xs: 'none', md: 'flex' } }}
                    >
                    </Typography>

                    <Button to="/" component={Link} color="inherit">
                        <img src={logo} className="App-logo" alt="logo" sx={{ p: 0 }} width = "100" height = "100"/>
                    </Button>

                    {authenticated == true ? <Button to="/browse" component={Link} color="inherit">Browse Vehicles</Button> : <p></p>}
                    {authenticated == true ?                     <Button to="/addVehicle" component={Link} color="inherit">Add/Update Vehicles</Button>
 : <p></p>}
                    {authenticated == true ? <Button to="/removeVehicle" component={Link} color="inherit">Remove Vehicles</Button> : <p></p>}
                    {authenticated == false ?
                                                         <Tooltip>
                                                             <Button to="/login" component={Link} color="inherit" align = "right" sx={{ p: 0 }}>Login</Button>
                                                         </Tooltip> :  <Button to="/login" component={Link} onClick={props.onLogout}>Logout</Button>}
                    {authenticated == true ?  <Button to="/profile" component={Link} color="inherit">Profile</Button> : <p></p>}


                </Toolbar>
                </Container>
            </AppBar>
        </div>
    )
}
export default NavBar;