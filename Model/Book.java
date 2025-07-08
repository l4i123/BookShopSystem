package Model;

public class Book {
    private int idBook;
    private String title;
    private String author;
    private String category;
    private double price;
    private int quantity;
    private Integer idOnSale; // Може да е Null ако не е на промоция

    public Book(int idBook, String title, String author, String category, double price, int quantity, Integer idOnSale) {
        this.idBook = idBook;
        this.title = title;
        this.author = author;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.idOnSale = idOnSale; 
    }

    public int getIdBook() {
        return idBook;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    
    public String getCategory() {
        return category;
    }
   
    public double getPrice() {
        return price;
    }
   
    public int getQuantity() {
        return quantity;
    }
    
    public Integer getIdOnSale() {
        return idOnSale;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

     public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setIdOnSale(Integer idOnSale) {
        this.idOnSale = idOnSale;
    }
    
}
