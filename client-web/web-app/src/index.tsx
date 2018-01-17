import * as React from 'react';
import * as ReactDOM from 'react-dom';
import App from './components/App';
import { Whoops404 } from './components/error/Whoops404';
import registerServiceWorker from './registerServiceWorker';
import {BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import './index.css';

ReactDOM.render(
    <Router>
        <Switch>
            <Route path="/" exact={true} component={App}/>
            <Route component={Whoops404}/>
        </Switch>
    </Router>,
    document.getElementById('root') as HTMLElement
);
registerServiceWorker();
