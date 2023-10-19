package polymorphismEx.calculator;

import java.util.ArrayDeque;

public class MemorySaveOperation implements Operation {
    private ArrayDeque<Integer> memory;

    public MemorySaveOperation(ArrayDeque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        memory.push(operand);
    }

    @Override
    public boolean isCompleted() {
        return false;
    }

    @Override
    public int getResult() {
        return memory.peek();
    }
}
