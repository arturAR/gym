import HttpUtils from "../../utils/HttpUtils";

export const AUTH_REQUEST_CHECK_ACCESS = 'AUTH_REQUEST_CHECK_ACCESS';
export const AUTH_REQUEST_CHECK_ACCESS_IS_AUTHENTICATED = 'AUTH_REQUEST_CHECK_ACCESS_IS_AUTHENTICATED';
export const AUTH_REQUEST_CHECK_ACCESS_FORBIDDEN = 'AUTH_REQUEST_CHECK_ACCESS_FORBIDDEN';
export const AUTH_REQUEST_CHECK_ACCESS_FAILED = 'AUTH_REQUEST_CHECK_ACCESS_FAILED';

export const AUTH_REQUEST_ACCESS = 'AUTH_REQUEST_ACCESS';
export const AUTH_REQUEST_ACCESS_GRANTED = 'AUTH_REQUEST_ACCESS_GRANTED';
export const AUTH_REQUEST_ACCESS_FORBIDDEN = 'AUTH_REQUEST_ACCESS_FORBIDDEN';
export const AUTH_REQUEST_ACCESS_FAILED = 'AUTH_REQUEST_ACCESS_FAILED';

export const AUTH_REQUEST_SIGN_OUT = 'AUTH_REQUEST_SIGN_OUT';
export const AUTH_REQUEST_SIGN_OUT_SUCCESS = 'AUTH_REQUEST_SIGN_OUT_SUCCESS';
export const AUTH_REQUEST_SIGN_OUT_FAILED = 'AUTH_REQUEST_SIGN_OUT_FAILED';

export const requestCheckAccess = () => (dispatch, getState) => {
    if (getState().authReducer.isFetchingCheckingAccess) {
        return;
    }
    dispatch({type: AUTH_REQUEST_CHECK_ACCESS});
    return HttpUtils.isAuthenticated('backend/auth/check',
        (response) => {
            if (HttpUtils.isResponseSuccess(response)) {
                dispatch({type: AUTH_REQUEST_CHECK_ACCESS_IS_AUTHENTICATED})
            } else {
                dispatch({type: AUTH_REQUEST_CHECK_ACCESS_FORBIDDEN})
            }
        },
        (error) => dispatch({type: AUTH_REQUEST_CHECK_ACCESS_FAILED, error: error}));
};

export const requestAccess = (email, password) => (dispatch, getState) => {
    if (getState().authReducer.isFetchingAccess) {
        return;
    }
    dispatch({type: AUTH_REQUEST_ACCESS});
    return HttpUtils.postWithAuthorization('backend/auth/signin', email, password,
        (response) => {
            if (HttpUtils.isResponseSuccess(response)) {
                dispatch({type: AUTH_REQUEST_ACCESS_GRANTED})
            } else {
                switch (response.status) {
                    case 403:
                        console.log('Wrong email or password');
                        break;
                    default:
                        console.log('Undefined error');
                        break;
                }

                dispatch({type: AUTH_REQUEST_ACCESS_FORBIDDEN})
            }
        },
        (error) => dispatch({type: AUTH_REQUEST_ACCESS_FAILED}));
};

export const signOut = () => (dispatch, getState) => {
    if (getState().authReducer.isFetchingSignOut) {
        return;
    }
    dispatch({type: AUTH_REQUEST_SIGN_OUT});
    return HttpUtils.postWithCredentials('backend/auth/signout',
        (response) => {
            dispatch({type: AUTH_REQUEST_SIGN_OUT_SUCCESS});
        },
        (error) => dispatch({type: AUTH_REQUEST_SIGN_OUT_FAILED})
    );
};