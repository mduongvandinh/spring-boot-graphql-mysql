package com.omi.bu1.springgraphql.mysql.service;

import com.omi.bu1.springgraphql.mysql.model.Author;
import com.omi.bu1.springgraphql.mysql.model.Comment;
import com.omi.bu1.springgraphql.mysql.model.Tutorial;
import com.omi.bu1.springgraphql.mysql.repository.CommentRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentMutation implements GraphQLMutationResolver {

	private final CommentRepository commentRepository;

	@Autowired
	public CommentMutation(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	public Comment createComment(String contents, Long authorId, Long tutorialId) {
		Comment comment = new Comment();
		comment.setContents(contents);
		comment.setAuthor(new Author(authorId));
		comment.setTutorial(new Tutorial(tutorialId));

		commentRepository.save(comment);

		return comment;
	}
}
