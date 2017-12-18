import { applyMiddleware, combineReducers, createStore } from 'redux';
import { composeWithDevTools } from 'redux-devtools-extension';
import { reducer as formReducer } from 'redux-form';

const middlewareWithDevTools = composeWithDevTools(
    applyMiddleware()
);

const store = createStore(
    combineReducers({
        form: formReducer
    }),
    middlewareWithDevTools
);

export { store };
