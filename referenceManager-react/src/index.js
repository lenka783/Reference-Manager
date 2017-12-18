import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import 'semantic-ui-css/semantic.min.css';
import {Provider} from 'react-redux'
import {store} from './store/configureStore';
import MyAppRouter from './router';

ReactDOM.render(<div>
    <Provider store={store}>
        <MyAppRouter>
            <App />
        </MyAppRouter>
    </Provider>
</div>, document.getElementById('root'));
registerServiceWorker();
