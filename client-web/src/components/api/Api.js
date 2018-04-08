import React, {Component} from 'react';

import HttpUtils from '../../utils/HttpUtils';

export default class Api extends Component {

    /**
     * Multi upload files
     */
    _onUploadFiles() {
        let input = document.getElementById('file');

        let data = new FormData();

        for (let i = 0; i < input.files.length; i++)
            data.append('files', input.files[i]);

        HttpUtils.sendData("blob/upload", data,
            (response) => {
                if (HttpUtils.isResponseSuccess(response)) {
                    console.log('success', response.status);
                    response.json().then(json => {
                        console.log(json);
                    })
                } else
                    console.log('error', response);
            }, (response) => {
                console.log('error', response);
            })
    }

    render() {
        return (
            <div style={{margin: "20px 0 0 20px"}}>
                <input id="file" type="file" multiple/>
                <button onClick={() => this._onUploadFiles()}>Upload files</button>
                <br/>
            </div>
        )
    }
}