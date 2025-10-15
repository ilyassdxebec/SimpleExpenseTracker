package org.example;

import java.time.LocalDate;

public class Expense {
    //fields
    LocalDate date;
    String description;
    double amount;
    int id;

    //Constructor
    Expense(int id, String description, double amount){
        this.description =description;
        this.amount = amount;
        this.id = id;
        this.date = LocalDate.now();
    }
}
