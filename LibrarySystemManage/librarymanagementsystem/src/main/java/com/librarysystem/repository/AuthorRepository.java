package com.librarysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarysystem.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
