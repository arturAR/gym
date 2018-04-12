import React, {Component} from 'react';
import {withRouter, Redirect} from 'react-router-dom';
import {connect} from 'react-redux';

import {requestCheckAccess, requestAccess, keepPathFrom} from './AuthAction'

class Auth extends Component {

    componentWillMount() {
        if (!this.props.isAuthenticated) {
            if (this.props.location.pathname !== "/auth/login")
                this.props.keepPathFrom(this.props.location.pathname);
        }
    }

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
            console.log(this.props);
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
            if (!this.props.match || this.props.match.isExact) {
                return (<Redirect to={{
                    pathname: "/auth/login",
                }}/>);
            }
        }

        return (
            <div>
                {isLogonFailed ? <div style={{fontSize: 'small', color: 'red'}}>Logon failed</div> : <div></div>}

                <form onSubmit={this._login}>
                    <input type="text" name="email" placeholder="email or username"/>
                    <br/>
                    <input type="password" name="pass" placeholder="password"/>
                    <br/>
                    <input type="submit" value="Login"/>
                </form>
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
        pathFrom,
    } = state.authReducer;

    return {
        isAuthenticated,
        isFetchingCheckingAccess,
        isFetchingAccess,
        isLogonFailed,
        pathFrom
    }
};

const mapDispatchToProps = dispatch => ({
    requestCheckAccess: () => dispatch(requestCheckAccess()),
    requestAccess: (email, pass) => dispatch(requestAccess(email, pass)),
    keepPathFrom: (path) => dispatch(keepPathFrom(path)),
});

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(Auth));