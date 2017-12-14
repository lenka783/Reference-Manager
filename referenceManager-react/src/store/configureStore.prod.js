import createHistory from "history/createBrowserHistory";
import {applyMiddleware, combineReducers, createStore} from "redux";
import {routerMiddleware, routerReducer} from "react-router-redux";
import {reducer as formReducer} from "redux-form";

const history = createHistory({basename: '/pa165'});
const middleware = routerMiddleware(history);

const store = createStore(
    combineReducers({
        router: routerReducer,
        form: formReducer
    }),
    applyMiddleware(middleware)
);

export {store, history};
