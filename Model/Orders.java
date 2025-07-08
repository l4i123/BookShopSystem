package Model;

import java.time.LocalDateTime;

public class Orders {
    private int orderId; // Order ID
    private int userId;
    private LocalDateTime orderDateTime; // Date and time of the order
    private String status; // Date of the order
    private double totalAmount; // Total amount of the order

    public Orders(int orderId, int userId, LocalDateTime orderDateTime, String status, double totalAmount) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderDateTime = orderDateTime;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }
    public int getUserId() {
        return userId;
    }
    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }
    public String getStatus() {
        return status;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }   
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    //функция за пресмятане на общата сума на поръчката
    public void calculateTotalAmount(double itemPrice, int quantity) {
        this.totalAmount += itemPrice * quantity;
    }
}
