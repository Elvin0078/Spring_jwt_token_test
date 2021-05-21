package com.example.spring_jwt_token_test.repository.Inter;

import com.example.spring_jwt_token_test.model.Book;
import com.example.spring_jwt_token_test.model.BookCategory;


import java.util.List;

public interface BookRepository {

    List<Book> getAllBook() throws Exception;

    boolean addBook(Book book) throws Exception;

    Book getBookById(Long bookId) throws Exception;

    boolean uptadeBook(Book book) throws Exception;

    boolean deleteBook(long bookId) throws Exception;

    List<BookCategory> getBookCategories() throws Exception;

    boolean updateBookCurrentCount(Long bookId,Long count) throws Exception;

    List<Book> getBookSearch(String keyword) throws Exception;



}
