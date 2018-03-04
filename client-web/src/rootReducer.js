import {combineReducers} from 'redux';
import {appReducer} from "./components/AppReducer";

const rootReducer = combineReducers({
    appReducer,
});

export default rootReducer;