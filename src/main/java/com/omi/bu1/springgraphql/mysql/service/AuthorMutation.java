package com.omi.bu1.springgraphql.mysql.service;

import com.omi.bu1.springgraphql.mysql.model.Author;
import com.omi.bu1.springgraphql.mysql.repository.AuthorRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorMutation implements GraphQLMutationResolver {
	private final AuthorRepository authorRepository;

	@Autowired
	public AuthorMutation(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public Author createAuthor(String name, Integer age) {
		Author author = new Author();
		author.setName(name);
		author.setAge(age);

		authorRepository.save(author);

		return author;
	}

}
