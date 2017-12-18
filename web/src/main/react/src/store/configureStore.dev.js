import { applyMiddleware, combineReducers, createStore } from 'redux';
import { composeWithDevTools } from 'redux-devtools-extension';
import { reducer as formReducer } from 'redux-form';
import thunk from 'redux-thunk';
import rest from '../rest';

const middlewareWithDevTools = composeWithDevTools(
    applyMiddleware()
);

const createStoreWithMiddleware = applyMiddleware(thunk)(createStore);
const reducer = combineReducers({
    form: formReducer,
    ...rest.reducers
});

const store = createStoreWithMiddleware(reducer, middlewareWithDevTools);

export { store };
