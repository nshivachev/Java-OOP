package designPatternsEx.factory.cake;

public class SpinachCake extends Cake {
    public SpinachCake(double diameter, double price, int pieces) {
        super(diameter, price, pieces);
    }

    @Override
    public void prepare() {
        System.out.println("Prepare Spinach cake with diameter " + diameter);
    }

    @Override
    public void bake() {
        System.out.println("Bake Spinach cake pieces " + pieces);
    }

    @Override
    public void box() {
        System.out.println("Box Spinach cake for price " + price);
    }
}
