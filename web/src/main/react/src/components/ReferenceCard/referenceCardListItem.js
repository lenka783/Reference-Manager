import React from 'react';
import {Icon, Label, List} from 'semantic-ui-react';

const styles = {
    listContainer: {
        display: 'flex',
        flexDirection: 'row'
    },
    listLabel: {
        marginRight: 10
    },
    listContent: {
        marginTop: 3
    }
};

const ReferenceCardListItem = ({label, icon, content}) => (
    <List.Item>
        <List.Content style={styles.listContainer}>
            <Label style={styles.listLabel}>
                <Icon name={icon}/>
                {label}
            </Label>
            <div style={styles.listContent}>
                {content}
            </div>
        </List.Content>
    </List.Item>);

export default ReferenceCardListItem;
