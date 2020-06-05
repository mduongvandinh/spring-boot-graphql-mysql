package com.omi.bu1.springgraphql.mysql.service;

import com.omi.bu1.springgraphql.mysql.model.Comment;
import com.omi.bu1.springgraphql.mysql.model.Reaction;
import com.omi.bu1.springgraphql.mysql.repository.CommentRepository;
import com.omi.bu1.springgraphql.mysql.repository.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.omi.bu1.springgraphql.mysql.model.Author;
import com.omi.bu1.springgraphql.mysql.model.Tutorial;
import com.omi.bu1.springgraphql.mysql.repository.AuthorRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;

import java.util.List;

@Component
public class TutorialResolver implements GraphQLResolver<Tutorial> {

	private final AuthorRepository authorRepository;
	private final CommentRepository commentRepository;
	private final ReactionRepository reactionRepository;

	@Autowired
	public TutorialResolver(AuthorRepository authorRepository, CommentRepository commentRepository, ReactionRepository reactionRepository) {
		this.authorRepository = authorRepository;
		this.commentRepository = commentRepository;
		this.reactionRepository = reactionRepository;
	}

	public Author getAuthor(Tutorial tutorial) {
		return authorRepository.findById(tutorial.getAuthor().getId()).orElseThrow(null);
	}

	public List<Comment> getCommentList(Tutorial tutorial) {
		return commentRepository.findAllByTutorial(tutorial);
	}

	public List<Reaction> getReactionList(Tutorial tutorial) {
		return reactionRepository.findAllByTutorial(tutorial);
	}
}
