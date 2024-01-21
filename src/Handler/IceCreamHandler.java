package Handler;
import IceCream.IceCream;
import IceCream.Flavor;
import IceCream.Topping;
import IceCream.Syrup;

import java.util.List;
import java.util.Map;

abstract class IceCreamHandler {
    private IceCreamHandler nextHandler;

    public IceCreamHandler setNextHandler(IceCreamHandler handler) {
        this.nextHandler = handler;
        return handler;
    }

    public void handleRequest(IceCream.Builder builder, Map<Flavor, Integer> scoops, List<Topping> toppings, List<Syrup> syrups) {
        if (nextHandler != null) {
            nextHandler.handleRequest(builder, scoops, toppings, syrups);
        }
    }
}