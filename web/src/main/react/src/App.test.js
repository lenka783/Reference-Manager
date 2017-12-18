import React from 'react';
import ReactDOM from 'react-dom';
import MyAppRouter from './router';
import App from './App';

it('renders without crashing', () => {
  const div = document.createElement('div');
    ReactDOM.render(<MyAppRouter><App /></MyAppRouter>, div);
});
