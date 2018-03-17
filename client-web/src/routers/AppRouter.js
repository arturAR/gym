import React from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

import App from '../components/App';
import { Whoops404 } from '../components/error/Whoops404';
import Api from "../components/api/Api";

const AppRouter = () => (
    <Router>
        <div style={{height: '100%'}}>
            <Switch>
                <Route path="/api" component={Api} />
                <Route path="/" component={App} />
                <Route component={Whoops404}/>
            </Switch>
        </div>
    </Router>
);

export default AppRouter;