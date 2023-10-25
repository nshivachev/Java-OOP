package solidEx.utilities;

public class LogFile implements File {
    private StringBuilder inMemoryContent;

    public LogFile() {
        this.inMemoryContent = new StringBuilder();
    }

    @Override
    public void write(String line) {
        inMemoryContent.append(line)
                .append(System.lineSeparator());
    }

    @Override
    public int getSize() {
        return inMemoryContent.chars().filter(Character::isAlphabetic).sum();
    }
}
