package designPatternsEx.factory.cake;

public class ChocolateCake extends Cake {
    public ChocolateCake(double diameter, double price, int pieces) {
        super(diameter, price, pieces);
    }

    @Override
    public void prepare() {
        System.out.println("Prepare Chocolate cake with diameter " + diameter);
    }

    @Override
    public void bake() {
        System.out.println("Bake Chocolate cake pieces " + pieces);
    }

    @Override
    public void box() {
        System.out.println("Box Chocolate cake for price " + price);
    }
}
