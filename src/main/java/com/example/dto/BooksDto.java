package com.example.dto;

import com.example.constrant.ConstantMessageValidate;
import lombok.Data;

import javax.validation.constraints.*;
@Data
public class BooksDto {


    @Max(value = 10000,message = ConstantMessageValidate.MAX_BOOK_ID_ERROR)
    @Min(value = 0,message =ConstantMessageValidate.MIN_BOOK_ID_ERROR)
    @NotNull(message = ConstantMessageValidate.BOOK_ID_IS_NULL)
    private Integer bookId;
    private String bookName;
    private String author;
    @NotNull
    private int price;

}
