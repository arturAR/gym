import HttpUtils from "../utils/HttpUtils";
import ExternalUrls from "../constants/ExternalUrls";

export const APP_DEFAULT_LANGUAGE_REQUEST = 'APP_DEFAULT_LANGUAGE_REQUEST';
export const APP_DEFAULT_LANGUAGE_REQUEST_SUCCESS = 'APP_DEFAULT_LANGUAGE_REQUEST_SUCCESS';
export const APP_DEFAULT_LANGUAGE_REQUEST_FAILED = 'APP_DEFAULT_LANGUAGE_REQUEST_FAILED';

export const APP_LOCALES_REQUEST = 'APP_LOCALES_REQUEST';
export const APP_LOCALES_REQUEST_SUCCESS = 'APP_LOCALES_REQUEST_SUCCESS';
export const APP_LOCALES_REQUEST_FAILED = 'APP_LOCALES_REQUEST_FAILED';

export const APP_I18N_REQUEST = 'APP_I18N_REQUEST';
export const APP_I18N_REQUEST_SUCCESS = 'APP_I18N_REQUEST_SUCCESS';
export const APP_I18N_REQUEST_FAILED = 'APP_I18N_REQUEST_FAILED';

export const requestDefaultLanguage = () => (dispatch, getState) => {
    if (getState().appReducer.isFetchingDefaultLanguage) {
        return;
    }
    dispatch({type: APP_DEFAULT_LANGUAGE_REQUEST});
    return HttpUtils.getJSON(ExternalUrls.DEFAULT_LANGUAGE, HttpUtils.METHOD.GET,
        (language) => dispatch({type: APP_DEFAULT_LANGUAGE_REQUEST_SUCCESS, language}),
        (error) => dispatch({type: APP_DEFAULT_LANGUAGE_REQUEST_FAILED, error: error}));
};

export const requestLocales = () => (dispatch, getState) => {
    if (getState().appReducer.isFetchingLocales) {
        return;
    }
    dispatch({type: APP_LOCALES_REQUEST});
    return HttpUtils.getJSON(ExternalUrls.LOCALES, HttpUtils.METHOD.GET,
        (locales) => dispatch({type: APP_LOCALES_REQUEST_SUCCESS, locales}),
        (error) => dispatch({type: APP_LOCALES_REQUEST_FAILED, error: error}));
};

export const requestI18N = (langCode) => (dispatch, getState) => {
    if (getState().appReducer.isFetchingI18N) {
        return;
    }
    dispatch({type: APP_I18N_REQUEST});
    return HttpUtils.sendJSON(ExternalUrls.I18N, HttpUtils.METHOD.POST,
        {
            "lang": langCode,
            "nav.i18n.about": '',
            "nav.i18n.clubs": '',
            "nav.i18n.events": '',
            "nav.i18n.contact": '',
            "nav.i18n.login": '',
        },
        (i18n) => dispatch({type: APP_I18N_REQUEST_SUCCESS, i18n}),
        (error) => dispatch({type: APP_I18N_REQUEST_FAILED, error: error}));
};