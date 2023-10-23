package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart;

public class Each extends OrderItem {
    @Override
    public double getPrice() {
        return getQuantity() * 5.0;
    }
}
