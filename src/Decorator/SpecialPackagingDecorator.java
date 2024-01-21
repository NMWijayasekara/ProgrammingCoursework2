package Decorator;
import Order.Order;

public class SpecialPackagingDecorator implements PackagingDecorator {
    private double specialPackagingCost;

    public SpecialPackagingDecorator(double specialPackagingCost) {
        this.specialPackagingCost = specialPackagingCost;
    }

    @Override
    public double decorate(Order order) {
        System.out.println("Adding Special Packaging to the order.");
        return order.getTotalPrice() + specialPackagingCost;
    }
}