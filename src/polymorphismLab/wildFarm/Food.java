package polymorphismLab.wildFarm;

public abstract class Food {

    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public Food(Integer quantity) {
        this.quantity = quantity;
    }
}
