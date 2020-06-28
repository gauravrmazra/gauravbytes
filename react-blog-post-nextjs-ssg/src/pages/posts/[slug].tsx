import React from 'react';
import { GetStaticPaths, GetStaticProps, GetStaticPropsContext } from 'next';
import IBlogPost from '../../models/IBlogPost';
import BloggerService from '../../service/BloggerService';
import BlogPost from '../../components/BlogPost';
import styles from '../../App.module.css';

interface IServerProps {
  post: IBlogPost
}

export default (props: IServerProps) => {
  return (
    <>
      <div className={styles['App-Container']}>
        <BlogPost post={props.post} />
      </div>
    </>
  );
}

export const getStaticPaths: GetStaticPaths = async() => {
  const bloggerPosts = await BloggerService.getAllPosts();
  const paths = bloggerPosts.posts.map(post => {
    const splittedId = post.id.split('-')
    const slug = splittedId[splittedId.length - 1]
    return {
      params: {
        slug
      }
    }
  });

  return {
    paths,
    fallback: false
  }
}

export const getStaticProps: GetStaticProps = async(context: GetStaticPropsContext<any>) => {
  const slug = context?.params?.slug ?? 'na'
  const bloggerPosts = await BloggerService.getAllPosts();

  const post = bloggerPosts.posts.find( post => post.id.endsWith(slug))
  return {
    props: {
      post
    }
  }
} 