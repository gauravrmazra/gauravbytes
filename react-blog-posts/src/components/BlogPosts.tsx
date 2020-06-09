import React, { useState } from 'react';
import IBlogPost from '../models/IBlogPost';
import './BlogPosts.css';
import BlogListing from './BlogListing';
import BlogPost from './BlogPost';
import { SearchType } from '../models/SearchType';

interface IBlogPostsProps {
  posts: Array<IBlogPost>
}


function BlogPosts(props: IBlogPostsProps) {
  function findFirstPost(posts: Array<IBlogPost>) : IBlogPost | null {
    return posts && posts.length > 0 ? posts[0] : null;
  }

  const [ posts, setPosts ] = useState(props.posts)
  const [ showingPost, setShowingPost ] = useState<IBlogPost | null>(findFirstPost(posts));
  const [ searchText, setSearchText ] = useState<string>('');
  const [ selectedSearchOn, setSelectedSearchOn ] = useState<string>('tag')

  function onBlogPostLinkClick(id: number): void {
    const newShowingPost = posts.find(post => post.id === id);
    setShowingPost(!!newShowingPost ? newShowingPost : null);
  }
  
  function onChangeHandler(value: string, searchType: SearchType) : void {
   if (SearchType.SEARCH_TEXT === searchType) {
    setSearchText(value)
   } else {
     setSelectedSearchOn(value)
   }
  }

  function isMatched(value: string) {
    return value.toLowerCase().includes(searchText.toLowerCase())
  }

  function filterPost(post: IBlogPost) {
    if (selectedSearchOn === 'title') {
      return isMatched(post.title)
    } else {
      return post.tags.some(isMatched)
    }
  }

  function onSearch() {
    if (searchText !== '') {
      const foundPosts = props.posts.filter(filterPost)
      setShowingPost(findFirstPost(foundPosts))
      setPosts(foundPosts)
    } else {
      setShowingPost(findFirstPost(props.posts))
      setPosts(props.posts)
    }
  }

  return (
    <div className="blog-container">
      <BlogListing
        showingPost={showingPost?.id ?? 0}
        blogPosts={posts.map(post => { return {id: post.id, title: post.title }})}
        onClick={onBlogPostLinkClick}
        searchText={searchText}
        onSearchChange={onChangeHandler}
        onSearchButtonClick={onSearch}
        selectedSearchOn={selectedSearchOn}
      />
      {!!showingPost ? <BlogPost post={showingPost}/>: null }
    </div>
  );
}

export default BlogPosts;