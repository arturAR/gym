import HttpUtils from "../../utils/HttpUtils";
import ExternalUrls from "../../constants/ExternalUrls";

export const ALL_CLUBS_REQUEST = 'ALL_CLUBS_REQUEST';
export const ALL_CLUBS_REQUEST_SUCCESS = 'ALL_CLUBS_REQUEST_SUCCESS';
export const ALL_CLUBS_REQUEST_FAILED = 'ALL_CLUBS_REQUEST_FAILED';

export const ALL_CLUB_LOGOS_REQUEST = 'ALL_CLUB_LOGOS_REQUEST';
export const ALL_CLUB_LOGOS_REQUEST_SUCCESS = 'ALL_CLUB_LOGOS_REQUEST_SUCCESS';
export const ALL_CLUB_LOGOS_REQUEST_FAILED = 'ALL_CLUB_LOGOS_REQUEST_FAILED';

export const CLUB_SPECIFIED_REQUEST = 'CLUB_SPECIFIED_REQUEST';
export const CLUB_SPECIFIED_REQUEST_SUCCESS = 'CLUB_SPECIFIED_REQUEST_SUCCESS';
export const CLUB_SPECIFIED_REQUEST_FAILED = 'CLUB_SPECIFIED_REQUEST_FAILED';

export const CLUB_SPECIFIED_IMAGES_REQUEST = 'CLUB_SPECIFIED_IMAGES_REQUEST';
export const CLUB_SPECIFIED_IMAGES_REQUEST_SUCCESS = 'CLUB_SPECIFIED_IMAGES_REQUEST_SUCCESS';
export const CLUB_SPECIFIED_IMAGES_REQUEST_FAILED = 'CLUB_SPECIFIED_IMAGES_REQUEST';

export const requestAllClubs = () => (dispatch, getState) => {
    if(getState().clubsReducer.isFetchingAllClubs) {
        return;
    }
    dispatch({type: ALL_CLUBS_REQUEST});
    return HttpUtils.getJSON(ExternalUrls.CLUBS_ALL, HttpUtils.METHOD.GET,
        (clubs) => dispatch({type: ALL_CLUBS_REQUEST_SUCCESS, clubs}),
        (error) => dispatch({type: ALL_CLUBS_REQUEST_FAILED, error: error}));
};

export const requestAllLogos = () => (dispatch, getState) => {
    if(getState().clubsReducer.isFetchingAllLogos) {
        return;
    }
    dispatch({type: ALL_CLUB_LOGOS_REQUEST});
    return HttpUtils.getJSON(ExternalUrls.CLUB_LOGOS_ALL, HttpUtils.METHOD.GET,
        (logos) => dispatch({type: ALL_CLUB_LOGOS_REQUEST_SUCCESS, logos}),
        (error) => dispatch({type: ALL_CLUB_LOGOS_REQUEST_FAILED, error: error}));
};

export const requestClubDetails = (clubId) => (dispatch, getState) => {
    if(getState().clubsReducer.isFetchingClub) {
        return;
    }
    dispatch({type: CLUB_SPECIFIED_REQUEST});
    return HttpUtils.getJSON(ExternalUrls.CLUB + '/' + clubId, HttpUtils.METHOD.GET,
        (club) => dispatch({type: CLUB_SPECIFIED_REQUEST_SUCCESS, club}),
        (error) => dispatch({type: CLUB_SPECIFIED_REQUEST_FAILED, error: error}));
};

export const requestClubPictures = (blobId) => (dispatch, getState) => {
    //TODO ask about club logo/pictures from club
};
