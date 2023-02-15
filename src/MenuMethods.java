import java.util.Scanner;

public class MenuMethods
{
    private TelefonListen telefonListen = new TelefonListen();
    private Scanner in = new Scanner(System.in);

    public void addNewUser()
    {
        System.out.println("Navn: ");
        String name = in.nextLine();
        System.out.println("Telefonnummer: ");
        int phoneNumber = in.nextInt();
        in.nextLine();
        telefonListen.addUser(name, phoneNumber);
    }

    public void searchForPhoneNumber()
    {
        System.out.println("Navn: ");
        String name = in.nextLine();
        System.out.println(telefonListen.getPhoneNumber(name));
    }

    public void deleteContactFromList()
    {
        System.out.println("Navn på den du vil slette: ");
        String name = in.nextLine();
        telefonListen.deleteContact(name);
    }

    public boolean checkIfOnTheList()
    {
        System.out.println("Navn på personen: ");
        String name = in.nextLine();
        return telefonListen.isOnTheList(name);
    }

    /*public String userInputName()
    {
        System.out.println("Navn: ");
        String name = in.nextLine();
        return name;
    }*/
}
