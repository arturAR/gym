import {combineReducers} from 'redux';
import {appReducer} from "./components/AppReducer";
import {clubsReducer} from "./components/clubs/ClubsReducer";

const rootReducer = combineReducers({
    appReducer,
    clubsReducer
});

export default rootReducer;