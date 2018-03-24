import React from 'react';
import Button from 'material-ui/Button';
import Card from 'material-ui/Card';
import TextField from 'material-ui/TextField';

import './Login.css';

const margin = {margin: '10px'};

const primaryButton = {
    margin: '10px',
    'background-color': 'black',
    'color': 'white',
    'font-weight': '700',
};

const secondaryButton = {
    margin: '10px',
    'background-color': 'white',
    'color': 'black',
    'font-weight': '700',
};

const cardStyle = {
    'max-width': '300px',
    margin: '25px',
    'padding-top': '15px',
    'padding-bottom': '15px',
    'margin-left': 'auto',
    'margin-right': 'auto',
    'margin-top': '25px',
};

export default class Login extends React.Component {

    render() {
        return (
            <div className="login-container">
                <Card style={cardStyle}>
                    <TextField placeholder={"Login"} type="text" name="firstname" style={margin}/><br/>
                    <TextField placeholder={"Password"} type="password" name="password" style={margin}/><br/>
                    <Button variant="raised" style={primaryButton}>Send</Button>
                    <Button variant="raised" style={secondaryButton}>Cancel</Button>
                </Card>
            </div>
        );
    }
}