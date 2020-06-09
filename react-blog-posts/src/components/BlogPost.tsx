import React from 'react';
import IBlogPost from '../models/IBlogPost';
import './BlogPost.css';

interface IBlogPostProps {
  post: IBlogPost
}

function BlogPost(props: IBlogPostProps) {
  const post = props.post
  return (
    <div className='blog-post'>
      <div className='blog-post-title'>{post.title}</div>
      <div className='blog-post-body'>{post.content}</div>
      <div className='blog-post-footer'>
        <div className='blog-author'>{`By ${post.author} at ${post.postedOn}`}</div>
        <div className='blog-tags'>
          <div key='tags-label'>Tags: </div>
          {post.tags.map(tag => <div key={tag}>{tag}</div>)}
        </div>
      </div>
    </div>
  );
}

export default BlogPost;