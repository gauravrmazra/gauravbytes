import React from 'react';
import './Welcome.css';

interface IWelcomeProps {
  message?: string
}

function Welcome(props: IWelcomeProps) {
  const message = props?.message ?? 'Welcome! My first React app with Typescript.'
return (<div className='welcome'>{message}</div>);
}

export default Welcome;