import * as ACTION from './AppAction';

export const appReducer = (state = {
                               isFetchingDefaultLanguage: false,
                               isFetchingLocales: false,
                               locales: [],
                               isFetchingI18N: false,
                               isReceivedI18N: false,
                               i18n: {}
                           },
                           action) => {
    switch (action.type) {
        case ACTION.APP_DEFAULT_LANGUAGE_REQUEST:
            return {
                ...state,
                isFetchingDefaultLanguage: true
            };
        case ACTION.APP_DEFAULT_LANGUAGE_REQUEST_SUCCESS:
            return {
                ...state,
                isFetchingDefaultLanguage: false,
                langCode: action.language && action.language.lang ? action.language.lang : 'EN',
            };
        case ACTION.APP_DEFAULT_LANGUAGE_REQUEST_FAILED:
            return {
                ...state,
                isFetchingDefaultLanguage: false,
                lang: 'EN'
            };

        case ACTION.APP_LOCALES_REQUEST:
            return {
                ...state,
                isFetchingLocales: true
            };
        case ACTION.APP_LOCALES_REQUEST_SUCCESS:
            return {
                ...state,
                isFetchingLocales: false,
                locales: action.locales,
            };
        case ACTION.APP_LOCALES_REQUEST_FAILED:
            return {
                ...state,
                isFetchingLocales: false
            };

        case ACTION.APP_I18N_REQUEST:
            return {
                ...state,
                isFetchingI18N: true
            };
        case ACTION.APP_I18N_REQUEST_SUCCESS:
            return {
                ...state,
                i18n: action.i18n,
                isReceivedI18N: true,
                isFetchingI18N: false,
            };
        case ACTION.APP_I18N_REQUEST_FAILED:
            return {
                ...state,
                isFetchingI18N: false
            };

        default:
            return state;
    }
};