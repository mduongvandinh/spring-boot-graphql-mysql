package com.omi.bu1.springgraphql.mysql.repository;

import com.omi.bu1.springgraphql.mysql.model.Comment;
import com.omi.bu1.springgraphql.mysql.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByTutorial(Tutorial tutorial);
}
