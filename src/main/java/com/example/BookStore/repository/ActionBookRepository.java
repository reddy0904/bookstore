package com.example.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookStore.entity.ActionBook;

@Repository
public interface ActionBookRepository extends JpaRepository<ActionBook, Integer>  {

}
