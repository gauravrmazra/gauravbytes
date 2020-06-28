import React from 'react';
import { GetStaticProps, GetStaticPropsContext } from 'next';
import BloggerService from '../service/BloggerService';
import styles from '../App.module.css'

interface IndexPageProps {
  blogLinks: Array<{ id: string, title: string }>
}


export default function IndexPage(props: IndexPageProps) {
  return (
    <div className={ styles['blog-container'] }>
      <ul className={ styles['blog-posts'] }>
      {props.blogLinks.map(blogLink => <li key={blogLink.id}><a href={`/posts/${encodeURIComponent(blogLink.id)}`}>{blogLink.title}</a></li>)}
      </ul>
    </div>
  );
}

export const getStaticProps: GetStaticProps = async (context: GetStaticPropsContext<any>) => {
  const bloggerPosts = await BloggerService.getAllPosts();
  const blogLinks = bloggerPosts.posts.map(post => {
    const splittedId = post.id.split('-')
      return {
        id: splittedId[splittedId.length - 1],
        title: post.title
      }
  });

  return {
    props: {
      blogLinks
    }
  }
}