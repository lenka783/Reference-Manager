import MyAppRouter from './configureRouter';
import React from 'react';

let router;
if (process.env.NODE_ENV === 'production') {
    router = ({children}) => (
        <MyAppRouter basename="/pa165">
            {children}
        </MyAppRouter>
    );
} else {
    router = ({children}) => (
        <MyAppRouter basename="">
            {children}
        </MyAppRouter>
    );
}

export default router;
