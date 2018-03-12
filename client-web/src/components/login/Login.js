import React from 'react';
import Button from 'material-ui/Button';
import Card from 'material-ui/Card';
import TextField from 'material-ui/TextField';
import { withStyles } from 'material-ui/styles';
import {grey} from "material-ui/es/colors/";

import './Login.css';

const styles = theme => ({
    button: {
        margin: theme.spacing.unit,
    },
    textfield: {
        margin: theme.spacing.unit,
    },
    card: {
        backgroundColor: grey,
        margin: 15,
        maxWidth: 200,
    },
});

export default class Login extends React.Component {

    render() {
        return (
            <div className="login-container">
                <Card classes={styles.card}>
                    <TextField placeholder={"Login"} type="text" name="firstname" classes={styles.textfield}/><br/>
                    <TextField placeholder={"Password"} type="password" name="password" classes={styles.textfield}/><br/>
                    <Button variant="raised" color="primary" classes={styles.button}>Send</Button>
                    <Button variant="raised" color="secondary" classes={styles.button}>Cancel</Button>
                </Card>
            </div>
        );
    }
}