import React, { useEffect } from 'react';
import IBlogPost from '../models/IBlogPost';
import './BlogPosts.css';
import BlogListing from './BlogListing';
import BlogPost from './BlogPost';
import { useDispatch } from 'react-redux';
import { setPostsAsync, setShowingPostsAsync } from '../redux/reducer/blogPostsSlice';

interface IBlogPostsProps {
  posts: Array<IBlogPost>
}

function BlogPosts(props: IBlogPostsProps) {
  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(setPostsAsync(props.posts))
    dispatch(setShowingPostsAsync(props.posts && props.posts.length > 0 ? props.posts[0].id : 0))
  }, [props.posts, dispatch]);

  return (
    <div className="blog-container">
      <BlogListing/>
      <BlogPost/>
    </div>
  );
}

export default BlogPosts;