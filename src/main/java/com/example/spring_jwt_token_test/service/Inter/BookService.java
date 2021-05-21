package com.example.spring_jwt_token_test.service.Inter;

import com.example.spring_jwt_token_test.model.Book;
import com.example.spring_jwt_token_test.model.BookCategory;


import java.util.List;

public interface BookService {
    List<Book> getAllBook() ;

    boolean addBook(Book book);

    Book getBookById(Long bookId);

    boolean uptadeBook (Book book);

    boolean deleteBook (long bookId);

    List<BookCategory> getBookCategories();

    boolean updateBookCurrentCount(Long bookId,Long count);

    List<Book> getBookSearch(String keyword) ;
}
