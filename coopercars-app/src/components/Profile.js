import React, {useState, useEffect} from "react";
import "./Profile.css";
import NavBar from './NavBar'
import {Link} from "react-router-dom";
import { login } from '../util/APIUtils';
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import Checkbox from '@material-ui/core/Checkbox';
import Grid from '@material-ui/core/Grid';
import Box from '@material-ui/core/Box';
import Typography from '@material-ui/core/Typography';
import Container from '@material-ui/core/Container';
import { GOOGLE_AUTH_URL, FACEBOOK_AUTH_URL, GITHUB_AUTH_URL, ACCESS_TOKEN } from '../constants';
import Alert from 'react-s-alert';
import { getCurrentUser } from '../util/APIUtils';
import default_profile_pic from "../img/default_profile_pic.jpg";


export default function Profile(props){


    return(
        <div>
            <div className="profile_img"><img src={default_profile_pic} alt="Profile pic"/>
</div>
            <Button variant="contained">Edit Picture</Button>
            <p>{props.currentUser.name}</p>
            <p>{props.currentUser.email}</p>
        </div>
    );
}


