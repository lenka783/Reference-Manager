import createHistory from "history/createBrowserHistory";
import {applyMiddleware, combineReducers, createStore} from "redux";
import {routerMiddleware, routerReducer} from "react-router-redux";
import {composeWithDevTools} from "redux-devtools-extension";


const history = createHistory();
const middleware = routerMiddleware(history);
const middlewareWithDevTools = composeWithDevTools(
    applyMiddleware(middleware)
);

const store = createStore(
    combineReducers({
        router: routerReducer
    }),
    middlewareWithDevTools
);

export { store, history };
