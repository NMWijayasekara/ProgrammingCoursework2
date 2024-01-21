package Payment;

import IceCream.IceCream;
import java.util.Date;
import java.util.List;


public interface Promotion {
    boolean isApplicable(Date currentDate);
    void applyPromotion(List<IceCream> iceCreams);
}
