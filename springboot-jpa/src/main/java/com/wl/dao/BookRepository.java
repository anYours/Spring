package com.wl.dao;

import com.wl.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    Book findBookById(Long id);

    List<Book> findBooksByName(String name);


}
