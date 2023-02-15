import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

public class FileHandler
{
    private File telefonlisten = new File("telefonlisten.txt");
    private TelefonListen tf = new TelefonListen();

    public void saveFile()
    {
        try
        {
            PrintStream printStream = new PrintStream(new FileOutputStream(telefonlisten));
            {
                Iterator<String> itr = tf.getPhonelist().keySet().iterator();

                while (itr.hasNext())
                {
                    String current = itr.next();
                    printStream.println(current + ";" +  tf.getPhonelist().get(current));
                }
            }
            printStream.close();
        }
        catch (IOException e)
        {
            System.out.println("I/O exception: " + e.getMessage());
        }
    }

    public void loadFile(){
        try
        {
            Scanner fileScanner = new Scanner(telefonlisten);
            while (fileScanner.hasNext())
            {
                Scanner tokenScanner = new Scanner(fileScanner.nextLine());
                tokenScanner.useDelimiter(";");
                String name = tokenScanner.next();
                int phoneNumber = Integer.parseInt(tokenScanner.next());
                tf.addUser(name, phoneNumber);
            }
            fileScanner.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
