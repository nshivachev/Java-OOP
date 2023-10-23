package solidLab.p02_OpenClosedPrinciple.p03_ShoppingCart;

public class Weight extends  OrderItem {
    @Override
    public double getPrice() {
        return getQuantity() * 4.0 / 1000;
    }
}
