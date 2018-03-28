import React, {Component} from 'react';
import {connect} from 'react-redux';

import SignOutButton from "../../components/SignOutButton";

class Dashboard extends Component {

    render() {
        return (
            <div>
                <SignOutButton dispatch={this.props.dispatch}/>
                <br/>
                <div>CMS dashboard</div>
            </div>
        )
    }
}

export default connect()(Dashboard);