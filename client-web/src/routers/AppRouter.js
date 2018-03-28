import React from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

import App from '../components/App';
import { Whoops404 } from '../components/error/Whoops404';
import Api from "../components/api/Api";
import Auth from "../modules/auth/Auth";
import Dashboard from "../modules/cms/Dashboard";
import PrivateRoute from "../modules/auth/PrivateRoute";

const AppRouter = () => (
    <Router>
        <div style={{height: '100%'}}>
            <Switch>
                <Route path="/api" component={Api} />
                <Route path="/auth" component={Auth}/>
                <PrivateRoute path={"/cms"} component={Dashboard}/>
                <Route path="/" component={App} />
                <Route component={Whoops404}/>
            </Switch>
        </div>
    </Router>
);

export default AppRouter;