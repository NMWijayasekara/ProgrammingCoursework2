package Order;

import Customer.Customer;
import Decorator.PackagingDecorator;
import IceCream.IceCream;
import java.util.ArrayList;
import java.util.List;


public class OrderBuilder {
    Order order;
    private Customer customer;
    private OrderType orderType;
    private List<IceCream> iceCreams;

    public OrderBuilder(Customer customer, OrderType orderType) {
        this.customer = customer;
        this.orderType = orderType;
        this.iceCreams = new ArrayList<>();
    }

    public OrderBuilder addIceCream(IceCream iceCream) {
        iceCreams.add(iceCream);
        return this;
    }

    public OrderBuilder setPackagingDecorator(PackagingDecorator packagingDecorator) {
        order.setPackagingDecorator(packagingDecorator);
        return this;
    }

    public Order build() {
        return new Order(customer, orderType, iceCreams);
    }
}