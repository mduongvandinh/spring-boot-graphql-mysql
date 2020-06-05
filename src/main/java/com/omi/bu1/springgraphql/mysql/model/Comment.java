package com.omi.bu1.springgraphql.mysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "contents", nullable = false)
	private String contents;

	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false, updatable = false)
	private Author author;

	@ManyToOne
	@JoinColumn(name = "tutorial_id", nullable = false, updatable = false)
	private Tutorial tutorial;

	public Comment() {
	}

	public Comment(String contents, Author author, Tutorial tutorial) {
		this.contents = contents;
		this.author = author;
		this.tutorial = tutorial;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Tutorial getTutorial() {
		return tutorial;
	}

	public void setTutorial(Tutorial tutorial) {
		this.tutorial = tutorial;
	}

	@Override
	public String toString() {
		return "Comment{" +
				"id=" + id +
				", contents='" + contents + '\'' +
				", author=" + author +
				", tutorial=" + tutorial +
				'}';
	}
}
