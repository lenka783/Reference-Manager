import React, {Component} from 'react';
import ReferenceCard from "../../components/ReferenceCard";
import {Card} from 'semantic-ui-react'
import faker from 'faker';
import _ from 'lodash';

const references = [...Array(20).keys()].map(i => {
    return {
        id: i,
        title: faker.lorem.words(),
        authors: faker.name.findName(),
        venue: faker.address.streetAddress(),
        pagesStart: faker.random.number(),
        pagesEnd: faker.random.number(),
    }
});

export class ReferencesView extends Component {
    editReference = (id) => () => {
        console.log(`Edited reference with id ${id}`)
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
                                       title={reference.title}
                                       authors={reference.authors}
                                       venue={reference.venue}
                                       pagesStart={reference.pagesStart}
                                       pagesEnd={reference.pagesEnd}
                                       onEdit={this.editReference(reference.id)}
                                       onDelete={this.deleteReference(reference.id)}
                        />
                    ))}
                </Card.Group>
            </div>
        );
    }
}
