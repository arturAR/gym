import React from 'react';
import {Route} from 'react-router-dom';

import Auth from './Auth';

const PrivateRoute = ({component, ...rest}) =>
    (<Route {...rest} render={props => (<Auth component={component} location={rest.location}/>)}/>);

export default PrivateRoute;