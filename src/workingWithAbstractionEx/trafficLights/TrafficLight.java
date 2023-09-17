package workingWithAbstractionEx.trafficLights;

public class TrafficLight {
    Colors currentColor;

    public TrafficLight(Colors currentColor) {
        this.currentColor = currentColor;
    }

    public Colors getCurrentColor() {
        return currentColor;
    }

    public void changeColor() {
        switch (currentColor) {
            case RED:
                currentColor = Colors.GREEN;
                break;
            case GREEN:
                currentColor = Colors.YELLOW;
                break;
            case YELLOW:
                currentColor = Colors.RED;
                break;
            default:
                throw new IllegalArgumentException("Invalid color: " + currentColor);
        }
    }
}
