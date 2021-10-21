package stocks.test;

import stocks.observables.Stock;
import stocks.observers.Investor;
import stocks.observers.Ticker;

import java.time.LocalDateTime;

public class TestObserverPattern
{
    public static void main(String[] args)
    {
        //create some Observables
        Stock msft = new Stock("MSFT", 390.59, LocalDateTime.now());
        Stock amc = new Stock("AMC", 39.67, LocalDateTime.now());

        //create some observers
        Investor me = new Investor("Josh Archer", "Green River College");
        Investor spouse = new Investor("Olasope Archer", "Kaiser");
        Ticker ticker = new Ticker();

        //attach observers to observables (one to many)
        amc.addObserver(me);
        amc.addObserver(ticker);
        msft.addObserver(me);
        msft.addObserver(spouse);
        msft.addObserver(ticker);

        //make some changes and react
        amc.changeStockPrice(45.67);
        msft.changeStockPrice(370.17);
        msft.changeStockPrice(359.60);
    }
}
