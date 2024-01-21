package Order;

import IceCream.IceCream;
import Customer.Customer;
import Payment.Payment;
import State.OrderState;
import State.PlaceOrderState;
import Decorator.PackagingDecorator;

import java.util.Date;
import java.util.List;

public class Order {
    private List<IceCream> iceCreams; // IceCream Items
    private Customer customer;
    private OrderType orderType;
    private Date initializedTime;
    private Payment payment;
    private OrderState state;
    private String feedBack;
    private int rating;
    private double totalPrice;
    private PackagingDecorator packagingDecorator;

    public Order(Customer customer, OrderType orderType, List<IceCream> iceCreams) {
        this.customer = customer;
        this.orderType = orderType;
        this.initializedTime = new Date();
        this.iceCreams = iceCreams;
        this.state = new PlaceOrderState();
    }

    public List<IceCream> getIceCreams() {
        return iceCreams;
    }

    public Date getInitializedTime() {
        return initializedTime;
    }
    public OrderType getOrderType() {
        return orderType;
    }
    public Customer getCustomer() {
        return customer;
    }

    public double getTotalPrice() {
        double total = 0.0;

        for (IceCream iceCream : iceCreams) {
            total += iceCream.getTotalPrice();
        }

        return total;
    }

    public void setPackagingDecorator(PackagingDecorator packagingDecorator) {
        this.packagingDecorator = packagingDecorator;
    }

    public Payment getPayment() {
        return this.payment;
    }

    public void setFeedBack(String feedBack, int rating) {
        this.feedBack = feedBack;
        this.rating = rating;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public OrderState getCurrentState() {
        return state;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double decorate(PackagingDecorator decorator) {
        return decorator.decorate(this);
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}