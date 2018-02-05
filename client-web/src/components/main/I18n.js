import React from 'react';
import './I18n.css'

const logo_en = require('./I18nLogos/flag_en.png');
const logo_pl = require('./I18nLogos/flag_pl.png');
const logo_ru = require('./I18nLogos/flag_ru.png');


export const I18n = () => {
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
};

/*
export const I18n = () => {
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
       <Dropdown>
            <DropdownTrigger>
                <img src={logo_en} alt="language"/> Language
            </DropdownTrigger>
            <DropdownContent>
                <ul>
                    <li>
                        <img src={logo_en} alt="English"/>
                        <a href="/api/en">English</a>
                    </li>
                    <li>
                        <img src={logo_pl} alt="Polish"/>
                        <a href="/api/pl">Polish</a>
                    </li>
                    <li>
                        <img src={logo_ru} alt="Russian"/>
                        <a href="/api/ru">Russian</a>
                    </li>
                </ul>
            </DropdownContent>
        </Dropdown>
    );
};*/