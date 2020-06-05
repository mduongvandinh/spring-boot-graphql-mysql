package com.omi.bu1.springgraphql.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omi.bu1.springgraphql.mysql.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}
