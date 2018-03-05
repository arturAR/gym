import * as React from 'react';
import './Navbar.css';
import I18n from "./I18n";

const logo = require('./../logo.svg');

export default class Navbar extends React.Component {

    render() {
        const {i18n} = this.props;
        return (
            <div className="navbar-container">
                <img src={logo} className="App-logo" alt="logo"/>
                <a className="menu" href="/">{i18n['nav.i18n.about']}</a>
                <a className="menu" href="/clubs">{i18n['nav.i18n.clubs']}</a>
                <a className="menu" href="/events">{i18n['nav.i18n.events']}</a>
                <a className="menu" href="/contact">{i18n['nav.i18n.contact']}</a>
                <a className="menu" href="/login">{i18n['nav.i18n.login']}</a>

                <I18n changeLocalHandler={this.props.changeLocalHandler}/>
            </div>
        );
    }
};