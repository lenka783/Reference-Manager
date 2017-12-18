import React, {Component} from 'react';
import {Card} from 'semantic-ui-react'
import faker from 'faker';
import _ from 'lodash';
import ReferenceCard from "../../components/ReferenceCard";

const references = [...Array(20).keys()].map(i => {
    return {
        id: i,
        title: faker.lorem.words(5),
        authors: faker.name.findName(),
        venue: faker.address.streetAddress(),
        pagesStart: faker.random.number(),
        pagesEnd: faker.random.number(),
    }
});

export class ReferencesView extends Component {
    editReference = (id) => (values) => {
        console.log(`Edited reference with id ${id} and values `, values)
    };

    deleteReference = (id) => () => {
        console.log(`Deleted reference with id ${id}`)
    };

    render() {
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
