import _ from 'lodash';

const optionsFromTags = (tags) => {
    return _.map(tags, tag => {
        return {
            key: tag.id,
            value: tag.id,
            text: tag.name,
        }
    })
};

export { optionsFromTags };
