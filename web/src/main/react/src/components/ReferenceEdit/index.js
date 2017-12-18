import React from 'react';
import PropTypes from 'prop-types';
import { Button, Form, Modal } from 'semantic-ui-react';
import { InputField } from 'react-semantic-redux-form';
import { Field, reduxForm } from 'redux-form';
import referencePropType from '../../utils/referencePropTypes';

// This sets the initial values in the edit form
const ReferenceEditContainer = ({children, reference, headerText, submitButtonText, onSubmit}) => (
    <ReferenceEditForm reference={reference}
                       initialValues={{
                           title: reference.title,
                           authors: reference.authors,
                           venue: reference.venue,
                           pagesStart: reference.pagesStart,
                           pagesEnd: reference.pagesEnd
                       }}
                       onSubmit={onSubmit}
                       headerText={headerText}
                       submitButtonText={submitButtonText}>
        {children}
    </ReferenceEditForm>
);

class ReferenceEdit extends React.Component {
    state = {modalOpen: false};
    handleOpen = () => this.setState({modalOpen: true});
    handleClose = () => this.setState({modalOpen: false});

    openModalButton = () => (
        <Button basic color='black' onClick={this.handleOpen}>
            {this.props.children}
        </Button>
    );

    render () {
        const {handleSubmit, headerText} = this.props;
        return (
            <Modal trigger={this.openModalButton()}
                   open={this.state.modalOpen}
                   onClose={this.handleClose}
                   closeIcon>
                <Modal.Header>
                    {headerText}
                </Modal.Header>
                <Modal.Content>
                    <Form onSubmit={handleSubmit}>
                        <Field name='title' component={InputField}
                               label='Title'/>

                        <Field name='authors' component={InputField}
                               label='Authors'/>

                        <Field name='venue' component={InputField}
                               label='Venue'/>

                        <Field name='pagesStart' component={InputField}
                               label='From page'/>

                        <Field name='pagesEnd' component={InputField}
                               label='To page'/>

                        <Button fluid
                                color='green'
                                onClick={this.handleClose}>
                            Submit</Button>
                    </Form>
                </Modal.Content>
            </Modal>
        );
    }
}

const props = {
    reference: referencePropType,
    children: PropTypes.node.isRequired,
};

ReferenceEdit.propTypes = {
    handleSubmit: PropTypes.func.isRequired,
    ...props
};
ReferenceEditContainer.propTypes = {
    onSubmit: PropTypes.func.isRequired,
    ...props
};

const ReferenceEditForm = reduxForm({
    form: 'ReferenceEdit'
})(ReferenceEdit);

export default ReferenceEditContainer;
