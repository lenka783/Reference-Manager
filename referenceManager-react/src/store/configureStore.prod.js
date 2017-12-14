import createHistory from "history/createBrowserHistory";
import {applyMiddleware, combineReducers, createStore} from "redux";
import {routerMiddleware, routerReducer} from "react-router-redux";

const history = createHistory({ basename: '/pa165'});
const middleware = routerMiddleware(history);

const store = createStore(
    combineReducers({
        router: routerReducer
    }),
    applyMiddleware(middleware)
);

export {store, history};
