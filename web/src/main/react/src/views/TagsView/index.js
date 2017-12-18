import React, {Component} from 'react';
import faker from 'faker';
import _ from 'lodash';
import {Header, List} from "semantic-ui-react";


const options = [...Array(6).keys()].map(i => {
    const name = faker.hacker.adjective();
    return {
        key: name,
        text: name,
        value: name,
    }
});

const references = [...Array(10).keys()].map(i => {
    return {
        id: i,
        title: faker.lorem.words(5),
        authors: faker.name.findName(),
        venue: faker.address.streetAddress(),
        pagesStart: faker.random.number(),
        pagesEnd: faker.random.number(),
    }
});

export class TagsView extends Component {
    render() {
        return (
            <div>
                <Header as='h1'>Collections</Header>
                <List selection verticalAlign='middle'>
                    <List.Item>
                        <List.Content>
                            <List.Header>Helen</List.Header>
                        </List.Content>
                    </List.Item>
                    <List.Item>

                        <List.Content>
                            <List.Header>Christian</List.Header>
                        </List.Content>
                    </List.Item>
                    <List.Item>
                        <List.Content>
                            <List.Header>Daniel</List.Header>
                        </List.Content>
                    </List.Item>
                </List>

            </div>

        );
    }
}
