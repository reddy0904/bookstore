package com.example.BookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookStore.entity.RomanceBook;
@Repository
public interface RomanceBookRepository extends JpaRepository<RomanceBook, Integer>{

}
