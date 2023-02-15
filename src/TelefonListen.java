import java.security.Key;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TelefonListen
{
    private static Map<String, Integer> phonelist = new HashMap<>();

    public static Map<String, Integer> getPhonelist()
    {
        return phonelist;
    }

    public void addUser(String name, int phoneNumber)
    {
        phonelist.put(name, phoneNumber);
    }

    public int getPhoneNumber(String name)
    {
        Iterator<String> itr = phonelist.keySet().iterator();
        int phoneNumber = 0;

        while (itr.hasNext())
        {
            String current = itr.next();
            if (name.equals(current))
            {
                phoneNumber = phonelist.get(name);
            }
        }
        return phoneNumber;
    }

    public void deleteContact(String name)
    {
        Iterator<String> itr = phonelist.keySet().iterator();
        boolean keepGoing = true;

        while (itr.hasNext() && keepGoing)
        {
            String current = itr.next();
            if (name.equals(current))
            {
                phonelist.remove(name);
                keepGoing = false;
            }
        }
    }

    public boolean isOnTheList(String name)
    {
        boolean isOnTheList = false;
        Iterator<String> itr = phonelist.keySet().iterator();

        while (itr.hasNext())
        {
            String current = itr.next();
            if (name.equals(current))
            {
                isOnTheList = true;
            }
        }

        return isOnTheList;
    }

    public void printKeys()
    {
        System.out.println(phonelist.keySet());
    }

    public void printPhoneList()
    {
        Iterator<String> itr = phonelist.keySet().iterator();

        while (itr.hasNext())
        {
            String current = itr.next();
            System.out.println(current + ";" +  phonelist.get(current));
        }
    }

    @Override
    public String toString()
    {
        return "Telefonlisten: \n" +
                phonelist;
    }
}
