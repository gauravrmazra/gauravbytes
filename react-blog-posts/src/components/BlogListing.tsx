import React from 'react';
import BlogSearch from './BlogSearch';
import { SearchType } from '../models/SearchType';

declare type IBlogPostData = {
  id: number
  title: string
}

interface IBlogListing {
  blogPosts: IBlogPostData[]
  showingPost: number
  searchText: string
  selectedSearchOn: string
  onClick: (id: number) => void
  onSearchChange: (searchText: string, searchType: SearchType) => void
  onSearchButtonClick: () => void
}

function BlogListing(props: IBlogListing) {
  return(
    <div className='blog-listing'>
      <BlogSearch
        onSearchChange={props.onSearchChange}
        selectedSearchOn={props.selectedSearchOn}
        searchText={props.searchText}
        onSearchButtonClick={props.onSearchButtonClick}
      />
      <ul className="blog-posts">
        {
          props.blogPosts.map(post => <li className={props.showingPost === post.id ? 'active' : ''} key={post.id} onClick={() => props.onClick(post.id)}>{post.title}</li>)
        }
      </ul>
    </div>
  );
}

export default BlogListing;