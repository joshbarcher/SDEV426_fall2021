package stocks.observables;

import stocks.observers.Investor;

import java.time.LocalDateTime;
import java.util.List;

//this class represents the value of a stock at a certain time
public class Stock extends Observable
{
    private String name;
    private double value;
    private LocalDateTime time;

    public Stock(String name, double value, LocalDateTime time)
    {
        this.name = name;
        this.value = value;
        this.time = time;
    }

    public void changeStockPrice(double newValue)
    {
        //save the old value
        double oldValue = this.value;

        this.value = newValue; //update the value of the stock
        this.time = LocalDateTime.now(); //update the timestamp

        //make some noise, something changed!
        notify(this, oldValue, newValue, time); //notify observers
    }

    public void stocksSplit()
    {
        notify(this);
    }

    public String getName()
    {
        return name;
    }

    public double getValue()
    {
        return value;
    }

    public LocalDateTime getTime()
    {
        return time;
    }

    @Override
    public String toString()
    {
        return "Stock{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", time=" + time +
                '}';
    }
}
