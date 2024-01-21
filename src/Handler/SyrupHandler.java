package Handler;

import IceCream.Syrup;
import IceCream.IceCream;
import IceCream.Flavor;
import IceCream.Topping;
import java.util.List;
import java.util.Map;

class SyrupHandler extends IceCreamHandler {
    @Override
    public void handleRequest(IceCream.Builder builder, Map<Flavor, Integer> scoops, List<Topping> toppings, List<Syrup> syrups) {
        for (Syrup syrup : syrups) {
            builder.addSyrup(syrup);
        }
        super.handleRequest(builder, scoops, toppings, syrups);
    }
}