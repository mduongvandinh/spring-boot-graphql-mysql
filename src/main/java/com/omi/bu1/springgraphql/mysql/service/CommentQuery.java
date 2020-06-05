package com.omi.bu1.springgraphql.mysql.service;

import com.omi.bu1.springgraphql.mysql.model.Comment;
import com.omi.bu1.springgraphql.mysql.repository.CommentRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentQuery implements GraphQLQueryResolver {
	private final CommentRepository commentRepository;

	@Autowired
	public CommentQuery(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	public Iterable<Comment> findAllComments() {
		return commentRepository.findAll();
	}

	public long countComments() {
		return commentRepository.count();
	}
}
