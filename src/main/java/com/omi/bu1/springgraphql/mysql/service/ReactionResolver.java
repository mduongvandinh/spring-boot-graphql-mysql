package com.omi.bu1.springgraphql.mysql.service;

import com.omi.bu1.springgraphql.mysql.model.Author;
import com.omi.bu1.springgraphql.mysql.model.Reaction;
import com.omi.bu1.springgraphql.mysql.model.Tutorial;
import com.omi.bu1.springgraphql.mysql.repository.AuthorRepository;
import com.omi.bu1.springgraphql.mysql.repository.TutorialRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReactionResolver implements GraphQLResolver<Reaction> {

	private final AuthorRepository authorRepository;
	private final TutorialRepository tutorialRepository;

	@Autowired
	public ReactionResolver(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
		this.authorRepository = authorRepository;
		this.tutorialRepository = tutorialRepository;
	}

	public Author getAuthor(Reaction reaction) {
		return authorRepository.findById(reaction.getAuthor().getId()).orElseThrow(null);
	}

	public Tutorial getTutorial(Reaction reaction) {
		return tutorialRepository.findById(reaction.getTutorial().getId()).orElseThrow(null);
	}
}
