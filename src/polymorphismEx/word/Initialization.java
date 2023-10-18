package polymorphismEx.word;

public class Initialization {

    private StringBuilder text;

    public Initialization(StringBuilder text) {
        this.text = text;
    }

    public static CommandInterface buildCommandInterface(StringBuilder text) {
        CommandInterface commandInterface = new CommandImpl(text);
        commandInterface.init();
        return commandInterface;
    }
}
