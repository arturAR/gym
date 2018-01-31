import * as React from 'react';
import './App.css';
import { Navbar } from './main/Navbar';

class App extends React.Component {

   /* constructor(props) {
        super(props);
        this.state = {locales: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/i18n/locales'}).done((response: any) => {
            this.setState({locales: response.entity.locales});
        });
    }
*/
    render() {
        return (
            <div className="App">
                <Navbar/>
                <p className="App-intro">
                    To get started, edit <code>src/App.tsx</code> and save to reload.
                </p>
                <span>{this.returnString('Hello World!')}</span>

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