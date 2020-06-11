import IBlogPost from "../../models/IBlogPost";
import { SearchOnFields } from "../../models/SearchOnFields";
import { createSlice, PayloadAction } from '@reduxjs/toolkit';
import { AppThunk, RootState } from '../../redux/store';

interface BlogPostsState {
  posts: IBlogPost[]
  showingPost: IBlogPost | null
  searchText: string
  selectedSearchOn: SearchOnFields
  searchResults: IBlogPost[]
  isSearch: boolean
}

// Initial state of the reducer
const initialState: BlogPostsState = {
  posts: [],
  showingPost: null,
  searchText: '',
  selectedSearchOn: SearchOnFields.TAG,
  searchResults: [],
  isSearch: false
}

const blogPostsSlice = createSlice({
  name: 'blogPosts',
  initialState,
  reducers: {
    setPosts: (state, action: PayloadAction<IBlogPost[]>) => {
      state.posts = action.payload
    },
    setShowingPost: (state, action: PayloadAction<number>) => {
      const newShowingPost = state?.posts.find(post => post.id === action.payload) ?? undefined;
      state.showingPost = newShowingPost ?? null
    },
    setSearchText: (state, action: PayloadAction<string>) => {
      state.searchText = action.payload;
    },
    setSelectedSearchOn: (state, action: PayloadAction<SearchOnFields>) => {
      state.selectedSearchOn = action.payload;
    },
    onSearch: state => {
      const isMatched = (value: string) => value.toLowerCase().includes(state.searchText.toLowerCase());
      const filterPosts = (post: IBlogPost) => (state.selectedSearchOn === SearchOnFields.TITLE) ? isMatched(post.title) : post.tags.some(isMatched)
      const findFirstPost = (posts: IBlogPost[]) : IBlogPost | null => !!posts && posts.length > 0 ? posts[0] : null;
      state.isSearch = true;
      if (state.searchText !== '') {
        const posts = state.posts;
        const searchResults = posts.filter(filterPosts)
        state.searchResults = searchResults;
        state.showingPost = findFirstPost(searchResults);

      } else {
        state.searchResults = [];
        state.isSearch = false;
        state.showingPost = findFirstPost(state.posts)
      }
    }
  }
});

// Aysnc action functions
const setPostsAsync = (posts: IBlogPost[]): AppThunk => dispatch => {
  setTimeout(() => {
    dispatch(setPosts(posts))
  }, 500)
};

const setShowingPostsAsync = (id: number) : AppThunk => dispatch => {
  setTimeout(() => {
    dispatch(setShowingPost(id))
  }, 500)
};

const onSearchAsync = (): AppThunk => dispatch => {
  setTimeout(() => {
    dispatch(onSearch())
  }, 200)
};

// List of selectors
const selectPosts = (state: RootState) => state.blogPosts.isSearch ? state.blogPosts.searchResults : state.blogPosts.posts;

const selectShowingPost = (state: RootState) => state.blogPosts.showingPost;

const selectPostsForListing = (state: RootState) => state.blogPosts.isSearch ? listingPosts(state.blogPosts.searchResults): listingPosts(state.blogPosts.posts);

const selectShowingPostId = (state: RootState) => state.blogPosts?.showingPost?.id ?? 0;

const selectSearchText = (state: RootState) => state.blogPosts.searchText;

const selectSelectedSearchOn = (state: RootState) => state.blogPosts.selectedSearchOn;

const listingPosts = (posts: IBlogPost[]) => posts?.map(post => { return { id: post.id, title: post.title }}) ?? [];


const { setPosts, setSearchText, setSelectedSearchOn, setShowingPost, onSearch } = blogPostsSlice.actions;

// Selector functions
export { selectPosts, selectShowingPost, selectPostsForListing, selectShowingPostId, selectSearchText, selectSelectedSearchOn }

// action functions
export { setPostsAsync, setShowingPostsAsync, onSearchAsync, setPosts, setSearchText, setSelectedSearchOn, setShowingPost, onSearch }

export default blogPostsSlice.reducer;