package com.omi.bu1.springgraphql.mysql.repository;

import com.omi.bu1.springgraphql.mysql.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}