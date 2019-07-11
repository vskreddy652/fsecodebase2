package com.hackfse.giveaway.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity(name = "booksBean")
@Table(name = "BOOKS")
public class BooksBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	@Column(name = "BOOK_ISBN")
	private String bookIsbnNumber;
	@Column(name = "BOOK_CATEGORY")
	private String bookCategory;
	@Column(name = "BOOK_AUTHOR")
	private String bookAuthor;
	@Column(name = "BOOK_DESCRIPTION")
	private String bookDescription;
	@Column(name = "BOOK_NAME")
	private String bookName;
	@Column(name = "BOOK_COUNT")
	private Long count;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookIsbnNumber() {
		return bookIsbnNumber;
	}

	public void setBookIsbnNumber(String bookIsbnNumber) {
		this.bookIsbnNumber = bookIsbnNumber;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public BooksBean(Long id, String bookIsbnNumber, String bookCategory, String bookAuthor, String bookDescription,
			String bookName, Long count) {
		this.id = id;
		this.bookIsbnNumber = bookIsbnNumber;
		this.bookCategory = bookCategory;
		this.bookAuthor = bookAuthor;
		this.bookDescription = bookDescription;
		this.bookName = bookName;
		this.count = count;
	}

	public BooksBean() {

	}
}
