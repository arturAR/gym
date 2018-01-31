import React from 'react';
import './I18n.css'
import Button from 'material-ui/Button';
import Menu, { MenuItem } from 'material-ui/Menu';

const logo_en = require('./I18nLogos/flag_en.png');
const logo_pl = require('./I18nLogos/flag_pl.png');
const logo_ru = require('./I18nLogos/flag_ru.png');


class I18n extends React.Component {
    state = {
        anchorEl: null,
    };

    handleClick = event => {
        this.setState({ anchorEl: event.currentTarget });
    };

    handleClose = () => {
        this.setState({ anchorEl: null });
    };

    render() {
        const { anchorEl } = this.state;

        return (
            <div>
                <Button
                    aria-owns={anchorEl ? 'simple-menu' : null}
                    aria-haspopup="true"
                    onClick={this.handleClick}
                >
                    Choose Language
                </Button>
                <Menu
                    id="simple-menu"
                    anchorEl={anchorEl}
                    open={Boolean(anchorEl)}
                    onClose={this.handleClose}
                >
                    <MenuItem onClick={this.handleClose}><img src={logo_en} alt="English"/>English</MenuItem>
                    <MenuItem onClick={this.handleClose}><img src={logo_pl} alt="Polish"/>Polish</MenuItem>
                    <MenuItem onClick={this.handleClose}><img src={logo_ru} alt="Russian"/>Russian</MenuItem>
                </Menu>
            </div>
        );
    }
}

export default I18n;

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