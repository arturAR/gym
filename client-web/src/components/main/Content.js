import React from 'react';
import './Content.css';

export default class Content extends React.Component {

    render() {
        const {i18n, locales} = this.props;
        return (
            <div className="content-container">
                <b>{i18n['content.i18n.languages']}:</b>
                <div>
                    {locales.map(locale =>
                        <div key={locale.languageCode}>
                            {locale.language} + {locale.languageCode} + {locale.country}
                        </div>
                    )}
                </div>
            </div>
        );
    }
};