package com.example.controller;

import com.example.model.Books;
import com.example.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BooksService booksService;

    @PostMapping("/books")
    public Books save(@RequestBody Books books)
    {
        booksService.save(books);
        return books;
    }
    @PutMapping("books/{bookId}")
    public Books update(@RequestBody Books books, @PathVariable("bookId") int bookId)
    {
        booksService.update(books,bookId);
        return books;
    }

    @DeleteMapping("book/{bookId}")
    public void deleteBooks(@PathVariable("bookId") int bookId)
    {
        booksService.delete(bookId);
    }

    @GetMapping("/book/{bookId}")
    public Books getBooks(@PathVariable("bookId") int bookId)
    {
        return booksService.getBooksById(bookId);
    }

    @GetMapping("/book")
    public List<Books> getAllBooks()
    {
        return booksService.getAllBooks();
    }

}
