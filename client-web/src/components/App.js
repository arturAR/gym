import React from 'react';
import './App.css';
import Navbar from './main/Navbar';

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            locales: [],
        };
    }

    componentDidMount = () => {
        fetch('http://localhost:8080/i18n/locales')
            .then(response => response.json())
            .then(data => (this.setState({ locales: data })))
            .catch(function(ex) {
                console.log('parsing failed', ex)
            });
    }

    render() {
        const { locales } = this.state;
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
