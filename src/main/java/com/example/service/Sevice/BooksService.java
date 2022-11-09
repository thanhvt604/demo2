package com.example.service.Sevice;

import com.example.dto.BooksDto;
import com.example.model.Books;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BooksService {
    BooksDto save(BooksDto booksDto);

    BooksDto update(BooksDto booksDto, int bookId);

    void delete(int bookId);

   BooksDto getBooksById(int id);

   List<BooksDto> getAllBooks();


}
