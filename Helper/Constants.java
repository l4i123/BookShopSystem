package Helper;

public class Constants {
    //статус на поръчка
    public static final String ORDER_STATUS_PROCESSING = "Processing";
    public static final String ORDER_STATUS_SHIPPED = "Shipped";
    public static final String ORDER_STATUS_COMPLETED = "Completed";
    public static final String ORDER_STATUS_CANCELLED = "Cancelled";

    //Валутни кодове
    public static final String CURRENCY_BGN = "BGN"; // Български лев
    public static final String CURRENCY_EUR = "EUR"; // Евро
    public static final String CURRENCY_USD = "USD"; // Американски долар

    //Формати на дати
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss"; // Формат на дата и час

    //Грешки
    public static final String ERROR_INVALID_INPUT = "Invalid input provided.";
    public static final String ERROR_DATABASE_CONNECTION = "Database connection error.";
    public static final String ERROR_BOOK_NOT_FOUND = "Book not found.";
    public static final String ERROR_ORDER_NOT_FOUND = "Order not found.";
    public static final String ERROR_USER_NOT_FOUND = "User not found.";
    public static final String ERROR_PAYMENT_FAILED = "Payment processing failed.";
    public static final String ERROR_INSUFFICIENT_STOCK = "Insufficient stock for the requested item.";
    public static final String ERROR_UNAUTHORIZED_ACCESS = "Unauthorized access attempt detected.";
    public static final String ERROR_INVALID_CREDENTIALS = "Invalid username or password.";
    public static final String ERROR_EMAIL_ALREADY_EXISTS = "An account with this email already exists.";
    public static final String ERROR_PASSWORD_MISMATCH = "Passwords do not match.";
    //и други грешки, които може да се наложи да добавите   
    
}
