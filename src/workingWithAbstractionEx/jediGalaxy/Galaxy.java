package workingWithAbstractionEx.jediGalaxy;

public class Galaxy {
    StarField starField;
    Jedi jedi;
    Evil evil;

    public Galaxy(StarField starField) {
        this.starField = starField;
        this.jedi = new Jedi();
        this.evil = new Evil();
    }

    public void moveEvil(int evilRow, int evilCol) {
        evil.move(evilRow, evilCol, starField);
    }

    public long moveJedi(int jediRow, int jediCol) {
        return jedi.move(jediRow, jediCol, starField);
    }
}
