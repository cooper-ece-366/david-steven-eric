import React from 'react'
import AppBar from '@material-ui/core/AppBar'
import Toolbar from '@material-ui/core/Toolbar'
import Typography from '@material-ui/core/Typography'
import Button from '@material-ui/core/Button';
import {Container, Tooltip} from "@material-ui/core";
import logo from "../logo.svg";

const pages = ['Browse Vehicles', 'Add Vehicles'];
const settings = ['Profile', 'Account', 'Dashboard', 'Logout'];

const NavBar = () => {
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
                        <img src={logo} className="App-logo" alt="logo" sx={{ p: 0 }} width = "100" height = "100"/>
                    </Typography>

                    {/*<div>*/}
                    {/*    <Link>*/}
                    {/*        Home*/}
                    {/*    </Link>*/}
                    {/*    <Link>*/}
                    {/*        Search*/}
                    {/*    </Link>*/}
                    {/*</div>*/}
                    {/*<Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>*/}
                    {/*    Vehicles*/}
                    {/*</Typography>*/}
                    <Button color="inherit">Browse Vehicles</Button>
                    <Button color="inherit">Add Vehicle</Button>
                    <Tooltip>
                        <Button color="inherit" align = "right" sx={{ p: 0 }}>Login</Button>
                    </Tooltip>
                </Toolbar>
                </Container>
            </AppBar>
        </div>
    )
}
export default NavBar;