import * as React from 'react';
import './Navbar.css';
import {I18n} from "./I18n";
const logo = require('./../logo.svg');

export const Navbar = () => {
    return (
        <div className="container">
            <img src={logo} className="App-logo" alt="logo"/>
            <a className="menu" href="#about">About</a>
            <a className="menu" href="#clubs">Clubs</a>
            <a className="menu" href="#events">Events</a>
            <a className="menu" href="#contact">Contact</a>
            <a className="menu" href="#login">Login</a>

            <I18n/>
        </div>
    );
};
