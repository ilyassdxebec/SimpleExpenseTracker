package org.example;//needed libraries👇
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

       ObjectMapper mapper = new ObjectMapper();
       File expenseFile = new File("expense.json");
       ArrayList<Expense> expenseList = new ArrayList<>();
       String command = "";
       int nextID = 1;

           command = args[0].toLowerCase();

           //check if expense file exists and
        if(expenseFile.exists()){
            Expense[] loaded = mapper.readValue(expenseFile,Expense[].class);
            for(Expense e: loaded) expenseList.add(e);
            if(!expenseList.isEmpty()){
                nextID = expenseList.get(expenseList.size()-1).id+1;
            }
        }
           switch (command) {
               case "add":
                   if(args.length<3){
                       System.out.println("Usage: java Main 'add' 'description' 'amount'.");
                       break;
                   }
                   //code to add expense:
                   String description = args[1];
                   double amount = Double.parseDouble(args[2]);
                   Expense expense = new Expense(nextID, description, amount);
                   expenseList.add(expense);
                   nextID++;
                   mapper.writeValue(expenseFile,expenseList);
                   System.out.println("Expense added successfully!");
                   break;

               case "update":
                   if(args.length<4){
                       System.out.println("Usage: java Main 'update' 'ID' 'NewDescription' 'NewAmount'.");
                       break;
                   }
                   //code to update expense:
                   int IDtoUpdate = Integer.parseInt(args[1]);
                   String NewDescription = args[2];
                   double NewAmount = Double.parseDouble(args[3]);
                   boolean found = false;

                   for (Expense e : expenseList) {
                       if (e.id == IDtoUpdate) {
                           e.description = NewDescription;
                           e.amount = NewAmount;
                           found = true;
                           break;
                       }
                   }
                   if(found){
                       mapper.writeValue(expenseFile,expenseList);
                       System.out.println("Expense updated successfully! ");
                   }
                   else{
                       System.out.println("Expense with ID "+IDtoUpdate+" Not found ");

                   }
                   break;

               case "delete":
                   //code to delete expense:
                   if (args.length < 2) {
                       System.out.println("Usage: java Main 'delete' 'ID'");
                       break;
                   }

                   int idToDelete = Integer.parseInt(args[1]);
                   boolean deleted = false;

                   for (int i = 0; i < expenseList.size(); i++) {
                       if (expenseList.get(i).id == idToDelete) {
                           expenseList.remove(i);
                           mapper.writeValue(expenseFile, expenseList);
                           System.out.println("Expense deleted successfully!");
                           deleted = true;
                           break;
                       }
                   }

                   if (!deleted) {
                       System.out.println("Expense with ID " + idToDelete + " not found.");
                   }
                   break;
               case "list":
                   //code to list expenses:
                   if(expenseList.isEmpty()){
                       System.out.println("No expenses are recorder!");
                       break;
                   }
                   System.out.println("ID | Description | Amount | Date");
                   System.out.println("------------------------------------");
                   for (Expense e : expenseList) {
                       System.out.printf("%d | %s | %.2f | %s%n", e.id, e.description, e.amount, e.date);
                   }
                   break;

               case "summary":
                   //code to show summary:
                   if (expenseList.isEmpty()) {
                       System.out.println("No expenses recorded!");
                       break;
                   }

                   double total = 0;
                   int count = expenseList.size();

                   for (Expense e : expenseList) {
                       total += e.amount;
                   }

                   double average = total / count;

                   System.out.println("Expense Summary:");
                   System.out.println("----------------");
                   System.out.printf("Total expenses: %.2f%n", total);
                   System.out.println("Number of entries: " + count);
                   System.out.printf("Average expense: %.2f%n", average);
                   break;

               default:
                   System.out.println("Unknown command");
           }

    }
}