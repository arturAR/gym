import React from 'react';
import './App.css';
import Navbar from './main/Navbar';
import HttpUtils from "../utils/HttpUtils";
import ExternalUrls from "../constants/ExternalUrls";

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            locales: [],
        };
    }

    componentDidMount = () => {
        HttpUtils.getJSON(
            ExternalUrls.LOCALIZATION,
            HttpUtils.METHOD.GET,
            data => this.setState({locales: data}),
            ex => console.log('parsing failed', ex));
    };

    render() {
        const {locales} = this.state;
        return (
            <div className="App">
                <Navbar/>
                <p className="App-intro">
                    To get started, edit <code>src/App.js</code> and save to reload.
                </p>
                <span>{'Hello World!'}</span>

                <div>
                    {locales.map(locale =>
                        <div key={locale.languageCode}>
                            {locale.language} + {locale.languageCode} + {locale.country}
                        </div>
                    )}
                </div>
            </div>
        );
    }
}

export default App;
