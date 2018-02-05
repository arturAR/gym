import * as React from 'react';
import './App.css';
import { Navbar } from './main/Navbar';

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {locales: []};
    }

    componentDidMount() {
        fetch('http://localhost:8080/i18n/locales')
            .then(function(response) {
                //this.setState({locales: response.json()});
                console.log(response);
                return response.json()
            }).then(function(json) {
            console.log('parsed json', json)
        }).catch(function(ex) {
            console.log('parsing failed', ex)
        });
    }

    render() {
        return (
            <div className="App">
                <Navbar/>
                <p className="App-intro">
                    To get started, edit <code>src/App.js</code> and save to reload.
                </p>
                <span>{'Hello World!'}</span>

            </div>
        );
    }
}

export default App;


/*

// TODO move to empty line below "Hello World" span
    var locales = this.props.locales.map(locale =>
                    <Locale key={locale.languageCode} locale={locale}/>
                );
                <table>
                    <tbody>
                    <tr>
                        <th>LANG_CODE</th>
                        <th>LANGUAGE</th>
                        <th>COUNTRY</th>
                    </tr>
                    {locales}
                    </tbody>
                </table>


*/