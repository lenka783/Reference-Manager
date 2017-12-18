import React from 'react';
import { routes } from './routes';
import { BrowserRouter } from 'react-router-dom';
import { Container } from 'semantic-ui-react';

const MyAppRouter = ({children, basename}) => (
    <BrowserRouter basename={basename}>
        <div>
            {children}
            <Container style={styles.contentContainer}>
                {routes}
            </Container>
        </div>
    </BrowserRouter>
);

const styles = {
    contentContainer: {
        marginTop: 60
    }
};

export default MyAppRouter;
