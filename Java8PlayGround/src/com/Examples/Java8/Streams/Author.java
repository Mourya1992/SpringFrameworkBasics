package com.Examples.Java8.Streams;

public class Author {

	private String name;
	private int booksPublished;
	private String emailId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBooksPublished() {
		return booksPublished;
	}

	public void setBooksPublished(int booksPublished) {
		this.booksPublished = booksPublished;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Author(String name, int booksPublished, String emailId) {
		super();
		this.name = name;
		this.booksPublished = booksPublished;
		this.emailId = emailId;
	}

	public Author() {

	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", booksPublished=" + booksPublished + ", emailId=" + emailId + "]";
	}

}
