package Model;

import java.time.LocalDateTime;

public class UserHasOnSale{
    private int userId;
    private int onSaleId;
    private LocalDateTime usedAt;

    public UserHasOnSale(int userId, int onSaleId, LocalDateTime usedAt) {
        this.userId = userId;
        this.onSaleId = onSaleId;
        this.usedAt = usedAt;
    }
    public int getUserId() {
        return userId;
    }
    public int getOnSaleId() {
        return onSaleId;
    }
    public LocalDateTime getUsedAt() {
        return usedAt;
    }
    public void setUsedAt(LocalDateTime usedAt) {
        this.usedAt = usedAt;
    }
}