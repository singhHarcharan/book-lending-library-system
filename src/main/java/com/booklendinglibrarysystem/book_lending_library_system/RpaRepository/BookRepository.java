package com.booklendinglibrarysystem.book_lending_library_system.RpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booklendinglibrarysystem.book_lending_library_system.Entity.Book;

// JpaRepository<Book, Long>    -> tells what kinds of values we are going to pass
@Repository     
public interface BookRepository extends JpaRepository<Book, Long> {
    
}

