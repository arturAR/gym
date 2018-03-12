import * as ACTION from './ClubsAction';

export const clubReducer = (state = {
                                isFetchingAllClubs: false,
                                isFetchingAllLogos: false,
                                isReceivedLogos: false,
                                isFetchingClub: false,
                                clubs: [],
                                logos: [],
                                club: {},
                            },
                            action) => {
    switch (action.type) {
        case ACTION.ALL_CLUBS_REQUEST:
            return {
                ...state,
                isFetchingAllClubs: true,
            };
        case ACTION.ALL_CLUBS_REQUEST_SUCCESS:
            return {
                ...state,
                isFetchingAllClubs: false,
                clubs: action.clubs,
            };
        case ACTION.ALL_CLUBS_REQUEST_FAILED:
            return {
                ...state,
                isFetchingAllClubs: false,
            };

        case ACTION.ALL_CLUB_LOGOS_REQUEST:
            return {
                ...state,
                isFetchingAllLogos: true,
            };
        case ACTION.ALL_CLUB_LOGOS_REQUEST_SUCCESS:
            return {
                ...state,
                isFetchingAllLogos: false,
                isReceivedLogos: true,
                logos: action.logos,
            };
        case ACTION.ALL_CLUB_LOGOS_REQUEST_FAILED:
            return {
                ...state,
                isFetchingAllLogos: false,
                logos: ['club-image'],
            };

        case ACTION.CLUB_SPECIFIED_REQUEST:
            return {
                ...state,
                isFetchingClub: true,
                club: {},
            };
        case ACTION.CLUB_SPECIFIED_REQUEST_SUCCESS:
            return {
                ...state,
                isFetchingClub: false,
                club: action.club,
            };
        case ACTION.CLUB_SPECIFIED_REQUEST_FAILED:
            return {
                ...state,
                isFetchingClub: false,
            };

            //TODO add actions for pictures
        case ACTION.CLUB_SPECIFIED_IMAGES_REQUEST:
            return {
                ...state,
            };
        case ACTION.CLUB_SPECIFIED_IMAGES_REQUEST_SUCCESS:
            return {
                ...state,
            };
        case ACTION.CLUB_SPECIFIED_IMAGES_REQUEST_FAILED:
            return {
                ...state,
            };

        default:
            return state;
    }
}