import React from 'react';

import './Clubs.css';
const club_logo = require('./club-image.jpg');

export default class Content extends React.Component {

    render() {
        const {i18n, locales} = this.props;
        return (
            <div className="content-container">
                <p className="App-intro">
                    CLUBS:
                </p>

                <div className="clubs-container">
                    <div className="club">
                        <a href="/clubs/1"><img src={club_logo} alt="first club" /></a>
                        <div className="club-body-short">
                            <h2>CLUB NAME</h2>
                            CLUB DESCRIPTION:
                        </div>
                    </div>
                    <div className="club">
                        <a href="/clubs/2"><img src={club_logo} alt="second club" /></a>
                        <div className="club-body-short"></div>
                    </div>
                    <div className="club">
                        <a href="/clubs/3"><img src={club_logo} alt="third club" /></a>
                        <div className="club-body-short"></div>
                    </div>
                    <div className="club">
                        <a href="/clubs/4"><img src={club_logo} alt="fourth club" /></a>
                        <div className="club-body-short"></div>
                    </div>
                    <div className="club">
                        <a href="/clubs/5"><img src={club_logo} alt="fifth club" /></a>
                        <div className="club-body-short"></div>
                    </div>
                    <div className="club">
                        <a href="/clubs/6"><img src={club_logo} alt="sixth club" /></a>
                        <div className="club-body-short"></div>
                    </div>
                </div>
            </div>
        );
    }
};