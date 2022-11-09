package com.example.controller;

import com.example.dto.BooksDto;
import com.example.service.BooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BooksServiceImpl booksService;

    @PostMapping("/books")
    public ResponseEntity<BooksDto> save(@Valid @RequestBody BooksDto booksDto) {
        return ResponseEntity.ok(booksService.save(booksDto));
    }

    @PutMapping("books/{bookId}")
    public ResponseEntity<BooksDto> update(@RequestBody BooksDto booksDto, @PathVariable("bookId") int bookId) {
        booksService.update(booksDto, bookId);
        return ResponseEntity.ok(booksService.save(booksDto));
    }

    @DeleteMapping("book/{bookId}")
    public void deleteBooks(@PathVariable("bookId") int bookId) {
        booksService.delete(bookId);
    }

    @GetMapping("/book/{bookId}")
    public BooksDto getBooks(@PathVariable("bookId") int bookId) {
        return booksService.getBooksById(bookId);
    }

    @GetMapping("/book")
    public List<BooksDto> getAllBooks() {
        return booksService.getAllBooks();
    }

}
