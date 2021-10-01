package singleton;

/**
 * This class will be designed to be a singleton.
 * Only a single singleton.CupOfCoffee object should exist
 * in our program at one time.
 */
public class CupOfCoffee
{
    private String contents;
    private boolean full;
    private boolean cold;

    //store a single object (only one ever)
    private static CupOfCoffee instance;

    private CupOfCoffee(String contents, boolean full,
                       boolean cold)
    {
        this.contents = contents;
        this.full = full;
        this.cold = cold;
    }

    public static CupOfCoffee getSingleton()
    {
        if (instance == null)
        {
            instance = new CupOfCoffee("Cold Brew", true, true);
        }

        return instance;
    }

    public String getContents()
    {
        return contents;
    }

    public boolean isFull()
    {
        return full;
    }

    public boolean isCold()
    {
        return cold;
    }

    @Override
    public String toString()
    {
        return "singleton.CupOfCoffee{" +
                "contents='" + contents + '\'' +
                ", full=" + full +
                ", cold=" + cold +
                '}';
    }
}
