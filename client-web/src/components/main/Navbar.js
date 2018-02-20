import * as React from 'react';
import './Navbar.css';
import I18n from "./I18n";

const logo = require('./../logo.svg');

const logo_en = require('./I18nLogos/flag_en.png');
const logo_pl = require('./I18nLogos/flag_pl.png');
const logo_ru = require('./I18nLogos/flag_ru.png');

export default class Navbar extends React.Component {

    render() {
        const {i18n, changeLocalHandler} = this.props;
        return (
            <div className="container">
                <img src={logo} className="App-logo" alt="logo"/>
                <a className="menu" href="#about">{i18n['nav.i18n.about']}</a>
                <a className="menu" href="#clubs">{i18n['nav.i18n.clubs']}</a>
                <a className="menu" href="#events">{i18n['nav.i18n.events']}</a>
                <a className="menu" href="#contact">{i18n['nav.i18n.contact']}</a>
                <a className="menu" href="#login">{i18n['nav.i18n.login']}</a>


                <div className="flags-container">
                    <img src={logo_en} alt="English" onClick={(e) => changeLocalHandler("EN")}/>
                    <img src={logo_pl} alt="Polish" onClick={(e) => changeLocalHandler("PL")}/>
                </div>
            </div>
        );
    }
};