import React from 'react';
import BlogSearch from './BlogSearch';
import { useSelector, useDispatch } from 'react-redux';
import { selectPostsForListing, selectShowingPostId, setShowingPost } from '../redux/reducer/blogPostsSlice';
import { IBlogPostListing } from '../models/IBlogPostListing';

function BlogListing() {
  const posts: IBlogPostListing[] = useSelector(selectPostsForListing);
  const showingPostId = useSelector(selectShowingPostId);

  const dispatch = useDispatch();

  return(
    <div className='blog-listing'>
      <BlogSearch/>
      <ul className="blog-posts">
        {
          posts.map(post => <li className={showingPostId === post.id ? 'active' : ''} key={post.id} onClick={() => dispatch(setShowingPost(post.id))}>{post.title}</li>)
        }
      </ul>
    </div>
  );
}

export default BlogListing;