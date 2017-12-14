import React from 'react';
import {Button, Card, List} from 'semantic-ui-react';
import ReferenceCardListItem from "./referenceCardListItem";


const ReferenceCard = ({title, authors, venue, pagesStart, pagesEnd, onEdit, onDelete}) => (
    <Card>
        <Card.Content>
            <Card.Header>{title}</Card.Header>
            <Card.Meta>{authors}</Card.Meta>
            <Card.Description>
                <List>
                    <ReferenceCardListItem label='Venue:' icon='home' content={venue}/>
                    <ReferenceCardListItem label='Pages:' icon='book'
                                           content={`${pagesStart}-${pagesEnd}`}/>
                </List>
                <Card.Content extra>
                    <div className='ui two buttons'>
                        <Button basic color='black' onClick={onEdit}>
                            Edit
                        </Button>
                        <Button basic color='red' onClick={onDelete}>
                            Delete
                        </Button>
                    </div>
                </Card.Content>
            </Card.Description>
        </Card.Content>
    </Card>
);

export default ReferenceCard
