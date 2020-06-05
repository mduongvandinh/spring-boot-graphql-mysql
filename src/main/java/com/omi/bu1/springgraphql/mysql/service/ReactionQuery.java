package com.omi.bu1.springgraphql.mysql.service;

import com.omi.bu1.springgraphql.mysql.model.Reaction;
import com.omi.bu1.springgraphql.mysql.repository.ReactionRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReactionQuery implements GraphQLQueryResolver {
	private final ReactionRepository reactionRepository;

	@Autowired
	public ReactionQuery(ReactionRepository reactionRepository) {
		this.reactionRepository = reactionRepository;
	}

	public Iterable<Reaction> findAllReactions() {
		return reactionRepository.findAll();
	}

	public long countReactions() {
		return reactionRepository.count();
	}
}
