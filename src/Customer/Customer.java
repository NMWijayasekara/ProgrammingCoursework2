package Customer;

import IceCream.IceCream;
import IceCream.Flavor;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String email;
    private String phone;
    private final List<Flavor> favoriteFlavors;
    private final List<IceCream> favoriteIceCreams;

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.favoriteFlavors = new ArrayList<>();
        this.favoriteIceCreams = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public List<Flavor> getFavoriteFlavors() {
        return favoriteFlavors;
    }
    public List<IceCream> getFavoriteIceCreams() {
        return favoriteIceCreams;
    }
    public void addFavoriteFlavors(Flavor flavor) {
        this.favoriteFlavors.add(flavor);
    }
    public void addFavoriteIceCream(IceCream iceCream) {
        this.favoriteIceCreams.add(iceCream);
    }
}
