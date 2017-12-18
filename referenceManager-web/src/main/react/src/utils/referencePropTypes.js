import PropTypes from 'prop-types';

const referencePropType = PropTypes.shape({
        title: PropTypes.string.isRequired,
        authors: PropTypes.string.isRequired,
        venue: PropTypes.string.isRequired,
        pagesStart: PropTypes.number.isRequired,
        pagesEnd: PropTypes.number.isRequired,
    }).isRequired;

export default referencePropType
