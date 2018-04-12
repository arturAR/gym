import React from 'react';
import {withRouter} from 'react-router-dom';
import {connect} from 'react-redux';
import {Link} from 'react-router-dom';

import './Clubs.css';
import {
    requestAllClubs,
    requestClubDetails,
} from './ClubsAction';
import Club from "./Club";

const club_logo = require('./club-image.jpg');

class Clubs extends React.Component {

    componentDidMount = () => {
        this.props.requestAllClubs(this.props.langCode);
    };
    getClubDetailsHandler = (clubId, langCode) => {
        this.props.requestClubDetails(clubId, langCode);
    };

    render() {
        const {isFetchingAllClubs, clubs, location, langCode} = this.props;

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

        const locationParts = location.pathname.split('/');
        if (locationParts.length === 3 && locationParts[2]) {
            const {club} = this.props;
            return (
                <Club clubId={locationParts[2]}
                      langCode={langCode}
                      clubDetailsHandler={this.getClubDetailsHandler}
                      club={club}
                />
            );
        } else {
            const content = clubs.map((club) =>
                <div className="club" key={club.id}>
                    <Link to={'/clubs/' + club.id}>
                        <img src={club_logo}/>
                    </Link>
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
    const { langCode } = state.appReducer;

    return {
        isFetchingAllClubs,
        isFetchingAllLogos,
        isReceivedLogos,
        isFetchingClub,
        clubs,
        logos,
        club,
        langCode,
    }
};

const mapClubsDispatchToProps = dispatch => ({
    requestAllClubs: (lang) => dispatch(requestAllClubs(lang)),
    requestClubDetails: (clubId, lang) => dispatch(requestClubDetails(clubId, lang)),
});

export default withRouter(connect(mapClubsStateToProps, mapClubsDispatchToProps)(Clubs));
