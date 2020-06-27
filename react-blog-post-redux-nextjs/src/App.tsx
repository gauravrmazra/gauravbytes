import React from 'react';
import styles from './App.module.css';
import BlogPosts from './components/BlogPosts';

function App() {
  return (
    <div className={styles['App-Container']}>
      <BlogPosts />
    </div>
  );
}

export default App;
