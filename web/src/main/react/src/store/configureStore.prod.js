import { applyMiddleware, combineReducers, createStore } from 'redux';
import { reducer as formReducer } from 'redux-form';
import rest from '../rest';
import thunk from 'redux-thunk';

const reducer = combineReducers({
    form: formReducer,
    ...rest.reducers
});

const createStoreWithMiddleware = applyMiddleware(thunk)(createStore);
const store =  createStoreWithMiddleware(reducer);

export { store };
