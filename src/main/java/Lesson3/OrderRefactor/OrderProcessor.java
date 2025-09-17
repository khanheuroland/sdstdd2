package Lesson3.OrderRefactor;

public class OrderProcessor {
    private boolean checkValidOrder(Order order)
    {
        String customerEmail = order.getCustomerEmail();
        if(customerEmail == null || customerEmail.isEmpty())
            return false;
        else
            return order.getPrice()<=0;
    }

    private double getOrderPrice(Order order)
    {
        final double promotionPrice = 100.0;
        final double discountRatio = 0.1;
        double applyDiscount =1;
        if (order.getPrice() > promotionPrice) {
            applyDiscount = 1-discountRatio;
        }
        return order.getPrice()*applyDiscount;
    }

    private void sendEmail(String email)
    {
        // 4. Send a confirmation email to the customer
        System.out.println("Sending confirmation email to " + email);
        // (logic gửi email giả lập)
        System.out.println("Email sent successfully.");
    }

    private void finishOrder(Order order)
    {
        // 5. Finalize the process
        System.out.println("Order " + order.hashCode() + " processed successfully.");
    }
    public void process(Order order) {

        if(!checkValidOrder(order))
        {
            System.out.println("ERROR: Invalid order data.");
            return;
        }

        double newOrderPrice = getOrderPrice(order);
        order.setPrice(newOrderPrice);
        order.setStatus(OrderStatus.PROCESSING);

        System.out.println("Order status updated to PROCESSING.");
        sendEmail(order.getCustomerEmail());
        finishOrder(order);
    }
}