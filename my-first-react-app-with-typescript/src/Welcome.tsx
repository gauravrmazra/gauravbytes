import React from 'react';

interface IWelcomeProps {
  message?: string
}

function Welcome(props: IWelcomeProps) {
  const message = props?.message ?? 'Welcome! My first React app with Typescript.'
return (<div className='welcome'>{message}</div>);
}

export default Welcome;