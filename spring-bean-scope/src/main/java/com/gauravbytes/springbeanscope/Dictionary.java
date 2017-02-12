package com.gauravbytes.springbeanscope;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="http://www.gauravbytes.com">Catch me</a>
 */
public class Dictionary {
	private List<String> words;
	public Dictionary() {
		words = new ArrayList<>();
	}
	
	public void addWord(String word) {
		this.words.add(word);
	}
	
	public int totalWords() {
		return this.words.size();
	}
	
	@Override
	public String toString() {
		return words.toString();
	}
}
