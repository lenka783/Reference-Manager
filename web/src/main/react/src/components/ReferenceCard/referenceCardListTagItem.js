
import React from 'react';
import { Label, List } from 'semantic-ui-react';
import _ from 'lodash';

const styles = {
    listContainer: {
        display: 'flex',
        flexDirection: 'row'
    },
    listContent: {
        marginTop: 3
    }
};

const ReferenceCardListTagItem = ({tags}) => (
    <List.Item>
        <List.Content style={styles.listContainer}>
            <div style={styles.listContent}>
                <Label.Group>
                    {_.map(tags, tag => (
                        <Label tag key={tag.id}>
                            {tag.name}
                        </Label>
                    ))}
                </Label.Group>
            </div>
        </List.Content>
    </List.Item>);

export default ReferenceCardListTagItem;
