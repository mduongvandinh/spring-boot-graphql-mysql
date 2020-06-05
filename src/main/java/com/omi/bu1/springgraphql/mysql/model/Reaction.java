package com.omi.bu1.springgraphql.mysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "type", nullable = false)
	private int type;

	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false, updatable = false)
	private Author author;

	@ManyToOne
	@JoinColumn(name = "tutorial_id", nullable = false, updatable = false)
	private Tutorial tutorial;

	public Reaction() {
	}

	public Reaction(int type, Author author, Tutorial tutorial) {
		this.type = type;
		this.author = author;
		this.tutorial = tutorial;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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
		return "Reaction{" +
				"id=" + id +
				", type=" + type +
				", author=" + author +
				", tutorial=" + tutorial +
				'}';
	}
}
