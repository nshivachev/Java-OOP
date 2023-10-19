package polymorphismEx.calculator;

import java.util.ArrayDeque;

public class CalculationEngine {
    private int result;
    private Operation currentOperation;
    private ArrayDeque<Integer> memory;

    public CalculationEngine() {
        this.result = 0;
        this.currentOperation = null;
        this.memory = new ArrayDeque<>();
    }

    int getCurrentResult() {
        return this.result;
    }

    public ArrayDeque<Integer> getMemory() {
        return memory;
    }

    public void pushNumber(int number) {
        if (this.currentOperation != null) {
            currentOperation.addOperand(number);

            if (currentOperation.isCompleted()) {
                this.result = currentOperation.getResult();
                this.currentOperation = null;
            }
        } else {
            this.result = number;
        }
    }

    void pushOperation(Operation operation) {
        if (operation.isCompleted()) {
            this.pushNumber(operation.getResult());
        } else {
            this.currentOperation = operation;
            this.pushNumber(this.result);
        }
    }
}
