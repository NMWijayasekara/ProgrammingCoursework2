package Payment;

import java.util.HashMap;
import java.util.Map;

public class SimpleLoyaltyProgram implements LoyaltyProgram {
    private Map<String, Integer> customerPoints;

    public SimpleLoyaltyProgram() {
        this.customerPoints = new HashMap<>();
    }

    @Override
    public void earnPoints(double amount) {
        // Assume 1 point for every $10 spent
        int pointsEarned = (int) (amount / 10);
        // Logic to update customer's loyalty points
        System.out.println("Earned " + pointsEarned + " points for this purchase.");
    }
}