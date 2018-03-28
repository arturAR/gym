import {combineReducers} from 'redux';
import {appReducer} from "./components/AppReducer";
import {clubsReducer} from "./components/clubs/ClubsReducer";
import {authReducer} from "./modules/auth/AuthReducer";

const rootReducer = combineReducers({
    appReducer,
    clubsReducer,
    authReducer
});

export default rootReducer;