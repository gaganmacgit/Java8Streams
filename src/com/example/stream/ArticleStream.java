package com.example.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.model.Article;

public class ArticleStream {

	List<Article> articleList = Collections.emptyList();

	public static void main(final String[] args) {
		new ArticleStream();
	}

	public ArticleStream() {
		createArticleList();

		// get the first article using stream
		final Optional<Article> firstArticleUsingStream = getFirstArticleUsingStream();
		if (firstArticleUsingStream.isPresent()) {
			System.out.println(firstArticleUsingStream.get());
		}

		// get all the articles with tag java in form of list
		final List<Article> articleListResult = articleList.stream()
				.filter(article -> article.getTags().contains("java")).collect(Collectors.toList());
		System.out.println((articleListResult));

		// get all the articles grouped by the author
		final Map<String, List<Article>> authorVsArticleMap = articleList.stream()
				.collect(Collectors.groupingBy(Article::getAuthor));
		System.out.println(authorVsArticleMap);

		// get the map from article list where key is article title, and value is
		// article object
		final Map<String, Article> articleMap = articleList.stream()
				.collect(Collectors.toMap(Article::getTitle, Function.identity()));
		System.out.println(articleMap);

		// get average of word count
		final Double averageWordCount = articleList.stream().collect(Collectors.averagingInt(Article::getWordcount));
		System.out.println(" average word count is " + averageWordCount);

		// sum of all the word count
		final Integer sumOfWordCount = articleList.stream().collect(Collectors.summingInt(Article::getWordcount));
		System.out.println(" Sum of total word count " + sumOfWordCount);

		// join all the titles by comma
		final String joinedString = articleList.stream().map(article -> article.getTitle())
				.collect(Collectors.joining(","));
		System.out.println(" Titles joined -> " + joinedString);

		// joining the titles with some prefix and suffix
		final String collectedStringWithPrefix = articleList.stream().map(Article::getTitle)
				.collect(Collectors.joining(",", "Articles : ", " End of articles "));
		System.out.println(collectedStringWithPrefix);

		// get the article containing the most words.
		final Comparator<Article> articleComparator = (a1, a2) -> a1.getWordcount() - a2.getWordcount();

		final Optional<Article> maxWordArticle = articleList.stream().collect(Collectors.maxBy(articleComparator));
		if (maxWordArticle.isPresent()) {
			System.out.println(maxWordArticle.get());
		}

		// split the articles in two based on the count of words being more or less than
		// 1000 words.
		Map<Boolean, List<Article>> articlePartitionMap = articleList.stream()
				.collect(Collectors.partitioningBy(article -> article.getWordcount() > 10));
		System.out.println(" Partitioned map " + articlePartitionMap);

		// add the average word count to a string
		String averageResultString = articleList.stream().collect(Collectors.collectingAndThen(
				Collectors.averagingInt(Article::getWordcount), average -> "Average count was -> " + average));
		System.out.println(averageResultString);
		
		//group the articles by tags
		Map<List<String>, List<Article>> tagVsArticleMap = articleList.stream().collect(Collectors.groupingBy(Article::getTags));
		System.out.println("Tag vs Article Map " + tagVsArticleMap);
		
		//get a map
		List<String> collect = articleList.stream().map(article ->article.getTitle()).collect(Collectors.toList());
		System.out.println(collect);
		
		//equivalent of above
		System.out.println(articleList.stream().collect(Collectors.mapping(Article::getTitle, Collectors.toList())));
		
		
		//tags vs  title map
		Map<List<String>, List<String>> tagVsTitleMap = articleList.stream().collect(Collectors.groupingBy(Article::getTags, Collectors.mapping(Article::getTitle, Collectors.toList())));
		System.out.println(tagVsTitleMap);
	}

	private Optional<Article> getFirstArticleUsingStream() {

		return articleList.stream().filter(article -> article.getTags().contains("java")).findFirst();

	}

	private void createArticleList() {

		final Article article1 = new Article("Author1", "Title1", Arrays.asList("java", "oracle"), 20);
		final Article article2 = new Article("Author2", "Title2", Arrays.asList("c++"), 8);
		final Article article3 = new Article("Author3", "Title3", Arrays.asList("java"), 5);
		final Article article4 = new Article("Author1", "Title4", Arrays.asList("c"), 5);
		final Article article5 = new Article("Author5", "Title5", Arrays.asList("oracle"), 12);

		articleList = new ArrayList<>();
		articleList.add(article1);
		articleList.add(article2);
		articleList.add(article3);
		articleList.add(article4);
		articleList.add(article5);

	}

}
