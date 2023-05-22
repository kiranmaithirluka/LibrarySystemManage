package com.librarysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarysystem.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
