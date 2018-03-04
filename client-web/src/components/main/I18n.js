import React from 'react';
import './I18n.css'

const logo_en = require('./I18nLogos/flag_en.png');
const logo_pl = require('./I18nLogos/flag_pl.png');
const logo_ru = require('./I18nLogos/flag_ru.png');

export default class I18n extends React.Component {

    render() {
        const {changeLocalHandler} = this.props;
        return (
            <div className="flags-container">
                <div className="flags-container">
                    <img src={logo_en} alt="English" onClick={(e) => changeLocalHandler("EN")}/>
                    <img src={logo_pl} alt="Polish" onClick={(e) => changeLocalHandler("PL")}/>
                </div>
            </div>
        )
    }
};
