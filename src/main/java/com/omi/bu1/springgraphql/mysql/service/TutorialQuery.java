package com.omi.bu1.springgraphql.mysql.service;

import com.omi.bu1.springgraphql.mysql.model.Tutorial;
import com.omi.bu1.springgraphql.mysql.repository.TutorialRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TutorialQuery implements GraphQLQueryResolver {
	private final TutorialRepository tutorialRepository;

	@Autowired
	public TutorialQuery(TutorialRepository tutorialRepository) {
		this.tutorialRepository = tutorialRepository;
	}

	public Iterable<Tutorial> findAllTutorials() {
		return tutorialRepository.findAll();
	}

	public long countTutorials() {
		return tutorialRepository.count();
	}
}
