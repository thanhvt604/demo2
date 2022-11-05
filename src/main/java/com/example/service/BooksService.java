package com.example.service;

import com.example.model.Books;
import com.example.responsitory.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    public void save (Books books)
    {
        booksRepository.save(books);
    }

    public void update(Books books, int bookId )
    {
        booksRepository.save(books);
    }

    public void delete(int bookId)
    {
        booksRepository.deleteById(bookId);
    }

    public Books getBooksById(int id)
    {
        return booksRepository.findById(id).get();
    }


    public List<Books> getAllBooks()
    {
        List<Books> books;
        books= booksRepository.findAll();
        return books;
    }
}
