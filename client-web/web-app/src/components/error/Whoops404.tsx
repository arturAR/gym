import * as React from 'react';
import './Whoops404.css';
const logo = require('./error-404.png');

export const Whoops404 = () => {
    return (
        <div className="not-found">
            <img src={logo} alt="logo"/>
            <a className="back-button" href="/">Back</a>
        </div>
    );
};
