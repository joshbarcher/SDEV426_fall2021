package singleton;

public class CoffeeTester
{
    public static void main(String[] args)
    {
        //singleton should stop this...
        /*CupOfCoffee morningCoffee = new CupOfCoffee("Starbucks", false, true);
        CupOfCoffee midDayCoffee = new CupOfCoffee("Cold Brew", true, true);*/

        //provide a global point of access for the singleton
        CupOfCoffee singleton = CupOfCoffee.getSingleton();
        System.out.println(singleton);

        CupOfCoffee another = CupOfCoffee.getSingleton();
        System.out.println(singleton == another); //compare mem addresses

        CupOfCoffee aThird = CupOfCoffee.getSingleton();
        System.out.println(aThird == another); //compare mem addresses
    }
}
