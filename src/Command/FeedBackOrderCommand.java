package Command;

import Order.Order;

public class FeedBackOrderCommand extends Command {
    private Order order;
    private String feedback;
    private int rating;

    public FeedBackOrderCommand(Order order, String feedback, int rating) {
        this.order = order;
        this.feedback = feedback;
        this.rating = rating;
    }

    @Override
    public void execute() {
        order.setFeedBack(feedback, rating);
        System.out.println("Feedback and rating added to the order.");
    }
}