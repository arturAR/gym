import React from 'react';

import './Clubs.css';

export default class Content extends React.Component {

    render() {
        const {i18n, locales} = this.props;
        return (
            <div className="content-container">
                <p className="App-intro">
                    CLUBS:
                </p>
            </div>

        );
    }
};