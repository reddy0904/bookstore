package com.example.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookStore.entity.FictionBook;

@Repository
public interface FictionBookRepository extends JpaRepository<FictionBook, Integer>  {

}