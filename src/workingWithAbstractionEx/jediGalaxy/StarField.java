package workingWithAbstractionEx.jediGalaxy;

public class StarField {
    int[][] starField;

    public StarField(int rows, int cols) {
        starField = new int[rows][cols];
        fillStarFiled(rows, cols);
    }

    public int getValue(int row, int col) {
        return starField[row][col];
    }

    public int getColsNumber() {
        return starField[1].length;
    }

    private void fillStarFiled(int rows, int cols) {
        int starValue = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                starField[i][j] = starValue++;
            }
        }
    }

    public void setStarField(int row, int col, int value) {
        starField[row][col] = value;
    }

    public boolean isInBound(int row, int col) {
        return row >= 0 && row < starField.length && col >= 0 && col < starField[0].length;
    }
}
