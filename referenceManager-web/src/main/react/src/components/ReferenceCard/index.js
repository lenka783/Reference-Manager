import React from 'react';
import PropTypes from 'prop-types';
import {Button, Card, List, Checkbox} from 'semantic-ui-react';
import ReferenceCardListItem from "./referenceCardListItem";
import ReferenceEdit from '../ReferenceEdit';
import referencePropType from "../../utils/referencePropTypes";

const styles = {
    checkbox: {
        position: 'absolute',
        top: '1em',
        right: '1em',
    },
    cardHeader: {
        paddingRight: '2em',
    },
    cardExtra: {
        marginTop: '1em',
    },
    cardContent: {
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'space-between',
    },
};

const ReferenceCard = ({reference, onEdit, onDelete, onSubmit}) => (
    <Card>
        <Card.Content style={styles.cardContent}>
            <Checkbox style={styles.checkbox}/>
            <Card.Header style={styles.cardHeader}>{reference.title}</Card.Header>
            <Card.Meta>{reference.authors}</Card.Meta>
            <Card.Description>
                <List>
                    <ReferenceCardListItem label='Venue:' icon='home' content={reference.venue}/>
                    <ReferenceCardListItem label='Pages:' icon='book'
                                           content={`${reference.pagesStart}-${reference.pagesEnd}`}/>
                </List>
            </Card.Description>
                <Card.Content style={styles.cardExtra} extra>
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
        </Card.Content>
    </Card>
);

ReferenceCard.propTypes = {
    reference: referencePropType,
    onEdit: PropTypes.func.isRequired,
    onDelete: PropTypes.func.isRequired
};

export default ReferenceCard
