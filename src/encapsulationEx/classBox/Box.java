package encapsulationEx.classBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        validateSideSize(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        validateSideSize(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        validateSideSize(height, "Height");
        this.height = height;
    }

    private void validateSideSize(double sideType, String sideName) {
        if (sideType <= 0) {
            throw new IllegalArgumentException(sideName + " cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea() {
        return 2 * length * width + calculateLateralSurfaceArea();
    }

    public double calculateLateralSurfaceArea() {
        return 2 * length * height + 2 * width * height;
    }

    public double calculateVolume() {
        return length * width * height;
    }
}
