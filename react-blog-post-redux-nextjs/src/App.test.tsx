import React from 'react';
import { render } from '@testing-library/react';
import App from './App';
import { Provider } from 'react-redux';
import { store } from './redux/store';

test('renders learn react link', () => {
  const component = render(<App />, {
    wrapper: ({children}) => <Provider store={store}>{children}></Provider>
  });
  expect(component.baseElement).toBeInTheDocument();
});
