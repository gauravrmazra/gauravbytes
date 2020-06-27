import { configureStore, ThunkAction, Action } from '@reduxjs/toolkit';
import blogPostsReducer from './reducer/blogPostsSlice';

export const store = configureStore({
  reducer: {
    blogPosts: blogPostsReducer,
  },
});

export type RootState = ReturnType<typeof store.getState>;
export type AppThunk<ReturnType = void> = ThunkAction<
  ReturnType,
  RootState,
  unknown,
  Action<string>
>;
