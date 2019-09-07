package com.skilldistillery.books.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int id;
	private String title;
	private String authors;
	@Column(name = "avg_rating")
	private Double avgRating;
	private String isbn;
	private Long isbn13;
	@Column(name = "language_code")
	private String languageCode;
	@Column(name = "num_pages")
	private Integer numPages;
	@Column(name = "ratings_count")
	private Integer ratingsCount;
	@Column(name = "text_reviews_count")
	private Integer textReviewsCount;
	
	public Book() {}

	public Book(int id, String title, String authors, Double avgRating, String isbn, Long isbn13,
			String languageCode, Integer numPages, Integer ratingsCount, Integer textReviewsCount) {
		super();
		this.id = id;
		this.title = title;
		this.authors = authors;
		this.avgRating = avgRating;
		this.isbn = isbn;
		this.isbn13 = isbn13;
		this.languageCode = languageCode;
		this.numPages = numPages;
		this.ratingsCount = ratingsCount;
		this.textReviewsCount = textReviewsCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public Double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Long getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(Long isbn13) {
		this.isbn13 = isbn13;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public Integer getNumPages() {
		return numPages;
	}

	public void setNumPages(Integer numPages) {
		this.numPages = numPages;
	}

	public Integer getRatingsCount() {
		return ratingsCount;
	}

	public void setRatingsCount(Integer ratingsCount) {
		this.ratingsCount = ratingsCount;
	}

	public Integer getTextReviewsCount() {
		return textReviewsCount;
	}

	public void setTextReviewsCount(Integer textReviewCount) {
		this.textReviewsCount = textReviewCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((avgRating == null) ? 0 : avgRating.hashCode());
		result = prime * result + id;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((isbn13 == null) ? 0 : isbn13.hashCode());
		result = prime * result + ((languageCode == null) ? 0 : languageCode.hashCode());
		result = prime * result + ((numPages == null) ? 0 : numPages.hashCode());
		result = prime * result + ((ratingsCount == null) ? 0 : ratingsCount.hashCode());
		result = prime * result + ((textReviewsCount == null) ? 0 : textReviewsCount.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (avgRating == null) {
			if (other.avgRating != null)
				return false;
		} else if (!avgRating.equals(other.avgRating))
			return false;
		if (id != other.id)
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (isbn13 == null) {
			if (other.isbn13 != null)
				return false;
		} else if (!isbn13.equals(other.isbn13))
			return false;
		if (languageCode == null) {
			if (other.languageCode != null)
				return false;
		} else if (!languageCode.equals(other.languageCode))
			return false;
		if (numPages == null) {
			if (other.numPages != null)
				return false;
		} else if (!numPages.equals(other.numPages))
			return false;
		if (ratingsCount == null) {
			if (other.ratingsCount != null)
				return false;
		} else if (!ratingsCount.equals(other.ratingsCount))
			return false;
		if (textReviewsCount == null) {
			if (other.textReviewsCount != null)
				return false;
		} else if (!textReviewsCount.equals(other.textReviewsCount))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", authors=" + authors + ", avgRating=" + avgRating + ", isbn="
				+ isbn + ", isbn13=" + isbn13 + ", languageCode=" + languageCode + ", numPages=" + numPages
				+ ", ratingsCount=" + ratingsCount + ", textReviewCount=" + textReviewsCount + "]";
	}

}
