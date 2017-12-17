import React from 'react';
import PropTypes from 'prop-types';
import {Button, Card, List} from 'semantic-ui-react';
import ReferenceCardListItem from "./referenceCardListItem";
import ReferenceEdit from '../ReferenceEdit';
import referencePropType from "../../utils/referencePropTypes";


const ReferenceCard = ({reference, onEdit, onDelete, onSubmit}) => (
    <Card>
        <Card.Content>
            <Card.Header>{reference.title}</Card.Header>
            <Card.Meta>{reference.authors}</Card.Meta>
            <Card.Description>
                <List>
                    <ReferenceCardListItem label='Venue:' icon='home' content={reference.venue}/>
                    <ReferenceCardListItem label='Pages:' icon='book'
                                           content={`${reference.pagesStart}-${reference.pagesEnd}`}/>
                </List>
                <Card.Content extra>
                    <div className='ui two buttons'>
                        <ReferenceEdit reference={reference}
                                       onSubmit={onEdit}
                                       headerText='Edit reference'>
                            Edit
                        </ReferenceEdit>

                        <Button basic color='red' onClick={onDelete}>
                            Delete
                        </Button>
                    </div>
                </Card.Content>
            </Card.Description>
        </Card.Content>
    </Card>
);

ReferenceCard.propTypes = {
    reference: referencePropType,
    onEdit: PropTypes.func.isRequired,
    onDelete: PropTypes.func.isRequired
};

export default ReferenceCard
