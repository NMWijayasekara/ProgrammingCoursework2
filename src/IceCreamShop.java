import Decorator.SpecialPackagingDecorator;
import IceCream.Flavor;

import java.util.ArrayList;
import java.util.List;

import java.util.*;
import IceCream.*;
import Payment.*;
import Customer.*;
import Order.*;
import Decorator.*;
import State.*;
import Command.*;

public class IceCreamShop {
    private static IceCreamShop instance;
    private List<Flavor> flavors;
    private List<Topping> toppings;
    private List<Syrup> syrups;
    private List<IceCream> iceCreams;
    private List<Customer> customers;
    private List<Order> orders;
    private List<Promotion> promotions;
    private LoyaltyProgram loyaltyProgram;

    private IceCreamShop() {
        this.flavors = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.syrups = new ArrayList<>();
        this.iceCreams = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.promotions = new ArrayList<>();
        this.loyaltyProgram = new SimpleLoyaltyProgram(); // Default loyalty program
    }

    public static IceCreamShop getInstance() {
        if (instance == null) {
            instance = new IceCreamShop();
        }
        return instance;
    }

    // Methods to add flavors, toppings, syrups, customers, and promotions

    public void setLoyaltyProgram(LoyaltyProgram loyaltyProgram) {
        this.loyaltyProgram = loyaltyProgram;
    }

    public LoyaltyProgram getLoyaltyProgram() {
        return loyaltyProgram;
    }

    // Additional methods for adding flavors, toppings, syrups, customers, and promotions
    public void addFlavor(String name, double price) {
        flavors.add(new Flavor(name, price));
    }

    public void addTopping(String name, double price) {
        toppings.add(new Topping(name, price));
    }

    public void addSyrup(String name, double price) {
        syrups.add(new Syrup(name, price));
    }

    public void addCustomer(String name, String address, String phone) {
        customers.add(new Customer(name, address, phone));
    }

    public void addPromotion(Promotion promotion) {
        promotions.add(promotion);
    }

    // Additional methods for applying promotions and placing orders
    public void applyPromotions() {
        Date currentDate = new Date();
        for (Order order : orders) {
            for (Promotion promotion : promotions) {
                if (promotion.isApplicable(currentDate)) {
                    promotion.applyPromotion(order.getIceCreams());
                }
            }
        }
    }

    // Implement getters for flavors, toppings, syrups, customers, promotions, orders, and loyaltyProgram
    public List<Flavor> getFlavors() {
        return flavors;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public List<Syrup> getSyrups() {
        return syrups;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void placeOrder(Order order) {
        // Additional logic to handle order placement, such as updating inventory, sending to the kitchen, etc.
        orders.add(order);
        System.out.println("Order placed successfully!");
    }

    
    public static void main(String[] args) {
        IceCreamShop iceCreamShop = IceCreamShop.getInstance();

        // Add flavors, toppings, syrups, and customers
        iceCreamShop.addFlavor("Chocolate", 1.0);
        iceCreamShop.addTopping("Sprinkles", 0.5);
        iceCreamShop.addSyrup("Chocolate Syrup", 0.7);
        iceCreamShop.addCustomer("John Doe", "123 Main St", "555-1234");

        // Add a promotion (Seasonal Flavor Discount)
        Promotion seasonalDiscount = new SeasonalFlavorDiscount("Chocolate", 10.0, new Date(), new Date());
        iceCreamShop.addPromotion(seasonalDiscount);

        // Create an order builder with a customer and order type
        Customer customer = iceCreamShop.getCustomers().get(0);
        OrderBuilder orderBuilder = new OrderBuilder(customer, OrderType.Delivery);

        // Create an ice cream with scoops, toppings, and syrups
        IceCream chocolateIceCream = new IceCream.Builder("Chocolate Ice Cream")
                .setPackaging(Packaging.MediumCup)
                .addScoop(iceCreamShop.getFlavors().get(0), 2)
                .addTopping(iceCreamShop.getToppings().get(0))
                .addSyrup(iceCreamShop.getSyrups().get(0))
                .build();

        // Add the ice cream to the order builder
        Order order = orderBuilder.addIceCream(chocolateIceCream).build();

        // Place the order
        iceCreamShop.placeOrder(order);

        // Apply promotions
        iceCreamShop.applyPromotions();

        // Display order details
        System.out.println("Order Details:");
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Order Type: " + order.getOrderType());
        System.out.println("Ice Creams:");

        for (IceCream iceCream : order.getIceCreams()) {
            System.out.println("- " + iceCream.getName());
        }

        System.out.println("Total Price after Applying Promotions: $" + order.getTotalPrice());
    }
}
