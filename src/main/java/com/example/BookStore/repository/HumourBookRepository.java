package com.example.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookStore.entity.HumourBook;

@Repository
public interface HumourBookRepository extends JpaRepository<HumourBook, Integer>  {

}
