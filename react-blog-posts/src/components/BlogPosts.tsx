import React, { useState } from 'react';
import IBlogPost from '../models/IBlogPost';
import './BlogPosts.css';
import BlogListing from './BlogListing';
import BlogPost from './BlogPost';

interface IBlogPostsProps {
  posts: Array<IBlogPost>
}


function BlogPosts(props: IBlogPostsProps) {
  const firsBlogPost = props.posts && props.posts.length > 0 ? props.posts[0] : null;
  const [ selectedBlogPost, setSelectedBlogPost ] = useState<IBlogPost | null>(firsBlogPost);

  function onBlogPostLinkClick(id: number): void {
    const selectedBlogPost = props.posts.find(post => post.id === id);
    setSelectedBlogPost(!!selectedBlogPost ? selectedBlogPost : null);
  }

  return (
    <div className="blog-container">
      <BlogListing
        selectedBlogPost={selectedBlogPost?.id ?? 0}
        blogPosts={props.posts.map(post => { return {id: post.id, title: post.title }})}
        onClick={onBlogPostLinkClick}
      />
      {!!selectedBlogPost ? <BlogPost post={selectedBlogPost}/>: null }
    </div>
  );
}

export default BlogPosts;