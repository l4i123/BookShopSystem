package Service;

import DataAccess.ItemOrderDb;
import Model.ItemOrder;
import java.sql.Connection;
import java.util.List;

public class ItemOrderService {
    private final ItemOrderDb itemOrderDb;

    public ItemOrderService(Connection connection) {
        this.itemOrderDb = new ItemOrderDb(connection);
    }

    public boolean addItemToOrder(ItemOrder itemOrder) {
        return itemOrderDb.insert(itemOrder);
    }

    public List<ItemOrder> getItemsByOrderId(int orderId) {
        return itemOrderDb.findByOrderId(orderId);
    }

    public boolean deleteItem(int itemOrderId) {
        return itemOrderDb.delete(itemOrderId);
    }
}
