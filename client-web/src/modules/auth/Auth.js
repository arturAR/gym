import React, {Component} from 'react';
import {withRouter, Redirect} from 'react-router-dom';
import {connect} from 'react-redux';
import Button from 'material-ui/Button';
import Card from 'material-ui/Card';
import TextField from 'material-ui/TextField';

import {requestCheckAccess, requestAccess} from './AuthAction'

const margin = {margin: '10px'};

const primaryButton = {
    margin: '10px',
    backgroundColor: 'black',
    color: 'white',
    fontWeight: '700',
};

const secondaryButton = {
    margin: '10px',
    backgroundColor: 'white',
    color: 'black',
    fontWeight: '700',
};

const cardStyle = {
    maxWidth: '300px',
    margin: '25px',
    paddingTop: '15px',
    paddingBottom: '15px',
    marginLeft: 'auto',
    marginRight: 'auto',
    marginTop: '25px',
    textAlign: 'center',
};

class Auth extends Component {

    componentDidMount() {
        if (!!this.props.requestCheckAccess)
            this.props.requestCheckAccess();
    }

    _login = (event) => {
        event.preventDefault();
        if (!event.target || !event.target.elements
            || !event.target.elements.email || !event.target.elements.email.value
            || !event.target.elements.pass || !event.target.elements.pass.value) {

            console.log('Auth parameters not set');
            return;
        }
        this.props.requestAccess(
            event.target.elements.email.value,
            event.target.elements.pass.value);
    };

    render() {
        const {
            isAuthenticated,
            isFetchingCheckingAccess,
            isFetchingAccess,
            isLogonFailed,
        } = this.props;

        if (isFetchingCheckingAccess || isFetchingAccess) {
            return (
                <div>Loading...</div>
            )
        }

        if (isAuthenticated) {
            if (this.props.component) {
                return (React.createElement(this.props.component, this.props));
            } else {
                return this.props.pathFrom ?
                    (<Redirect to={{
                        pathname: this.props.pathFrom,
                    }}/>) :
                    (<Redirect to={{
                        pathname: "/cms",
                    }}/>);
            }
        } else {
            // Stay on this page
        }

        return (
            <div className="content-container">
            <div>
                {isLogonFailed ? <div style={{fontSize: 'small', color: 'red'}}>Logon failed</div> : <div></div>}
                    <form onSubmit={this._login}>
                        <Card style={cardStyle}>
                            <TextField placeholder={"Login"} type="text" name="email" style={margin}/><br/>
                            <TextField placeholder={"Password"} type="password" name="pass" style={margin}/><br/>
                            <Button variant="raised" style={primaryButton} type="submit" value="Login" >Send</Button>
                            <Button variant="raised" style={secondaryButton}>Cancel</Button>
                        </Card>
                    </form>
                </div>
            </div>
        )
    }
}

const mapStateToProps = state => {
    const {
        isAuthenticated,
        isFetchingCheckingAccess,
        isFetchingAccess,
        isLogonFailed,
    } = state.authReducer;

    return {
        isAuthenticated,
        isFetchingCheckingAccess,
        isFetchingAccess,
        isLogonFailed
    }
};

const mapDispatchToProps = dispatch => ({
    requestCheckAccess: () => dispatch(requestCheckAccess()),
    requestAccess: (email, pass) => dispatch(requestAccess(email, pass)),
});

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(Auth));