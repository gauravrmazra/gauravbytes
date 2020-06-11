import React from 'react';
import './BlogPost.css';
import { useSelector } from 'react-redux';
import { selectShowingPost } from '../redux/reducer/blogPostsSlice';

function BlogPost() {
  const post = useSelector(selectShowingPost);
  return !!post ? (
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
  ) : (<></>);
}

export default BlogPost;