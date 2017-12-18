import React, {Component} from 'react';
import {Card} from 'semantic-ui-react'
import faker from 'faker';
import _ from 'lodash';
import ReferenceCard from "../../components/ReferenceCard";
import { connect } from 'react-redux';
import PropTypes from 'prop-types';
import rest from '../../rest';

const tags = [...Array(10).keys()].map(i => {
    return {
        id: i,
        name: faker.lorem.words(1)
    }
});

const references = [...Array(20).keys()].map(i => {
    return {
        id: i,
        title: faker.lorem.words(5),
        authors: faker.name.findName(),
        venue: faker.address.streetAddress(),
        pagesStart: faker.random.number(),
        pagesEnd: faker.random.number(),
        notes: i / 2 === 0 ? faker.lorem.words(30) : '',
        tags: tags.slice(faker.random.number({min: 0, max: 1}), faker.random.number({min: 1, max: 9}))
    }
});


class ReferencesView extends Component {
    componentDidMount() {
        const {dispatch} = this.props;
        dispatch(rest.actions.tags.sync())
    }

    editReference = (id) => (values) => {
        console.log(`Edited reference with id ${id} and values `, values)
    };

    deleteReference = (id) => () => {
        console.log(`Deleted reference with id ${id}`)
    };

    render() {
        const {tags} = this.props;
        if (tags.loading || !tags.data) {
            return (<div>
                Loading data...
            </div>)
        }
        return (
            <div>
                <Card.Group>
                    {_.map(references, reference => (
                        <ReferenceCard key={reference.id}
                                       reference={reference}
                                       onEdit={this.editReference(reference.id)}
                                       onDelete={this.deleteReference(reference.id)}
                        />
                    ))}
                </Card.Group>
            </div>
        );
    }
}

ReferencesView.propTypes = {
    tags: PropTypes.shape({
        loading: PropTypes.bool.isRequired,
        data: PropTypes.shape.isRequired
    }),
    dispatch: PropTypes.func.isRequired
};

const mapStateToProps = (state) => {
    return {
        tags: state.tags
    }};

const ConnectedReferencesView = connect(mapStateToProps)(ReferencesView);

export { ConnectedReferencesView as ReferencesView}
