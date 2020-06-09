import React from 'react';

declare type IBlogPostData = {
  id: number
  title: string
}

interface IBlogListing {
  blogPosts: IBlogPostData[]
  selectedBlogPost: number
  onClick: (id: number) => void
}

function BlogListing(props: IBlogListing) {
  return(
    <div className='blog-listing'>
      <ul className="blog-posts">
        {
          props.blogPosts.map(post => <li className={props.selectedBlogPost === post.id ? 'active' : ''} key={post.id} onClick={() => props.onClick(post.id)}>{post.title}</li>)
        }
      </ul>
    </div>
  );
}

export default BlogListing;