package stocks.observers;

import stocks.observables.Stock;

public class Ticker implements IObserver
{
    @Override
    public void update(Object[] arguments)
    {
        Stock stock = (Stock)arguments[0];
        double newValue = (double)arguments[1];

        System.out.println(stock.getName() + " - " + newValue);
    }
}
