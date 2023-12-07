package dev.jasperwiese.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dev.jasperwiese.service.TransactionService;

@Deprecated
public class Application {

    //public static final TransactionService transactionService = new TransactionService(bankSlogan);
    //Explicitly Registered the JavaTimeModule to add support for the serialization of the Java 8 date/times types
    public static final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

}
