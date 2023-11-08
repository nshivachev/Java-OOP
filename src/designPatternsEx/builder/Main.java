package designPatternsEx.builder;

import java.util.*;

public class Main {

    private static final String CREATE_COMMAND = "CREATE";
    private static final String CONTACT_INFO_COMMAND = "INFO";
    private static final String DELETE_CONTACT_COMMAND = "DELETE";
    private static final String PHONEBOOK_COMMAND = "PHONEBOOK";
    private static final String END_COMMAND = "END";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Phonebook phonebook = new Phonebook();

        String command;

        while (!END_COMMAND.equals(command = scanner.nextLine())) {
            switch (command) {
                case CREATE_COMMAND -> {
                    List<String> contactInfo = readContactInfo(scanner);
                    try {
                        phonebook.addContact(Contact.builder()
                                .withName(contactInfo.get(0))
                                .withNumber(contactInfo.get(1))
                                .withCompany(contactInfo.get(2))
                                .withTitle(contactInfo.get(3))
                                .withEmail(contactInfo.get(4))
                                .withWebsite(contactInfo.get(5))
                                .withBirthday(contactInfo.get(6))
                                .build());
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case CONTACT_INFO_COMMAND -> {
                    try {
                        System.out.println(phonebook.getContactByName(scanner.nextLine()));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case DELETE_CONTACT_COMMAND -> {
                    try {
                        phonebook.deleteContactByName(scanner.nextLine());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case PHONEBOOK_COMMAND -> phonebook.getAllContacts().forEach(System.out::println);
            }
        }
    }

    private static List<String> readContactInfo(Scanner input) {
        List<String> contactInfo = new ArrayList<>();

        System.out.print("Name: ");
        contactInfo.add(input.nextLine());

        System.out.print("Number: ");
        contactInfo.add(input.nextLine());

        System.out.print("Company: ");
        contactInfo.add(input.nextLine());

        System.out.print("Title: ");
        contactInfo.add(input.nextLine());

        System.out.print("Email: ");
        contactInfo.add(input.nextLine());

        System.out.print("Website: ");
        contactInfo.add(input.nextLine());

        System.out.print("Birthday: ");
        contactInfo.add(input.nextLine());

        return contactInfo;
    }
}
