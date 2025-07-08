package Model;

public class ItemOrder {
    private int itemOrderId;
    private int orderId;
    private int bookId;
    private int quantity;

    public ItemOrder( int orderId, int bookId, int quantity) {
       
        this.orderId = orderId;
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public int getItemOrderId() {
        return itemOrderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getBookId() {
        return bookId;
    }

    public int getQuantity() {
        return quantity;
    }
    

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
