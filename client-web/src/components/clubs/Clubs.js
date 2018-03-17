import React from 'react';
import {withRouter} from 'react-router-dom';
import {connect} from 'react-redux';

import './Clubs.css';
import {
    requestAllClubs,
    requestClubDetails,
} from './ClubsAction';

const club_logo = require('./club-image.jpg');

class Clubs extends React.Component {

    componentDidMount = () => {
        this.props.requestAllClubs(this.props.langCode);
    }

    render() {
        const {isFetchingAllClubs, clubs} = this.props;

        if (isFetchingAllClubs) {
            return (
                <div className="content-container">
                    <p className="App-intro">
                        CLUBS:
                    </p>
                    <div>Loading clubs...</div>
                </div>
            )
        }

        const content = clubs.map((club) =>
            <div className="club" key={club.id}>
                <a href={'/clubs/' + club.id}><img src={club_logo} /></a>
                <div className="club-body-short">
                    <h2>{club.clubLocal.name}</h2>
                    {club.clubLocal.description}
                    <p>{club.contactInfo.address}</p>
                </div>
            </div>
        );
        return (
            <div className="content-container">
                <p className="App-intro">
                    CLUBS:
                </p>

                <div className="clubs-container">
                    {content}
                </div>
            </div>
        );
    }
};

const mapClubsStateToProps = state => {
    const {
        isFetchingAllClubs,
        isFetchingAllLogos,
        isReceivedLogos,
        isFetchingClub,
        clubs,
        logos,
        club,
    } = state.clubsReducer;

    return {
        isFetchingAllClubs,
        isFetchingAllLogos,
        isReceivedLogos,
        isFetchingClub,
        clubs,
        logos,
        club,
    }
};

const mapClubsDispatchToProps = dispatch => ({
    requestAllClubs: (lang) => dispatch(requestAllClubs(lang)),
    requestClubDetails: (clubId, lang) => dispatch(requestClubDetails(clubId, lang)),
});

export default withRouter(connect(mapClubsStateToProps, mapClubsDispatchToProps)(Clubs));
