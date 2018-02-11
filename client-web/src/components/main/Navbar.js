import * as React from 'react';
import './Navbar.css';
import I18n from "./I18n";
const logo = require('./../logo.svg');

const logo_en = require('./I18nLogos/flag_en.png');
const logo_pl = require('./I18nLogos/flag_pl.png');
const logo_ru = require('./I18nLogos/flag_ru.png');

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

    onButtonClick(langCode) {
        fetch('http://localhost:8080/i18n', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                "lang": langCode,
                "nav.i18n.about": '',
                "nav.i18n.clubs": '',
                "nav.i18n.events": '',
                "nav.i18n.contact": '',
                "nav.i18n.login": '',
            })
        })
            .then(response => response.json())
            .then(data => (this.setState(data)))
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


                <div className="flags-container">
                    <img src={logo_en} alt="English" onClick={this.onButtonClick.bind(this, "EN")}/>
                    <img src={logo_pl} alt="Polish" onClick={this.onButtonClick.bind(this, "PL")}/>
                </div>
            </div>
        );
    }
};

export default Navbar;
/*<I18n/>*/