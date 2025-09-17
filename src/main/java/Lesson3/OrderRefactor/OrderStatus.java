package Lesson3.OrderRefactor;

public enum OrderStatus {
    PENDING(1),
    PROCESSING(2),
    SHIPPED(3),
    DELIVERED(4);

    private final int value;

    // Constructor to set the numeric value for each enum
    OrderStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
