package workingWithAbstractionEx.jediGalaxy;

public class Jedi {
    public int move(int jediRow, int jediCol, StarField starField) {
        int collectedStar = 0;

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
