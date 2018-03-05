import React from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';

import App from '../components/App';
import { Whoops404 } from '../components/error/Whoops404';

const AppRouter = () => (
    <Router>
        <div style={{height: '100%'}}>
            <Switch>
                <Route path="/" component={App} />
                <Route component={Whoops404}/>
            </Switch>
        </div>
    </Router>
);

export default AppRouter;