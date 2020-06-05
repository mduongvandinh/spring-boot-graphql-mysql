package com.omi.bu1.springgraphql.mysql.service;

import com.omi.bu1.springgraphql.mysql.model.Author;
import com.omi.bu1.springgraphql.mysql.model.Comment;
import com.omi.bu1.springgraphql.mysql.model.Tutorial;
import com.omi.bu1.springgraphql.mysql.repository.AuthorRepository;
import com.omi.bu1.springgraphql.mysql.repository.TutorialRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentResolver implements GraphQLResolver<Comment> {

	private final AuthorRepository authorRepository;
	private final TutorialRepository tutorialRepository;

	@Autowired
	public CommentResolver(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
		this.authorRepository = authorRepository;
		this.tutorialRepository = tutorialRepository;
	}

	public Author getAuthor(Comment comment) {
		return authorRepository.findById(comment.getAuthor().getId()).orElseThrow(null);
	}

	public Tutorial getTutorial(Comment comment) {
		return tutorialRepository.findById(comment.getTutorial().getId()).orElseThrow(null);
	}
}
