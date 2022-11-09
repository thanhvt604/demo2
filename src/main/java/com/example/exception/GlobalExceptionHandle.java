package com.example.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandle {


    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<String> nullPointException(Exception e)
    {
        return ResponseEntity.status(299).body(e.getMessage());
    }

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<String> handleNoSuchException(Exception e)
    {
        return ResponseEntity.status(500).body(e.getMessage());
    }

    @ExceptionHandler({SQLException.class})
    public ResponseEntity<String> handleDatabaseException()
    {
        return ResponseEntity.status(501).body("Database connect is broken !");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnwantedException(Exception e) {
         e.printStackTrace();
        return ResponseEntity.status(500).body("Unknow error");
    }

}
