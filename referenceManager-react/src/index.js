import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import 'semantic-ui-css/semantic.min.css';
import {Provider} from 'react-redux'

import {ConnectedRouter} from 'react-router-redux'
import {routes} from "./routes";
import {store, history} from './store/configureStore';

ReactDOM.render(<div>
    <Provider store={store}>
        <App>
            <ConnectedRouter history={history}>
                {routes}
            </ConnectedRouter>
        </App>
    </Provider>
</div>, document.getElementById('root'));
registerServiceWorker();
