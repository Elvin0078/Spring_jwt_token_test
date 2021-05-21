package com.example.spring_jwt_token_test.repository.Impl;

import com.example.spring_jwt_token_test.mapper.BookMapper;
import com.example.spring_jwt_token_test.model.Book;
import com.example.spring_jwt_token_test.model.BookCategory;
import com.example.spring_jwt_token_test.repository.Inter.BookRepository;
import com.example.spring_jwt_token_test.sql.AppSql;

import com.example.spring_jwt_token_test.util.NumericChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {


    public NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public final BookMapper bookMapper;
    public NumericChecker numericChecker;

    @Autowired
    public BookRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, BookMapper bookMapper, NumericChecker numericChecker) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.bookMapper = bookMapper;
        this.numericChecker = numericChecker;
    }


    @Override
    public List<Book> getAllBook() {
        try {
            List<Book> bookList;
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            String sql = AppSql.GET_BOOK_LIST;
            bookList = namedParameterJdbcTemplate.query(sql, mapSqlParameterSource, bookMapper::getBookList);

            return bookList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public boolean addBook(Book book) throws Exception {
        try {
            System.out.println("==============================================" + book.getBookCategory().getId());
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue("name", book.getName());
            mapSqlParameterSource.addValue("author", book.getAuthor());
            mapSqlParameterSource.addValue("Language", book.getLanguage());
            mapSqlParameterSource.addValue("No_Copies_Actual", book.getNoCopiesActual());
            mapSqlParameterSource.addValue("No_Copies_Current", book.getNoCopiesCurrent());
            mapSqlParameterSource.addValue("Category_id", book.getBookCategory().getId());
            mapSqlParameterSource.addValue("Publication_year", book.getPublicationyear());

            int count = namedParameterJdbcTemplate.update(AppSql.ADD_BOOK, mapSqlParameterSource);
            return count > 0;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Book getBookById(Long bookId) throws Exception {

        try {
            Book book;
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue("Id", bookId);
            book = namedParameterJdbcTemplate.query(AppSql.GET_BOOK_BY_ID, mapSqlParameterSource, bookMapper::getBookById);
            return book;

        } catch (Exception e) {
            e.printStackTrace();
            return null;


        }

    }

    @Override
    public boolean uptadeBook(Book book) throws Exception {
        try {
            System.out.println("boook id - " + book.getId());
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue("book_id", book.getId());
            mapSqlParameterSource.addValue("name", book.getName());
            mapSqlParameterSource.addValue("author", book.getAuthor());
            mapSqlParameterSource.addValue("language", book.getLanguage());
            mapSqlParameterSource.addValue("no_copies_actual", book.getNoCopiesActual());
            mapSqlParameterSource.addValue("no_copies_current", book.getNoCopiesCurrent());
            mapSqlParameterSource.addValue("Category_Id", book.getBookCategory().getId());
            mapSqlParameterSource.addValue("Publication_year", book.getPublicationyear());

            int count = namedParameterJdbcTemplate.update(AppSql.UPDATE_BOOK, mapSqlParameterSource);
            return count > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean deleteBook(long bookId) throws Exception {
        try {
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue("Book_Id", bookId);
            int count = namedParameterJdbcTemplate.update(AppSql.DELETE_BOOK, mapSqlParameterSource);
            return count > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    @Override
    public List<BookCategory> getBookCategories() throws Exception {
        List<BookCategory> bookCategoryList;

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        bookCategoryList = namedParameterJdbcTemplate.query(AppSql.GET_BOOK_CATEGORY_LIST, bookMapper::getBookCategoryList);


        return bookCategoryList;
    }

    @Override
    public boolean updateBookCurrentCount(Long bookId, Long count) throws Exception {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("no_Copies_Current", count);
        mapSqlParameterSource.addValue("book_Id", bookId);

        int isUpdate = namedParameterJdbcTemplate.update(AppSql.UPDATE_BOOK_CURRENT_COUNT, mapSqlParameterSource);

        return isUpdate > 0;
    }

    @Override
    public List<Book> getBookSearch(String keyword) throws Exception {

        List<Book> bookList;

        System.out.println(keyword);

        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        if (numericChecker.isNumeric(keyword)) {

            mapSqlParameterSource.addValue("keyword", keyword);
            bookList = namedParameterJdbcTemplate.query(AppSql.GET_BOOK_LIST_SEARCH_NUMERIC, mapSqlParameterSource, bookMapper::getBookList);

        } else {

            mapSqlParameterSource.addValue("keyword", "%" + keyword + "%");
            bookList = namedParameterJdbcTemplate.query(AppSql.GET_BOOK_LIST_SEARCH, mapSqlParameterSource, bookMapper::getBookList);

        }


        return bookList;
    }


}