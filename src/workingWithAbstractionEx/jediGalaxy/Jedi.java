package workingWithAbstractionEx.jediGalaxy;

public class Jedi {
    public long move(int jediRow, int jediCol, StarField starField) {
        long collectedStar = 0;

        while (jediRow >= 0 && jediCol < starField.getColsNumber()) {
            if (starField.isInBound(jediRow, jediCol)) {
                collectedStar += starField.getValue(jediRow, jediCol);
            }

            jediRow--;
            jediCol++;
        }

        return collectedStar;
    }
}
