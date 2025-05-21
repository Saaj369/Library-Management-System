package com.example.librarymanagement;

import java.util.Scanner;

public class LibraryManagementSystem{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        String author;
        String title;
        int index;

        while(true){
            for(int i = 0; i < 20;i++){
                System.out.println();
            }
            System.out.println("Welcome to your Library Lumen!!!");
            System.out.println("How can we help you today?");
            System.out.println("1.Add a Book\n2.Search a Book.\n3.Borrow a Book.\n4.Return a Book\n5.Display all Books.\n6.Exit Library");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.print("Enter the title: ");
                    title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    author = sc.nextLine();
                    lib.addBook(title,author);
                    System.out.println("Book added successfully.");
                    System.out.print("Press enter to continue and clear console...");
                    sc.nextLine();
                    break;
                case 2:
                    System.out.print("Enter the title of the book to search: ");
                    title = sc.nextLine();
                    lib.searchTitle(title);
                    System.out.print("Press enter to continue and clear console...");
                    sc.nextLine();
                    break;
                case 3:
                    System.out.print("Here a list of all the books!\n");
                    lib.displayAllbooks();
                    System.out.print("Enter a book to borrow: ");
                    index = sc.nextInt();
                    sc.nextLine();
                    lib.borrowAbook(index-1);
                    System.out.print("Press enter to continue and clear console...");
                    sc.nextLine();
                    break;
                case 4:
                    System.out.print("Here is a list of books!\n");
                    lib.displayAllbooks();
                    System.out.print("To return a book, enter its index: ");
                    index = sc.nextInt();
                    sc.nextLine();
                    lib.returnAbook(index-1);
                    System.out.print("Press enter to continue and clear console...");
                    sc.nextLine();
                    break;
                case 5:
                    System.out.println("Here are all the books: ");
                    lib.displayAllbooks();
                    System.out.print("Press enter to continue and clear console...");
                    sc.nextLine();
                    break;
                case 6:
                    System.exit(0);
            }
        }

    }
}