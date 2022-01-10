package com.company;

import java.io.FileNotFoundException;
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
        login();
        int numOfBooks = numOfBooks();


        for (int i = 0; i < numOfBooks; i++) {
            books.add(getBookDetails());
            System.out.println(books);

        }
        int menuOption;
        while (true) {
            menuOption = menu();
            if (menuOption == 1) {
                createFile();
            } else if (menuOption == 2) {
                writeToFile(books);
            } else if (menuOption == 4) {
                break;
            }else if (menuOption==3){
                writeToUserFile();

            }

        }

    }

    public static void login() {
        File file = new File("users.txt");
        try {
            Scanner scanner = new Scanner(System.in);
            Scanner scanner1 = new Scanner(file);
            String userName;
            String line;
            String password;
            boolean x = true;
            while (x) {
                System.out.println("What is your username?");
                userName = scanner.nextLine();
                int lineNum = 0;
                while (scanner1.hasNextLine()) {
                     line = scanner1.nextLine();
                    lineNum++;
                    if (line.contains(userName)) {
                        System.out.println("Username is correct");
                        System.out.println("What is your password?");
                         password = scanner.next();
                        if (line.contains(password)) {
                            System.out.println("password is correct");
                            x = false;
                        } else {
                            System.out.println("Incorrect password");
                        }
                    } else {
                        System.out.println("Incorrect username");
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an Option 1-3:");
        System.out.println("1) Create File");
        System.out.println("2) Write Book Details to File");
        System.out.println("3) Create New User");
        System.out.println("4) Quit Program");
        int menuOption = scanner.nextInt();
        return menuOption;
    }

    public static int numOfBooks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many books would you like to enter?");
        int numBooks = scanner.nextInt();
        return (numBooks);
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
                Scanner scanner = new Scanner(System.in);
                System.out.println("Would you like to delete the file 1=Y, 2=N?");
                int deleteFile = scanner.nextInt();
                if (deleteFile == 1) {
                    fileObj.delete();
                    System.out.println("File has been deleted");
                }

            }
        } catch (IOException e) {
            System.out.println("An error occurred."); // show which error
            e.printStackTrace();


        }
    }

    public static void writeToFile(ArrayList<String> bookList) {
        try {
            FileWriter myWriter = new FileWriter("bookfile.txt");
            //myWriter.write(String.valueOf(bookList));
            myWriter.write(String.valueOf(books));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
    public static String getUserDetails() {

        String userName = getInput("enter username");
        String userPassword = getInput("Enter password");

        return (userName + "," + userPassword);

    }
    public static void writeToUserFile() {
        try {
            FileWriter myWriter = new FileWriter("users.txt");
            //myWriter.write(String.valueOf(bookList));
            myWriter.write(getUserDetails());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
}
