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

    isAuthenticated: (url, successCallback, errorCallback) => {
        fetch(process.env.REACT_APP_BACKEND_HOST + url, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            credentials: 'include',
            method: 'POST',
        }).then(successCallback).catch(errorCallback)
    },

    postWithAuthorization: (url, email, password, successCallback, errorCallback) => {
        fetch(process.env.REACT_APP_BACKEND_HOST + url, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'Authorization': 'Basic ' + btoa(unescape(encodeURIComponent((email + ':' + password)))),
            },
            credentials: 'include',
            method: 'POST',
        })
            .then(successCallback)
            .catch(errorCallback)
    },

    postWithCredentials: (url, successCallback, errorCallback) => {
        fetch(process.env.REACT_APP_BACKEND_HOST + url, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            credentials: 'include',
            method: 'POST',
        }).then(successCallback).catch(errorCallback)
    },

};

export default HttpUtils;