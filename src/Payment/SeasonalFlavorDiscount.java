package Payment;

import IceCream.IceCream;
import IceCream.Flavor;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SeasonalFlavorDiscount implements Promotion {
    private String discountedFlavor;
    private double discountPercentage;
    private Date startDate;
    private Date endDate;

    public SeasonalFlavorDiscount(String discountedFlavor, double discountPercentage, Date startDate, Date endDate) {
        this.discountedFlavor = discountedFlavor;
        this.discountPercentage = discountPercentage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean isApplicable(Date currentDate) {
        return currentDate.after(startDate) && currentDate.before(endDate);
    }

    @Override
    public void applyPromotion(List<IceCream> iceCreams) {
        for (IceCream iceCream : iceCreams) {
            Map<Flavor, Integer> scoops = iceCream.getScoops();
            for (Map.Entry<Flavor, Integer> entry : scoops.entrySet()) {
                Flavor flavor = entry.getKey();
                if (flavor.getName().equals(discountedFlavor)) {
                    int scoopCount = entry.getValue();
                    double currentPrice = iceCream.getTotalPrice();
                    double discountedPrice = currentPrice * (1 - discountPercentage / 100);
                    iceCream.setTotalPrice(discountedPrice * scoopCount);
                }
            }
        }
    }
}