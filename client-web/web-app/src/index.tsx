import * as React from 'react';
import * as ReactDOM from 'react-dom';
import App from './components/App';
import {Whoops404} from './components/error/Whoops404';
import registerServiceWorker from './registerServiceWorker';
import { Router, Route, hashHistory} from 'react-router'
import './index.css';

ReactDOM.render(
  <Router history={hashHistory}>
    <Route path="/" component={App}/>
      <Route path="*" component={Whoops404}/>
  </Router>,
  document.getElementById('root') as HTMLElement
);
registerServiceWorker();
