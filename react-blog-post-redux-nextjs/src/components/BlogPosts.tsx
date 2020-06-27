import React from 'react';
import styles from './BlogPosts.module.css';
import BlogListing from './BlogListing';
import BlogPost from './BlogPost';


function BlogPosts() {
  return (
    <div className={styles["blog-container"]}>
      <BlogPost/>
      <BlogListing/>
    </div>
  );
}

export default BlogPosts;