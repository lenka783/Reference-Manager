import React from 'react';
import { UploadField } from 'react-semantic-redux-form';
import { Field, Form, reduxForm } from 'redux-form';

class ReferenceImport extends React.Component {
    render () {
        const {handleSubmit} = this.props;
        return (
                    <Form onSubmit={handleSubmit}>
                        <Field name='importReferences' component={UploadField}/>
                    </Form>
        );
    }
}

const ReferenceImportForm = reduxForm({
    form: 'ReferenceImport'
})(ReferenceImport);

export default ReferenceImportForm;
