import React from 'react';
import logo from './gaurav-bytes.png';
import './App.css';
import Welcome from './Welcome';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <Welcome />
        <Welcome message="Welcome Reader! My first react app with Typescript."/>
      </header>
    </div>
  );
}

export default App;
