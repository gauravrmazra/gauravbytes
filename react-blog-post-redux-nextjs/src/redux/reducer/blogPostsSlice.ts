import IBlogPost from "../../models/IBlogPost";
import { SearchOnFields } from "../../models/SearchOnFields";
import { createSlice, PayloadAction, createAsyncThunk } from '@reduxjs/toolkit';
import { AppThunk, RootState } from '../../redux/store';
import BloggerService from '../../service/BloggerService'

interface BlogPostsState {
  showingPost: IBlogPost | null
  searchText: string
  selectedSearchOn: SearchOnFields
  searchResults: IBlogPost[]
  isSearch: boolean
  bloggerPosts: {
    allTags: string[],
    posts: IBlogPost[]
  }
  isLoadingBloggerPosts: boolean
  bloggerPostsError: any
}

// Initial state of the reducer
const initialState: BlogPostsState = {
  showingPost: null,
  searchText: '',
  selectedSearchOn: SearchOnFields.TAG,
  searchResults: [],
  isSearch: false,
  bloggerPosts: {
    allTags: [],
    posts: []
  },
  isLoadingBloggerPosts: false,
  bloggerPostsError: null
}

export const getBloggerPosts = createAsyncThunk('blogggerPosts/all', async(thunkAPI) => {
  return await BloggerService.getAllPosts();
})

const findFirstPost = (posts: IBlogPost[]) : IBlogPost | null => !!posts && posts.length > 0 ? posts[0] : null;

const blogPostsSlice = createSlice({
  name: 'blogPosts',
  initialState,
  reducers: {
    setPosts: (state, action: PayloadAction<{ allTags: string[], posts: IBlogPost[] }>) => {
      state.bloggerPosts = action.payload;
      state.showingPost = findFirstPost(action.payload.posts);
    },
    setShowingPost: (state, action: PayloadAction<string>) => {
      const newShowingPost = state?.bloggerPosts.posts.find(post => post.id === action.payload) ?? undefined;
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
      state.isSearch = true;
      if (state.searchText !== '') {
        const posts = state.bloggerPosts.posts;
        const searchResults = posts.filter(filterPosts)
        state.searchResults = searchResults;
        state.showingPost = findFirstPost(searchResults);

      } else {
        state.searchResults = [];
        state.isSearch = false;
        state.showingPost = findFirstPost(state.bloggerPosts.posts)
      }
    }
  },
  extraReducers: builder => {
    builder.addCase(getBloggerPosts.pending, (state, _) => {
      state.isLoadingBloggerPosts = true;
    }).addCase(getBloggerPosts.rejected, (state, action) => {
      state.bloggerPostsError = action.error;
    }).addCase(getBloggerPosts.fulfilled, (state, action) => {
      state.isLoadingBloggerPosts = false;
      state.bloggerPosts = action.payload;
      state.showingPost = findFirstPost(state.bloggerPosts.posts);
    })
  }
});

const setShowingPostsAsync = (id: string) : AppThunk => dispatch => {
  setTimeout(() => {
    dispatch(setShowingPost(id))
  }, 500)
};

const setPostsAsync = (bloggerPosts: { allTags: string[], posts: IBlogPost[] }): AppThunk => dispatch => {
  setTimeout(() => {
    dispatch(setPosts(bloggerPosts))
  })
}

const onSearchAsync = (): AppThunk => dispatch => {
  setTimeout(() => {
    dispatch(onSearch())
  }, 200)
};

// List of selectors
const selectPosts = (state: RootState) => state.blogPosts.isSearch ? state.blogPosts.searchResults : (state.blogPosts?.bloggerPosts?.posts ?? []);

const selectShowingPost = (state: RootState) => state.blogPosts.showingPost;

const selectPostsForListing = (state: RootState) => state.blogPosts.isSearch ? listingPosts(state.blogPosts.searchResults): listingPosts((state.blogPosts?.bloggerPosts?.posts ?? []));

const selectShowingPostId = (state: RootState) => state.blogPosts?.showingPost?.id ?? 0;

const selectSearchText = (state: RootState) => state.blogPosts.searchText;

const selectSelectedSearchOn = (state: RootState) => state.blogPosts.selectedSearchOn;

const listingPosts = (posts: IBlogPost[]) => posts?.map(post => { return { id: post.id, title: post.title }}) ?? [];


const { setPosts, setSearchText, setSelectedSearchOn, setShowingPost, onSearch } = blogPostsSlice.actions;

// Selector functions
export { selectPosts, selectShowingPost, selectPostsForListing, selectShowingPostId, selectSearchText, selectSelectedSearchOn }

// action functions
export { setPosts, setPostsAsync, setShowingPostsAsync, onSearchAsync, setSearchText, setSelectedSearchOn, setShowingPost, onSearch }

export default blogPostsSlice.reducer;