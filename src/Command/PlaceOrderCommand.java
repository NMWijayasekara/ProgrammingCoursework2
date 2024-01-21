package Command;

import Order.Order;
import Order.OrderBuilder;

public class PlaceOrderCommand extends Command {
    private OrderBuilder orderBuilder;

    public PlaceOrderCommand(OrderBuilder orderBuilder) {
        this.orderBuilder = orderBuilder;
    }

    @Override
    public void execute() {
        // Here, you can perform the logic to place the order
        // For example, you can build the order and then process it
        Order order = orderBuilder.build();
        processOrder(order);
    }

    private void processOrder(Order order) {
        // Logic to process the order, such as sending it to the kitchen, updating inventory, etc.
        System.out.println("Order placed successfully!");
        System.out.println("Order details: " + order.toString());
    }
}