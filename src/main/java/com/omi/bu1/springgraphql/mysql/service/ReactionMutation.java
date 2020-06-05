package com.omi.bu1.springgraphql.mysql.service;

import com.omi.bu1.springgraphql.mysql.model.Author;
import com.omi.bu1.springgraphql.mysql.model.Reaction;
import com.omi.bu1.springgraphql.mysql.model.Tutorial;
import com.omi.bu1.springgraphql.mysql.repository.ReactionRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReactionMutation implements GraphQLMutationResolver {
	private final ReactionRepository reactionRepository;

	@Autowired
	public ReactionMutation(ReactionRepository reactionRepository) {
		this.reactionRepository = reactionRepository;
	}

	public Reaction createReaction(int type, Long authorId, Long tutorialId) {
		Reaction reaction = new Reaction();
		reaction.setType(type);
		reaction.setAuthor(new Author(authorId));
		reaction.setTutorial(new Tutorial(tutorialId));

		reactionRepository.save(reaction);

		return reaction;
	}
}
