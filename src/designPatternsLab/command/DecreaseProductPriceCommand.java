package designPatternsLab.command;

public class DecreaseProductPriceCommand implements Command {
    private final Product product;
    private final int amount;

    public DecreaseProductPriceCommand(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    @Override
    public void executeAction() {
        product.decreasePrice(amount);
        System.out.printf("The price for the %s has been decreased by %d$.%n", product.getName(), amount);

    }
}
