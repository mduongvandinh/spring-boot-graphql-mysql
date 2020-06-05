package com.omi.bu1.springgraphql.mysql.service;

import com.omi.bu1.springgraphql.mysql.model.Author;
import com.omi.bu1.springgraphql.mysql.repository.AuthorRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorQuery implements GraphQLQueryResolver {
	private final AuthorRepository authorRepository;

	@Autowired
	public AuthorQuery(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public Iterable<Author> findAllAuthors() {
		return authorRepository.findAll();
	}

	public long countAuthors() {
		return authorRepository.count();
	}
}
