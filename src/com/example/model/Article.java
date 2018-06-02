package com.example.model;

import java.util.List;

public class Article {

	private String author;
	private String title;
	private List<String> tags;
	private int wordcount;

	public Article(final String author, final String title, final List<String> tags, int wordCount) {
		super();
		this.author = author;
		this.title = title;
		this.tags = tags;
		this.wordcount = wordCount;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(final String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(final List<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Article [author=" + author + ", title=" + title + ", tags=" + tags + "]";
	}

	public int getWordcount() {
		return wordcount;
	}

}