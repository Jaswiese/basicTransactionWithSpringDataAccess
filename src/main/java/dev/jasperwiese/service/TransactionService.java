package dev.jasperwiese.service;

import dev.jasperwiese.model.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
@Service
public class TransactionService {

    private final String bankSlogan;

    //TODO: Need to implement persistent REPO
    List<Transaction> transactions = new CopyOnWriteArrayList<>();

    public TransactionService(@Value("${bank.slogan}")String bankSlogan) {
        this.bankSlogan = bankSlogan;
    }

    public List<Transaction> findAll() {
        return transactions;
    }

    public List<Transaction> findByIncomingId(String userId) {
        return transactions
                .stream()
                .filter(c -> c.getId().equals(userId))
                .toList();
    }

    public Transaction create(BigDecimal amount, String reference){
        ZonedDateTime timeStamp = ZonedDateTime.now();
        Transaction transaction = new Transaction(amount,timeStamp,reference, bankSlogan);
        System.out.println("serivce call: " + transaction);
        transactions.add(transaction);
        return transaction;
    }

    public Transaction createFromInput(BigDecimal amount, String reference, String inputUser) {
        ZonedDateTime timeStamp = ZonedDateTime.now();
        Transaction transaction = new Transaction(amount, timeStamp, reference, bankSlogan, inputUser);
        transactions.add(transaction);
        return transaction;
    }

}
