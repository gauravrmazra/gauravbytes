import React from 'react';
import styles from './BlogPost.module.css';
import { useSelector } from 'react-redux';
import { selectShowingPost } from '../redux/reducer/blogPostsSlice';

function BlogPost() {
  const post = useSelector(selectShowingPost);
  return !!post ? (
    <div className={styles['blog-post']}>
      <div className={styles['blog-post-title']}>{post.title}</div>
      <div className={styles['blog-post-body']}>{post.content}<a href={post.postUrl}>Read more</a></div>
      <div className={styles['blog-post-footer']}>
        <div className={styles['blog-author']}>{`By ${post.author} at ${post.postedOn}`}</div>
        <div className={styles['blog-tags']}>
          <div key='tags-label'>Tags: </div>
          {post.tags.map(tag => <div key={tag}>{tag}</div>)}
        </div>
      </div>
    </div>
  ) : (<></>);
}

export default BlogPost;