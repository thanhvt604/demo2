package com.example.responsitory;

import com.example.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Books,Integer> {
    Books getByBookId(Integer id);
}
