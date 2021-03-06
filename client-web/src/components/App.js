import React from 'react';
import {withRouter} from 'react-router-dom';
import {connect} from 'react-redux';

import {
    requestDefaultLanguage,
    requestLocales,
    requestI18N,
} from './AppAction'

import './App.css';
import Navbar from './main/Navbar';
import Footer from "./main/Footer";
import Content from "./main/Content";

class App extends React.Component {

    componentDidMount = () => {
        this.props.requestDefaultLanguage();
        this.props.requestLocales();
    };

    componentWillReceiveProps(nextProps) {
        if (!nextProps.isFetchingI18N && !nextProps.isReceivedI18N && nextProps.langCode) {
            nextProps.requestI18N(nextProps.langCode);
        }
    }

    changeLocalHandler = (langCode) => {
        this.props.requestI18N(langCode);
    };

    render() {
        const {isFetchingDefaultLanguage, langCode, isFetchingLocales, locales} = this.props;
        if (isFetchingDefaultLanguage || isFetchingLocales) {
            return (
                <div>Loading...</div>
            )
        }

        return (
            <div className="App">
                <Navbar i18n={this.props.i18n} changeLocalHandler={this.changeLocalHandler}/>
                <Content i18n={this.props.i18n} locales={this.props.locales}/>
                <Footer/>
            </div>
        );
    }
}

const mapStateToProps = state => {
    const {
        isFetchingDefaultLanguage,
        langCode,
        isFetchingLocales,
        locales,
        isFetchingI18N,
        isReceivedI18N,
        i18n,
    } = state.appReducer;

    return {
        isFetchingDefaultLanguage,
        langCode,
        isFetchingLocales,
        locales,
        isFetchingI18N,
        isReceivedI18N,
        i18n,
    }
};

const mapDispatchToProps = dispatch => ({
    requestDefaultLanguage: () => dispatch(requestDefaultLanguage()),
    requestLocales: () => dispatch(requestLocales()),
    requestI18N: (lang) => dispatch(requestI18N(lang)),
});

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(App));
