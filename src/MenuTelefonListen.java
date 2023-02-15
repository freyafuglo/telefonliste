import java.util.Arrays;
import java.util.Scanner;

public class MenuTelefonListen
{
    private String menuHeader;
    private String leadText;
    private String[] menuItems;
    private boolean validInput;
    private Scanner in = new Scanner(System.in);
    private TelefonListen telefonListen = new TelefonListen();
    private MenuMethods menuMethods = new MenuMethods();

    public MenuTelefonListen(String menuHeader, String leadText, String[] menuItems)
    {
        this.menuHeader = menuHeader;
        this.leadText = leadText;
        this.menuItems = menuItems;
    }

    void printMenu() {
        System.out.println(menuHeader);
        System.out.println(Arrays.toString(menuItems)
                .replace("[", "")
                .replace("]", "")
                .replace(", ", "\n"));
        System.out.println("\n" + leadText);
    }

    public int readChoice() {
        int menuChoice = 0;

        do {
            try {
                menuChoice = Integer.parseInt(in.nextLine());

                if (menuChoice > 0 && menuChoice <= menuItems.length || menuChoice == 9) {
                    validInput = true;

                } else {
                    System.out.println("Indtast et gyldigt punkt fra menuen.");
                    validInput = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("IKKE EN MULIGHED!");
            }

        } while (!validInput);

        return menuChoice;
    }

    public void printMenuAndReadChoice()
    {
        boolean done = false;

        do {
            printMenu();
            switch (readChoice()) {
                case 1 -> menuMethods.addNewUser();
                case 2 -> telefonListen.printPhoneList();
                case 3 -> menuMethods.searchForPhoneNumber();
                case 4 -> menuMethods.deleteContactFromList();
                case 5 -> System.out.println(menuMethods.checkIfOnTheList());
                case 6 -> telefonListen.printKeys();
                case 9 -> done = true;
            }
            System.out.println();
        } while (!done);

        System.out.println("Program afsluttet.");
    }
}

