import React from 'react';
import { Route, Switch } from 'react-router';
import { HomeView, ReferencesView } from '../views/index';

const HOME_PATH = '/';
const REFERENCES_PATH = '/references';

const routes = (
    <Switch>
        <Route exact path={HOME_PATH} component={HomeView}/>
        <Route path={REFERENCES_PATH} component={ReferencesView}/>
    </Switch>
);

export { routes, HOME_PATH, REFERENCES_PATH };
