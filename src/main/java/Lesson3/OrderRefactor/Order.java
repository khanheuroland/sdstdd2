package Lesson3.OrderRefactor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Order {
    private double price;
    //private int status; // 1: PENDING, 2: PROCESSING, 3: SHIPPED, 4: DELIVERED
    private OrderStatus status;
    private String customerEmail;

    public Order(double price, String customerEmail) {
        this.price = price;
        this.customerEmail = customerEmail;
        this.status = OrderStatus.PENDING;//1; // Default is PENDING
    }

    // Getters and Setters
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String email) { this.customerEmail = email; }
}