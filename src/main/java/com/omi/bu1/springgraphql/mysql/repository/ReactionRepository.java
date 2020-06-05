package com.omi.bu1.springgraphql.mysql.repository;

import com.omi.bu1.springgraphql.mysql.model.Reaction;
import com.omi.bu1.springgraphql.mysql.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReactionRepository extends JpaRepository<Reaction, Long> {

    List<Reaction> findAllByTutorial(Tutorial tutorial);
}
