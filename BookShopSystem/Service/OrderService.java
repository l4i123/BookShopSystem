package Service;

import DataAccess.OrdersDb;
import DataAccess.ItemOrderDb;
import Model.Book;
import Model.ItemOrder;
import Model.Orders;

import java.sql.Connection;
import java.util.List;

public class OrderService {
    private final OrdersDb ordersDb;
    private final ItemOrderDb itemOrderDb;

    public OrderService(Connection connection) {
        this.ordersDb = new OrdersDb(connection);
        this.itemOrderDb = new ItemOrderDb(connection);
    }

    public int createOrder(int userId) {
        return ordersDb.createOrder(userId);
    }

    public boolean addBookToOrder(int orderId, Book book, int quantity) {
        if (book.getQuantity() < quantity) return false;

        ItemOrder itemOrder = new ItemOrder( orderId, quantity, book.getIdBook());
        return itemOrderDb.insert(itemOrder);
    }

    public List<ItemOrder> getItemsForOrder(int orderId) {
        return itemOrderDb.findByOrderId(orderId);
    }

    public void finalizeOrder(int orderId, double totalAmount) {
        ordersDb.updateTotalPrice(orderId, totalAmount);
        ordersDb.updateStatus(orderId, "COMPLETED");
    }

    public List<Orders> getOrdersByUserId(int userId) {
        return ordersDb.getOrdersByUserId(userId);
    }
}
