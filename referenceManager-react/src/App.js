import React from 'react'
import {connect} from 'react-redux';
import {push} from 'react-router-redux';
import {Container, Menu} from 'semantic-ui-react'
import {HOME_PATH, REFERENCES_PATH} from "./routes";


class App extends React.Component {


    goHome = () => {
        this.props.dispatch(push(HOME_PATH))
    };

    goToReferences = () => {
        this.props.dispatch(push(REFERENCES_PATH))
    };

    render() {
        const homeActive = this.props.location && this.props.location.pathname === HOME_PATH;
        const referencesActive = this.props.location && this.props.location.pathname === REFERENCES_PATH;

        return (
            <div>
                <Menu fixed='top' inverted>
                    <Container>
                        <Menu.Item as='a' header onClick={this.goHome}>
                            Reference Manager
                        </Menu.Item>
                        <Menu.Item as='a' onClick={this.goHome} active={homeActive}>
                            Home
                        </Menu.Item>
                        <Menu.Item as='a' onClick={this.goToReferences} active={referencesActive}>
                            References
                        </Menu.Item>
                    </Container>
                </Menu>

                <Container style={{marginTop: '7em'}}>
                    {this.props.children}
                </Container>
            </div>
        );
    }
}

const mapStateToProps = (state, ownProps) => {
    return {
        location: state.router.location,
    };
};

export default connect(mapStateToProps)(App);
