package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
// good variable names, nice ☺
public class Main {
    private static ArrayList<String> books = new ArrayList<>();
//I need to find the text file and make sure it works
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many books would you like to enter?");
        int numBooks=scanner.nextInt();
        //createFile();
        for (int i = 0; i <numBooks ; i++) {
            books.add(getBookDetails());
        }

        writeToFile(books);

    }

    public static String getBookDetails() {
        int bookIsbn = Integer.parseInt(getInput("Enter book ISBN"));
        String bookName = getInput("Enter book name");
        String bookAuthor = getInput("Enter author");
        String bookGenre = getInput("Enter genre");
        return (bookIsbn + "," + bookName + "," + bookAuthor + "," + bookGenre);

    }

    public static String getInput(String prompt) {
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void createFile() {
        try {
            File fileObj = new File("bookfile.txt");
            if (fileObj.createNewFile()) {
                System.out.println("File created: " + fileObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred."); // show which error
            e.printStackTrace();


        }
    }
    public static void writeToFile(ArrayList<String> bookList ){
        try {
            FileWriter myWriter = new FileWriter("bookfile.txt");
            myWriter.write(String.valueOf(bookList));
        }catch (IOException e){
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
}
