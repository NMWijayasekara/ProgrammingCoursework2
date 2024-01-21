package Decorator;
import Order.Order;

public class GiftWrappingDecorator implements PackagingDecorator {
    private double giftWrappingCost;

    public GiftWrappingDecorator(double giftWrappingCost) {
        this.giftWrappingCost = giftWrappingCost;
    }

    @Override
    public double decorate(Order order) {
        System.out.println("Adding Gift Wrapping to the order.");
        return order.getTotalPrice() + giftWrappingCost;
    }
}