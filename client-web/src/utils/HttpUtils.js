const HttpUtils = {
    METHOD: {
        GET: 'GET',
        POST: 'POST',
        PUT: 'PUT'
    },

    isResponseSuccess(response) {
        return response.status >= 200 && response.status < 300;
    },

    getJSON: (url, method, successCallback, errorCallback) => {
        fetch(process.env.REACT_APP_BACKEND_HOST + url, {
            method: method,
            headers: {
                'Content-Type': 'application/json',
            },
        }).then(response => {
            if (HttpUtils.isResponseSuccess(response)) {
                return response.json()
            } else {
                throw response.status
            }

        })
            .then(successCallback)
            .catch(errorCallback);
    },

    sendJSON: (url, method, json, successCallback, errorCallback) => {
        fetch(process.env.REACT_APP_BACKEND_HOST + url, {
            method: method,
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(json),
        }).then(response => {
            if (HttpUtils.isResponseSuccess(response)) {
                return response.json()
            } else {
                throw response.status
            }

        })
            .then(successCallback)
            .catch(errorCallback);
    },

    sendData: (url, data, successCallback, errorCallback) => {
        fetch(process.env.REACT_APP_BACKEND_HOST + url, {
            method: HttpUtils.METHOD.POST,
            body: data,
        }).then(successCallback).catch(errorCallback);
    },

};

export default HttpUtils;