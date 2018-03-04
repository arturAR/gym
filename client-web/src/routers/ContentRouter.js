import React from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

import Clubs from '../components/clubs/Clubs';
import Content from "../components/main/Content";

export default class ContentRouter extends React.Component {
    render() {
        const {i18n, locales} = this.props;
        return (
            <Router>
                <div style={{height: '100%'}}>
                    <Switch>
                        <Route path="/about" exact={true} render={(props) => (<Content i18n={this.props.i18n} locales={this.props.locales}/> )} />
                        <Route path="/clubs" exact={true} component={Clubs} />
                        <Route path="/events" exact={true} component={Content} />
                        <Route path="/contact" exact={true} component={Content} />
                        <Route path="/login" exact={true} component={Content} />
                    </Switch>
                </div>
            </Router>
        );
    }
}