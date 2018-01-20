import * as React from 'react';
import './App.css';
import { Navbar } from './main/Navbar';

class App extends React.Component {

    returnString(text: string) {
        return text;
    }

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
