package workingWithAbstractionEx.jediGalaxy;

public class Evil {
    public void move(int evilRow, int evilCol, StarField starField) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (starField.isInBound(evilRow, evilCol)) {
                starField.setStarField(evilRow, evilCol, 0);
            }

            evilRow--;
            evilCol--;
        }
    }
}
