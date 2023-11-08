package designPatternsEx.factory.cake;

public class WhiteCake extends Cake {
    public WhiteCake(double diameter, double price, int pieces) {
        super(diameter, price, pieces);
    }

    @Override
    public void prepare() {
        System.out.println("Prepare White cake with diameter " + diameter);
    }

    @Override
    public void bake() {
        System.out.println("Bake White cake pieces " + pieces);
    }

    @Override
    public void box() {
        System.out.println("Box White cake for price " + price);
    }
}
