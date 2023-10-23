package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart;

public class Special extends OrderItem {
    @Override
    public double getPrice() {
        double price = getQuantity() * 4.0;
        int setsOfThree = getQuantity() / 3;
        price -= setsOfThree * 2.0;

        return price;
    }
}
