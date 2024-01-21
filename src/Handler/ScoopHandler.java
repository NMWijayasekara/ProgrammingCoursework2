package Handler;

import IceCream.Flavor;
import IceCream.Topping;
import IceCream.IceCream;
import IceCream.Syrup;
import java.util.List;
import java.util.Map;

class ScoopHandler extends IceCreamHandler {
    @Override
    public void handleRequest(IceCream.Builder builder, Map<Flavor, Integer> scoops, List<Topping> toppings, List<Syrup> syrups) {
        for (Map.Entry<Flavor, Integer> entry : scoops.entrySet()) {
            builder.addScoop(entry.getKey(), entry.getValue());
        }
        super.handleRequest(builder, scoops, toppings, syrups);
    }
}