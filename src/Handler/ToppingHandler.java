package Handler;

import IceCream.Topping;
import IceCream.IceCream;
import IceCream.Flavor;
import IceCream.Syrup;
import java.util.List;
import java.util.Map;

class ToppingHandler extends IceCreamHandler {
    @Override
    public void handleRequest(IceCream.Builder builder, Map<Flavor, Integer> scoops, List<Topping> toppings, List<Syrup> syrups) {
        for (Topping topping : toppings) {
            builder.addTopping(topping);
        }
        super.handleRequest(builder, scoops, toppings, syrups);
    }
}