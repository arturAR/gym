import * as React from 'react';
import './Navbar.css';
import I18n from "./I18n";
const logo = require('./../logo.svg');

class Navbar extends React.Component {

    constructor() {
        super();
        this.state = {
            "lang": "EN",
            "nav.i18n.about": 'About',
            "nav.i18n.clubs": 'Clubs',
            "nav.i18n.events": 'Events',
            "nav.i18n.contact": 'Contact',
            "nav.i18n.login": 'Login',
        };
    }

    render() {
        return (
            <div className="container">
                <img src={logo} className="App-logo" alt="logo"/>
                <a className="menu" href="#about">{this.state['nav.i18n.about']}</a>
                <a className="menu" href="#clubs">{this.state['nav.i18n.clubs']}</a>
                <a className="menu" href="#events">{this.state['nav.i18n.events']}</a>
                <a className="menu" href="#contact">{this.state['nav.i18n.contact']}</a>
                <a className="menu" href="#login">{this.state['nav.i18n.login']}</a>

                <I18n/>
            </div>
        );
    }
};

export default Navbar;
