
import PropTypes from 'prop-types';

const referencePropType = PropTypes.shape({
    id: PropTypes.number.isRequired,
    title: PropTypes.string.isRequired,
    authors: PropTypes.string.isRequired,
    venue: PropTypes.string.isRequired,
    pagesStart: PropTypes.number.isRequired,
    pagesEnd: PropTypes.number.isRequired,
    notes: PropTypes.string.isRequired,
    tags: PropTypes.arrayOf(PropTypes.shape({
        id: PropTypes.number.isRequired,
        name: PropTypes.string.isRequired
    })).isRequired
});

export default referencePropType;
