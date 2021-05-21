package com.example.spring_jwt_token_test.service.Inter;

import com.example.spring_jwt_token_test.model.Transaction;


import java.util.List;

public interface TransactionService {

    List<Transaction> getTransactionList();

    boolean addTransaction(Transaction transaction);

    boolean updateTransactionStatus(Long statusId, Long trId);

    List<Transaction> getPendingTransactionList();

    boolean markTransactionDelivery (Long trId);

    Transaction getTransactionById(Long trId);

    List <Transaction>getDeliveryTransactionList();

    boolean unMarkTransactionDelivery (Long  trId) ;

    List<Transaction> getDeliveryTransactionByUserId(Long userId);

    List<Transaction> getPendingTransactionByUserId(Long userId);

    List<Transaction> getDeliveryTransactionSearch(String keyword) ;

    List<Transaction> getPendingTransactionSearch(String keyword) ;

    List <Transaction> getDeliveryTransactionByUserIdSearch (Long userId,String keyword);

    List<Transaction> getPendingTransactionByUserIdSearch(Long userId,String keyword) ;



}
