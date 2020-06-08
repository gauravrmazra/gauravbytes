import React from 'react';
import IBlogPost from '../models/IBlogPost';
import './BlogPosts.css';

interface IBlogPostsProps {
  posts: Array<IBlogPost>
}


function BlogPosts(props: IBlogPostsProps) {
  return (
    <div className="blog-container">
      <ul className="blog-posts">
        {
          props.posts.map(post => <li key={post.id}>{post.title}</li>)
        }
      </ul>
    </div>
  );
}

export default BlogPosts;