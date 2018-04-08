import * as React from 'react';
import './Navbar.css';
import I18n from "./I18n";
import {Link} from 'react-router-dom';

const logo = require('./../logo.svg');

export default class Navbar extends React.Component {

    render() {
        const {i18n} = this.props;
        return (
            <div className="navbar-container">
                <img src={logo} className="App-logo" alt="logo"/>
                <Link to="/" className="menu">{i18n['nav.i18n.about']}</Link>
                <Link to="/clubs" className="menu">{i18n['nav.i18n.clubs']}</Link>
                <Link to="/events" className="menu">{i18n['nav.i18n.events']}</Link>
                <Link to="/contact" className="menu">{i18n['nav.i18n.contact']}</Link>
                <Link to="/login" className="menu">{i18n['nav.i18n.login']}</Link>

                <I18n changeLocalHandler={this.props.changeLocalHandler}/>
            </div>
        );
    }
};