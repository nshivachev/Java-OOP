package InterfacesAndAbstractionEx.telephony;

import java.util.List;
import java.util.stream.Collectors;

public class Smartphone implements Browsable, Callable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();

        for (String url : urls) {
            if (containsNumber(url)) {
                sb.append("Invalid URL!").append(System.lineSeparator());
            } else {
                sb.append(String.format("Browsing: %s!", url)).append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
//        numbers.stream()
//                .map(number -> number.matches(".*\\D+.*") ? "Invalid number!" : "Calling..." + number)
//                .collect(Collectors.joining(System.lineSeparator()));

        for (String phoneNumber : numbers) {
            if (!containsOnlyNumbers(phoneNumber)) {
                sb.append("Invalid number!").append(System.lineSeparator());
            } else {
                sb.append(String.format("Calling... %s", phoneNumber)).append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }

    private static boolean containsNumber(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsOnlyNumbers(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
