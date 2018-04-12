import * as ACTION from './AuthAction';
import {AUTH_REQUEST_SIGN_OUT_SUCCESS} from "./AuthAction";
import {AUTH_REQUEST_SIGN_OUT_FAILED} from "./AuthAction";

export const authReducer = (state = {
                                isAuthenticated: false,
                                isFetchingCheckingAccess: false,
                                isFetchingAccess: false,
                                isFetchingSignOut: false,
                                isLogonFailed: false,
                            },
                            action) => {
    switch (action.type) {
        case ACTION.AUTH_REQUEST_CHECK_ACCESS:
            return {
                ...state,
                isFetchingCheckingAccess: true
            };
        case ACTION.AUTH_REQUEST_CHECK_ACCESS_IS_AUTHENTICATED:
            return {
                ...state,
                isFetchingCheckingAccess: false,
                isAuthenticated: true,
            };
        case ACTION.AUTH_REQUEST_CHECK_ACCESS_FORBIDDEN:
        case ACTION.AUTH_REQUEST_CHECK_ACCESS_FAILED:
            return {
                ...state,
                isFetchingCheckingAccess: false,
                isAuthenticated: false,
            };

        case ACTION.AUTH_REQUEST_ACCESS:
            return {
                ...state,
                isFetchingAccess: true,
                isLogonFailed: false,
            };
        case ACTION.AUTH_REQUEST_ACCESS_GRANTED:
            return {
                ...state,
                isFetchingAccess: false,
                isAuthenticated: true,
                isLogonFailed: false,
            };
        case ACTION.AUTH_REQUEST_ACCESS_FORBIDDEN:
        case ACTION.AUTH_REQUEST_ACCESS_FAILED:
            return {
                ...state,
                isFetchingAccess: false,
                isAuthenticated: false,
                isLogonFailed: true,
            };
        case ACTION.AUTH_REQUEST_SIGN_OUT_SUCCESS:
        case ACTION.AUTH_REQUEST_SIGN_OUT_FAILED:
            return {
                ...state,
                isAuthenticated: false,
            };
        case ACTION.KEEP_PATH_FROM:
            return {
                ...state,
                pathFrom: action.pathFrom
            };
        default:
            return state;
    }
};