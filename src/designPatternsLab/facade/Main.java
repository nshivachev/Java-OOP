package designPatternsLab.facade;

public class Main {
    public static void main(String[] args) {
        Car car = new CarBuilderFacade()
                .info()
                .withType("Porsche")
                .withColor("Orange")
                .withNumberOfDoors(3)
                .built()
                .inCity("Zuffenhausen")
                .atAddress("Leshperska str 123")
                .build();

        System.out.println(car);
    }
}
