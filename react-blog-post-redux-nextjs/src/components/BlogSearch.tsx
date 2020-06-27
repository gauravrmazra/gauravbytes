import React, { ChangeEvent } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { selectSearchText, selectSelectedSearchOn, setSelectedSearchOn, setSearchText, onSearchAsync } from '../redux/reducer/blogPostsSlice';
import { SearchOnFields } from '../models/SearchOnFields';
import styles from './BlogPosts.module.css';

function BlogSearch() {
  const dispatch = useDispatch();
  const searchText = useSelector(selectSearchText);
  const selectedSearchOn = useSelector(selectSelectedSearchOn);

  function onSearchTextChange(event: ChangeEvent<HTMLInputElement>): void {
    dispatch(setSearchText(event.target.value));
  }

  function onSearchOnChange(event: ChangeEvent<HTMLSelectElement>): void {
    dispatch(setSelectedSearchOn(event.target.value === SearchOnFields.TAG ? SearchOnFields.TAG : SearchOnFields.TITLE))
  }

  return(
    <div className={styles["blog-search-container"]}>
      <div className={styles['blog-search-title']}>Search Blog</div>
      <div className={styles['blog-search-body']}>
        <input type="text" className={styles["form-control"]} autoComplete="off" value={searchText} onChange={onSearchTextChange}/>
        <select value={selectedSearchOn} className={styles['form-control']} onChange={onSearchOnChange}>
          <option value={SearchOnFields.TAG}>Tags</option>
          <option value={SearchOnFields.TITLE}>Title</option>
        </select>
        <button type="button" className={styles["form-button"]} onClick={() => dispatch(onSearchAsync())}>Search</button>
      </div>
    </div>
  );
}

export default BlogSearch;