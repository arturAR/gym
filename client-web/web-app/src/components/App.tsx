import * as React from 'react';
import './App.css';
import { Navbar } from './main/Navbar';

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {locales: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/i18n/locales'}).done((response: any) => {
            this.setState({locales: response.entity.locales});
        });
    }

    render() {
        return (
            <div className="App">
                <Navbar/>
                <p className="App-intro">
                    To get started, edit <code>src/App.tsx</code> and save to reload.
                </p>
                <span>{this.returnString('Hello World!')}</span>


                var languages = this.props.languages.map(language =>
                    <Locale key={language.languageCode} language={language}/>
                );
                <table>
                    <tbody>
                    <tr>
                        <th>LANG_CODE</th>
                        <th>LANGUAGE</th>
                        <th>COUNTRY</th>
                    </tr>
                    {languages}
                    </tbody>
                </table>
                )
            </div>
        );
    }
}

export default App;
