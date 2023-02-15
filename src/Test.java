public class Test
{
    private FileHandler fileHandler = new FileHandler();
    private void run()
    {
        fileHandler.loadFile();
        MenuTelefonListen menu = new MenuTelefonListen("TELEFONLISTE", "Vælg en mulighed: ",
                new String[] {
                        "1. Opret nyt medlem",
                        "2. Print hele listen",
                        "3. Søg efter et telefonnummer",
                        "4. Slet en person fra listen",
                        "5. Find ud af om en person er på listen",
                        "6. Udskriv alle navnene fra listen",
                        "9. Afslut program"});

        menu.printMenuAndReadChoice();
        fileHandler.saveFile();
    }

    public static void main(String[] args)
    {
        new Test().run();
    }
}
