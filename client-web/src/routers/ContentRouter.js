import React from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

import Clubs from '../components/clubs/Clubs';
import Content from "../components/main/Content";

export default class ContentRouter extends React.Component {
    render() {
        const {i18n, locales} = this.props;
        return (
            <Router>
                <div>
                    <Switch>
                        <Route path="/" exact={true} render={
                            (props) => (<Content i18n={this.props.i18n} locales={this.props.locales}/> )
                        } />
                        <Route path="/clubs" exact={true} render={
                            (props) => (<Clubs i18n={this.props.i18n} locales={this.props.locales}/> )
                        } />
                        <Route path="/events" exact={true} render={
                            (props) => (<Content i18n={this.props.i18n} locales={this.props.locales}/> )
                        } />
                        <Route path="/contact" exact={true} render={
                            (props) => (<Content i18n={this.props.i18n} locales={this.props.locales}/> )
                        } />
                        <Route path="/login" exact={true} render={
                            (props) => (<Content i18n={this.props.i18n} locales={this.props.locales}/> )
                        } />
                    </Switch>
                </div>
            </Router>
        );
    }
}