package stocks.observers;

import stocks.observables.Stock;

import java.time.LocalDateTime;

public class Investor implements IObserver
{
    private String fullName;
    private String company;

    public Investor(String fullName, String company)
    {
        this.fullName = fullName;
        this.company = company;
    }

    @Override
    public void update(Object[] arguments)
    {
        Stock stock = (Stock)arguments[0];
        double oldValue = (double)arguments[1];
        double newValue = (double)arguments[2];
        LocalDateTime time = (LocalDateTime)arguments[3];

        System.out.println("Investor(" + fullName + ") noticed that " + stock.getName() + " changed from " +
                oldValue + " to " + newValue + "!");
    }

    public String getFullName()
    {
        return fullName;
    }

    public String getCompany()
    {
        return company;
    }

    @Override
    public String toString()
    {
        return "Investor{" +
                "fullName='" + fullName + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
