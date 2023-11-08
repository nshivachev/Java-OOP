package designPatternsEx.factory.cake;

public class BiscuitCake extends Cake {

    public BiscuitCake(double diameter, double price, int pieces) {
        super(diameter, price, pieces);
    }

    @Override
    public void prepare() {
        System.out.println("Prepare Biscuit cake with diameter " + diameter);
    }

    @Override
    public void bake() {
        System.out.println("Bake Biscuit cake pieces " + pieces);
    }

    @Override
    public void box() {
        System.out.println("Box Biscuit cake for price " + price);
    }
}
