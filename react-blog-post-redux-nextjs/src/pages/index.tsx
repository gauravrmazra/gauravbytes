import React, { useEffect } from 'react';
import App from '../App';
import { useDispatch } from 'react-redux';
import { GetServerSideProps, GetServerSidePropsContext } from 'next';
import IBlogPost from '../models/IBlogPost';
import BloggerService from '../service/BloggerService';
import { setPostsAsync } from '../redux/reducer/blogPostsSlice';

interface IServerProps {
  bloggerPosts: {
    allTags: string[]
    posts: IBlogPost[]
  }
}

export default (props: IServerProps) => {
  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(setPostsAsync(props.bloggerPosts));
  }, [dispatch, props.bloggerPosts])
  return (<App />)
}

export const getServerSideProps: GetServerSideProps = async(context: GetServerSidePropsContext<any>) => {
  const bloggerPosts = await BloggerService.getAllPosts();
  return {
    props: {
      bloggerPosts
    }
  }
} 