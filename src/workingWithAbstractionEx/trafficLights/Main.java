package workingWithAbstractionEx.trafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Colors> signals = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Colors::valueOf)
                .collect(Collectors.toList());

        List<TrafficLight> trafficLights = new ArrayList<>();

        signals.forEach(signal -> trafficLights.add(new TrafficLight(signal)));

        int updateSignalCount = Integer.parseInt(scanner.nextLine());

        while (updateSignalCount-- > 0) {
            trafficLights.forEach(trafficLight -> {
                trafficLight.changeColor();
                System.out.printf("%s ", trafficLight.getCurrentColor());
            });

            System.out.println();
        }
    }
}
