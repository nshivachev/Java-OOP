package designPatternsLab.command;

public class IncreaseProductPriceCommand implements Command {
    private final Product product;
    private final int amount;

    public IncreaseProductPriceCommand(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    @Override
    public void executeAction() {
        product.increasePrice(amount);
        System.out.printf("The price for the %s has been increased by %d$.%n", product.getName(), amount);

    }
}
