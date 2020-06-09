import React, { ChangeEvent } from 'react';
import { SearchType } from '../models/SearchType';

interface IBlogSearchProps {
  searchText: string
  selectedSearchOn: string
  onSearchChange: (searchText: string, searchType: SearchType) => void
  onSearchButtonClick: () => void
}

function BlogSearch(props: IBlogSearchProps) {
  function onSearchTextChange(event: ChangeEvent<HTMLInputElement>): void {
    props.onSearchChange(event.target.value, SearchType.SEARCH_TEXT)
  }

  function onSearchOnChange(event: ChangeEvent<HTMLSelectElement>): void {
    props.onSearchChange(event.target.value, SearchType.SEARCH_ON)
  }

  return(
    <div className="blog-search-container">
      <div className='blog-search-title'>Search Blog</div>
      <div className='blog-search-body'>
        <input type="text" className="form-control" autoComplete="off" value={props?.searchText ?? ''} onChange={onSearchTextChange}/>
        <select value={props.selectedSearchOn} className='form-control' onChange={onSearchOnChange}>
          <option value='tag'>Tags</option>
          <option value='title'>Title</option>
        </select>
        <button type="button" className="form-button" onClick={props.onSearchButtonClick}>Search</button>
      </div>
    </div>
  );
}

export default BlogSearch;