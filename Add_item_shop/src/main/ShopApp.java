package main;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ShopApp {

    //setting all books into object books
    private static ArrayList<Book> book_list = new ArrayList<>();
    //setting shopping car info into HashMap
    //private static HashMap<Integer , Book> itemInShopCar = new HashMap<>();

    //setting shopping car by using HashMap. Keys as the book id and value as storing books
    static HashMap<Integer, Book> shopCar = new HashMap<>();


    //Initialize the books stores following by this order from Book class
    static {
        book_list.add(new Book(1, "Learn Java   3rd Edition", 99.23, "Tony Gaddis", "MyProgrammingLab", 70));
        book_list.add(new Book(2, "Learn C++    3rd Edition", 99.23, "Tony Gaddis", "MyProgrammingLab", 52));
        book_list.add(new Book(3, "Learn Python 3rd Edition", 99.23, "Tony Gaddis", "MyProgrammingLab", 100));

    }

    public static void main(String[] args) {

        //Display main page
        System.out.println("===============Welcome to The CKY book shop===============");
        System.out.println("Book ID\t\tBook Name\t\t\t\t\tPrices\t\tThe author\t\tPublishing house\t\tHow many books left");
        for (int i = 0; i < book_list.size(); i++) {
            System.out.println(book_list.get(i).getId() + "\t\t" + book_list.get(i).getBook_name() + "\t\t" + book_list.get(i).getPrice() + "\t\t" +
                    book_list.get(i).getAuthor() + "\t\t" + book_list.get(i).getPub_House() + "\t\t" + book_list.get(i).getStore_Number());
        }

        System.out.println(("Please enter the command order: Adding book info from shopping card(add), " +
                "delete book from shopping car(delete), check your shopping car (check), update book info from shopping car(update)" +
                "return to main page(return) , order(order)"));
        System.out.println("Enter your command: ");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();

        ShopApp.userOperas(command);


        //System.out.println("Command:" + command);
    }

    //Display different method according to the different command : add , delete , update , return and order
    public static void userOperas(String command) {
        //try to use switch case
        switch (command) {
            case "add":
                ShopApp.abbBookToShopCar();
                break;
            case "delete":
                ShopApp.deleteBookShopCar();
                break;
            case "check" :
                ShopApp.showShopCar();
                break;
            case "update":
                ShopApp.updateShopCar();
                break;
            case "return":
                ShopApp.main(null);
                break;
            case "order":
                ShopApp.orderCommint();
                break;
            default:
                System.out.println("What you are typing is incorrect. Please double check!");
                ShopApp.main(null);
                break;
        }
    }

    public static void orderCommint() {
        //to check is shopping car have any item
        if (ShopApp.shopCar.isEmpty()) {
            System.out.println("There have no book in the shopping car");
            System.out.println("....return to main page");
            ShopApp.main(null);
        } else {
            System.out.println("Thank you for your purchase , we are looking forward to serving you in the future!");
        }
    }

    //update the book purchase the shopping car
    public static void updateShopCar() {
        System.out.println("Please enter the Book ID you want to update: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        //if book already exist , ask user input to add purchase amount
        if (ShopApp.shopCar.containsKey(id)) {
            System.out.println("Please enter the purchase amount you want to change: ");
            int buyNumber = scanner.nextInt();

            //according to the id to get the info so we can update and check the storage
            Book book = ShopApp.shopCar.get(id);
            //update book from shopping car
            book.setBuyNum(buyNumber);
            //update storage : previous purchase + previous storage - buying now = storage now
            book.setStore_Number(book.getBuyNum() + book.getStore_Number() - buyNumber);
            //update purchase number
            book.setBuyNum(buyNumber);

            ShopApp.showShopCar();
        } else {
            System.out.println("The book you want to update isn't exist in shopping car , please double check!");
            updateShopCar();
        }
    }

    //delete book from shopping car
    public static void deleteBookShopCar() {
        System.out.println("Please enter the Book ID you want to delete: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        //check is the book id exist in shopping car , if exist , remove it and add back to store, else ask customer to double check
        if (ShopApp.shopCar.containsKey(id)) {
            Book book = ShopApp.shopCar.get(id);
            book.setStore_Number(book.getStore_Number() + book.getBuyNum());
            ShopApp.shopCar.remove(id);

            //return to main page
            ShopApp.showShopCar();
        } else {
            System.out.println("The id you enter didn't exist in you shopping car! Please double check.");
            deleteBookShopCar();
        }

    }


    //adding to shopping method
    public static void abbBookToShopCar() {
        System.out.println("Please enter the Book ID: ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        //check how many books left. If the store can supply , sale it to customer. If there have no such of book , tell our customer
        Book book = getBookByID(id);
        if (book == null) {
            System.out.println("The id your enter isn't exist, please enter the correct id");
            abbBookToShopCar();
        } else {
            System.out.println("Enter how many you want to purchase: ");
            int buyNumber = scanner.nextInt();
            System.out.println("Purchase amount: " + buyNumber);

            //check if the book already in the shopping car.If yes , update the number. If no , enter the number directly
            if (ShopApp.shopCar.containsKey(id)) {
                int newBuyNum = book.getBuyNum() + buyNumber;
                book.setBuyNum(newBuyNum);
                ShopApp.shopCar.put(id, book);
            } else {
                book.setBuyNum(buyNumber);
                ShopApp.shopCar.put(id, book);
            }
            //Update the storage
            book.setStore_Number(book.getStore_Number() - buyNumber);

            //Display all book in shopping car by using showShopCar Method
            showShopCar();
        }
    }
            //Display all book in shopping car
            public static void showShopCar () {
                Collection<Book> books = ShopApp.shopCar.values();

                //if there have no book in shopping car , display null
                if (books.isEmpty()) {
                    System.out.println("There have no book in the shopping car");
                    System.out.println("....return to main page");
                    ShopApp.main(null);
                } else {
                    System.out.println("===============Here is your shopping car===============");
                    System.out.println("Book ID\t\tBook Name\t\t\t\t\tPrices\t\tThe author\t\tPublishing house\t\tPurchase amount");
                    //for (int i = 0; i < books.size(); i++) {
                    for (Book b : books) {
                        System.out.println(b.getId() + "\t\t" + b.getBook_name() + "\t\t" + b.getPrice() + "\t\t" +
                                b.getAuthor() + "\t\t" + b.getPub_House() + "\t\t" + b.getBuyNum());
                    }
                    System.out.println(("Please enter the command order: Adding book info from shopping card(add), " +
                            "delete book from shopping car(delete), update book info from shopping car(update) , return to main page(return)" +
                            "order(order)"));
                    System.out.println("Enter your command: ");
                    Scanner scanner = new Scanner(System.in);
                    String command = scanner.next();

                    ShopApp.userOperas(command);

                }
            }

    //base on the book id to check the book info , if null return null , else return the book itself
    public static Book getBookByID(int id) {
        for (int i = 0; i < book_list.size(); i++) {
            Book book = book_list.get(i);
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}

