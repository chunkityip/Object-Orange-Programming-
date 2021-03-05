package main;

public class Book {
    /**
        To encapsulated books information
     */

    /*
     * Encapsulation : set instance variable to private
     *                 set setter and getter method
     */


    private int book_id; //book number
    private String book_name; //book name
    private double price; //book price
    private String author;
    private String pub_House; //publishing house
    private int store_Number; // the number of book we have

    private int buyNum; //how many book customer want

    //Constructor
    public Book(int id, String name, double price, String author, String pub_House, int store_Number) {
        super();
        this.book_id = id;
        this.book_name = name;
        this.price = price;
        this.author = author;
        this.pub_House = pub_House;
        this.store_Number = store_Number;
        this.buyNum = buyNum;
    }

    public int getId() {
        return book_id;
    }

    public void setId(int id) {
        this.book_id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String name) {
        this.book_name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPub_House() {
        return pub_House;
    }

    public void setPub_House(String pub_House) {
        this.pub_House = pub_House;
    }

    public int getStore_Number() {
        return store_Number;
    }

    public void setStore_Number(int store_Number) {
        this.store_Number = store_Number;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }



}
