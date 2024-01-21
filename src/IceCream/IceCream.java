package IceCream;

import Decorator.PackagingDecorator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IceCream {
    private final String name;
    private final Map<Flavor, Integer> scoops;
    private final List<Topping> toppings;
    private final List<Syrup> syrups;
    private PackagingDecorator packagingStyle;
    private double totalPrice;
    private Packaging packaging;

    private IceCream(Builder builder) {
        this.name = builder.name;
        this.scoops = builder.scoops;
        this.toppings = builder.toppings;
        this.syrups = builder.syrups;
        this.packaging = builder.packaging;
    }

    public String getName() {
        return name;
    }
    public Map<Flavor, Integer> getScoops() {
        return scoops;
    }
    public List<Topping> getToppings() {
        return toppings;
    }
    public List<Syrup> getSyrups() {
        return syrups;
    }

    public double getTotalPrice() {
        double total = 0.0;

        // Calculate total price for scoops
        for (Map.Entry<Flavor, Integer> entry : scoops.entrySet()) {
            Flavor flavor = entry.getKey();
            int scoopCount = entry.getValue();
            total += flavor.getPrice() * scoopCount;
        }

        // Calculate total price for toppings
        for (Topping topping : toppings) {
            total += topping.getPrice();
        }

        // Calculate total price for syrups
        for (Syrup syrup : syrups) {
            total += syrup.getPrice();
        }

        return total;
    }

    public void setTotalPrice(double price) {
        this.totalPrice = price;
    }

    public static class Builder {
        private final String name;
        private final Map<Flavor, Integer> scoops;
        private final List<Topping> toppings;
        private final List<Syrup> syrups;
        private Packaging packaging;
        private PackagingDecorator packagingStyle;

        public Builder(String name) {
            this.name = name;
            this.scoops = new HashMap<>();
            this.toppings = new ArrayList<>();
            this.syrups = new ArrayList<>();
        }

        public Builder setPackaging(Packaging packaging) {
            this.packaging = packaging;
            return this;
        }

        public Builder setStyle(Packaging packaging) {
            this.packaging = packaging;
            return this;
        }

        public Builder addScoop(Flavor flavor, int scoopCount) {
            if (packaging != null) {
                // Calculate the total number of scoops for all flavors
                int currentScoops = scoops.values().stream().mapToInt(Integer::intValue).sum();

                // Check if adding the specified scoopCount exceeds the packaging limit
                if (packaging.canAddScoop(currentScoops, scoopCount)) {
                    // Check if the flavor already exists in the map
                    if (scoops.containsKey(flavor)) {
                        // If it exists, increment the scoops
                        scoops.put(flavor, currentScoops + scoopCount);
                    } else {
                        // If it doesn't exist, add a new entry
                        scoops.put(flavor, scoopCount);
                    }
                } else {
                    System.out.println("Cannot add scoops. Ice Sy limit reached.");
                }
            } else {
                System.out.println("Please set the Packaging before adding scoops.");
            }
            return this;
        }

        public Builder addTopping(Topping topping) {
            toppings.add(topping);
            return this;
        }
        public Builder addSyrup(Syrup syrup) {
            syrups.add(syrup);
            return this;
        }

        public IceCream build() {
            return new IceCream(this);
        }
    }
}