import * as React from 'react';

export default class Content extends React.Component {

    componentDidMount = () => {
        const {clubId, langCode, clubDetailsHandler} = this.props;
        if (clubId && langCode) {
            clubDetailsHandler(clubId, langCode);
        }
    };

    render() {
        const {clubId, club} = this.props;

        if (!club.id || club.id != clubId) {
            return (<div>Loading club...</div>);
        }

        return (
            <div className="club">
                {club.clubLocal.name}
                <br/>
                {club.contactInfo.address}
            </div>
        );
    };
}