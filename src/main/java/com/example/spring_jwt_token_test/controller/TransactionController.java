package com.example.spring_jwt_token_test.controller;

import com.example.spring_jwt_token_test.model.Transaction;
import com.example.spring_jwt_token_test.service.Inter.BookService;
import com.example.spring_jwt_token_test.service.Inter.TransactionService;
import com.example.spring_jwt_token_test.service.Inter.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/tr")
public class TransactionController {

    public UserService userService;
    public BookService bookService;
    public TransactionService transactionService;



    @Autowired
    public TransactionController(UserService userService, BookService bookService, TransactionService transactionService) {
        this.userService = userService;
        this.bookService = bookService;
        this.transactionService = transactionService;

    }


    @GetMapping("/getTransactions")
    ResponseEntity<?> getTransactions() {
        List trList = transactionService.getTransactionList();
        return new ResponseEntity<>(trList, HttpStatus.OK);
    }



    @PutMapping("/updateTransactionStatus")
    public ResponseEntity<?> updateTransactionStatus(@RequestParam("statusId") Long statusId,
                                                     @RequestParam("trId") Long trId) {
        boolean result = transactionService.updateTransactionStatus(statusId, trId);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @GetMapping("/getPendingTransactions")
    ResponseEntity<?> getPendingTransactions() {
        List trList = transactionService.getPendingTransactionList();
        return new ResponseEntity<>(trList, HttpStatus.OK);
    }

    @PutMapping("/markTransactionDelivery")
    ResponseEntity<?> markTransactionDelivery(@RequestParam("trId") Long trId) {
        boolean result = transactionService.markTransactionDelivery(trId);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @PutMapping("/unMarkTransactionDelivery")
    ResponseEntity<?> unMarkTransactionDelivery(@RequestParam("trId") Long trId) {
        boolean result = transactionService.unMarkTransactionDelivery(trId);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @GetMapping("/getDeliveryTransaction")
    ResponseEntity<?> getDeliveryTransactions() {
        List trList = transactionService.getDeliveryTransactionList();
        return new ResponseEntity<>(trList, HttpStatus.OK);
    }




    @GetMapping("getDeliveryTransactionSearch")
    ResponseEntity<?> getDeliveryTransactionSearch(@RequestParam("keyword") String keyword) {
        List<Transaction> transactionList = transactionService.getDeliveryTransactionSearch(keyword);
        return new ResponseEntity<>(transactionList, HttpStatus.OK);
    }

    @GetMapping("getPendingTransactionSearch")
    ResponseEntity<?> getPendingTransactionSearch(@RequestParam("keyword") String keyword) {
        List<Transaction> transactionList = transactionService.getPendingTransactionSearch(keyword);
        return new ResponseEntity<>(transactionList, HttpStatus.OK);
    }






}



