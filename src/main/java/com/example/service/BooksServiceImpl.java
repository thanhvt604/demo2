package com.example.service;

import com.example.dto.BooksDto;
import com.example.model.Books;
import com.example.responsitory.BooksRepository;
import com.example.service.Sevice.BooksService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksRepository booksRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BooksDto save(BooksDto booksDto) {
        Books books;
        books = modelMapper.map(booksDto, Books.class);
        booksRepository.save(books);
        return modelMapper.map(books, BooksDto.class);
    }

    @Override
    public BooksDto update(BooksDto booksDto, int bookId) {
        Books books = booksRepository.getByBookId(bookId);

        books.setAuthor(booksDto.getAuthor());
        books.setBookName(booksDto.getBookName());
        books.setPrice(booksDto.getPrice());
        return modelMapper.map(books, BooksDto.class);
    }

    @Override
    public void delete(int bookId) {
        booksRepository.deleteById(bookId);
    }

    @Override
    public BooksDto getBooksById(int id) {
        Books books = booksRepository.findById(id).get();
        return modelMapper.map(books, BooksDto.class);
    }

    @Override
    public List<BooksDto> getAllBooks() {

        List<Books> booksList;
        booksList = booksRepository.findAll();
        return booksList.stream().map(book -> modelMapper.map(book, BooksDto.class)).collect(Collectors.toList());
    }
}