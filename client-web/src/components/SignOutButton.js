import React from 'react';
import {withRouter} from 'react-router-dom';

import {signOut} from '../modules/auth/AuthAction';

const SignOutButton = withRouter(({dispatch}) => (
    <button onClick={() => {
        dispatch(signOut());
    }}>Sign out
    </button>
));

export default SignOutButton;