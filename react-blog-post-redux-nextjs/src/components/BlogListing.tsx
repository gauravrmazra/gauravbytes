import React from 'react';
import BlogSearch from './BlogSearch';
import { useSelector, useDispatch } from 'react-redux';
import { selectPostsForListing, selectShowingPostId, setShowingPost } from '../redux/reducer/blogPostsSlice';
import { IBlogPostListing } from '../models/IBlogPostListing';
import styles from './BlogPosts.module.css';

function BlogListing() {
  const posts: IBlogPostListing[] = useSelector(selectPostsForListing);
  const showingPostId = useSelector(selectShowingPostId);

  const dispatch = useDispatch();

  return(
    <div className={styles['blog-listing']}>
      <BlogSearch/>
      <ul className={styles["blog-posts"]}>
        {
          posts.map(post => <li className={showingPostId === post.id ? styles['active'] : ''} key={post.id} onClick={() => dispatch(setShowingPost(post.id))}>{post.title}</li>)
        }
      </ul>
    </div>
  );
}

export default BlogListing;