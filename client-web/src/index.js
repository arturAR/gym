import React from 'react';
import ReactDOM from 'react-dom';
import {Provider} from "react-redux";
import thunk from "redux-thunk";
import logger from 'redux-logger';
import {createStore, applyMiddleware} from "redux";

import AppRouter from './AppRouter';
import rootReducer from './rootReducer'

import registerServiceWorker from './registerServiceWorker';

import './index.css';

const middleware = [thunk];
middleware.push(logger);

const store = createStore(
    rootReducer,
    applyMiddleware(...middleware)
);

ReactDOM.render(
    <Provider store={store}>
        <AppRouter/>
    </Provider>,
    document.getElementById('root'));
registerServiceWorker();
