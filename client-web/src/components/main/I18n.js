import React from 'react';
import './I18n.css'

const logo_en = require('./I18nLogos/flag_en.png');
const logo_pl = require('./I18nLogos/flag_pl.png');
const logo_ru = require('./I18nLogos/flag_ru.png');


class I18n extends React.Component {

    constructor() {
        super();
        this.state = {
            "nav.i18n.polish": 'About',
            "nav.i18n.english": 'Clubs',
        };
    }
    render() {
        return (
            <div className="flags-container">
                <a href="/api/en">
                    <img src={logo_en} alt="English"/>
                </a>
                <a href="/api/pl">
                    <img src={logo_pl} alt="Polish"/>
                </a>
                <a href="/api/ru">
                    <img src={logo_ru} alt="Russian"/>
                </a>
            </div>
        )
    }
};

export default I18n;
