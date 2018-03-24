import React from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

import Clubs from '../components/clubs/Clubs';
import Club from '../components/clubs/Club';
import Content from "../components/main/Content";
import { Whoops404 } from '../components/error/Whoops404';

export default class ContentRouter extends React.Component {

    getClubDetailsHandler = (clubId, langCode) => {
        this.props.requestClubDetails(clubId, langCode);
    }

    render() {
        return (
            <Switch>
                <Route path="/" exact={true} render={
                    (props) => (<Content i18n={this.props.i18n} locales={this.props.locales}/> )
                } />
                <Route path="/clubs" exact={true} render={
                    (props) => (<Clubs langCode={this.props.langCode} /> )
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
                <Route path="/clubs/:clubId" exact={true} render={
                    (props) => (<Clubs langCode={this.props.langCode}/> )
                } />
                <Route component={Whoops404}/>
            </Switch>
        );
    }
}